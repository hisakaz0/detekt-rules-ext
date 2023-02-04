package io.github.hisakaz0.detekt.rules.ext

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.rules.KotlinCoreEnvironmentTest
import io.gitlab.arturbosch.detekt.test.compileAndLintWithContext
import io.kotest.matchers.collections.shouldHaveSize
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.junit.jupiter.api.Test

@KotlinCoreEnvironmentTest
internal class LongMethodTest(private val env: KotlinCoreEnvironment) {

    @Test
    fun `report long method`() {
        val code = """
            fun shortMethod() {
                ${(0..100).map { "val num$it = $it" }.joinToString("\n")}
            }
        """
        val findings = LongMethod(Config.empty).compileAndLintWithContext(env, code)
        findings shouldHaveSize 1
    }

    @Test
    fun `doesn't report short method`() {
        val code = """
            fun shortMethod() {
                ${(0..50).map { "val num$it = $it" }.joinToString("\n")}
            }
        """
        val findings = LongMethod(Config.empty).compileAndLintWithContext(env, code)
        findings shouldHaveSize 0
    }

    @Test
    fun `report long composable`() {
        val code = """
            @Composable
            fun shortMethod() {
                ${(0..110).map { "val num$it = $it" }.joinToString("\n")}
            }
        """
        val findings = LongMethod(Config.empty).compileAndLintWithContext(env, code)
        findings shouldHaveSize 1
    }

    @Test
    fun `doesn't report short composable`() {
        val code = """
            @Composable
            fun shortMethod() {
                ${(0..90).map { "val num$it = $it" }.joinToString("\n")}
            }
        """
        val findings = LongMethod(Config.empty).compileAndLintWithContext(env, code)
        findings shouldHaveSize 0
    }
}
