# detekt-rules-ext

custom detekt extension rules for [detekt][detekt]

## setup

add dependencies to this.

```kotlin
repositories {
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
}

dependencies {
    detektPlugins("com.github.hisakaz0:detekt-rules-ext:1.0.0")
}
```

## configuration

disable default rule to avoid conflict.
```yaml
complexity:
   LongMethod:
      active: false
```

then, configure custom rules.
      
```yaml
ExtComposeRuleSet:
   LongMethod:
      active: true
      threshold: 60         # for normal function
      composeThreshold: 100 # for composable function
```

[detekt]: https://github.com/detekt/detekt

[create_template]: https://github.com/detekt/detekt-custom-rule-template/generate

[maven_central]: https://search.maven.org/

[custom_rule_documentation]: https://detekt.github.io/detekt/extensions.html

[jitpack]: https://jitpack.io/
