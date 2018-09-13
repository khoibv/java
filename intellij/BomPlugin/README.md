# Intellij IDEA BOM remover plugin
---
Remove BOM (byte of mark - description [here](https://dzone.com/articles/what-does-utf-8-bom-mean)) from file/files in folder


### Development

- Open Gradle tab (normally it sit in right panel of IntelliJ IDEA)
- Run `intellij` -> `runIde` task

### Testing
- Install plugin from disk (File -> Settings -> Plugins -> Install plugin from disk), try and fix any bug occurs

### Publish
- Change identifier in `gradle.properties`
- Open Gradle tab (normally it sit in right panel of IntelliJ IDEA)
- Run `intellij` -> `publishPlugin` task
