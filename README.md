# jbock gradle test

Tested with these gradle versions: `4.10`, `5.0`

## build and run

````sh
gradle clean run --args='foo bar'
gradle clean run --args='--help'
````

## Configure IDEA

* Go to `File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle`, uncheck "create separate module per source set"
* In `codegen` module, right-click on `build/generated/source/apt/main` and mark as generated sources root

IDEA should not find any compile errors in Main.java now.
