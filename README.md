# jbock gradle test

Tested with gradle 4.10

## build and run

````sh
gradle clean
cd core/
gradle run --args 'foo bar'
````

## Configure IDEA

* Go to `File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle`, uncheck "create separate module per source set"
* In `codegen` module, right-click on `build/generated/source/apt/main` and mark as generated sources root

IDEA should not find any compile errors in Main.java now.
