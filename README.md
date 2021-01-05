This sample project shows how to collect
parameters into a hash map with [jbock.](https://github.com/h908714124/jbock)

It also shows how to use a ResourceBundle for internationalization.

````sh
./gradlew run --args='-- -horse=12 -sheep=4'
./gradlew run --args='--help'
./gradlew -Duser.language=es run --args='--help'
````
