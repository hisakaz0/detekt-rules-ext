package io.github.hisakaz0.detekt.rules.ext

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class ExtComposeRuleSetProvider : RuleSetProvider {
    override val ruleSetId: String = "ExtComposeRuleSet"

    override fun instance(config: Config): RuleSet {
        return RuleSet(
            ruleSetId,
            listOf(
                LongMethod(config),
            ),
        )
    }
}
