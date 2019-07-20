Collecting parameters into a key-value map with [jbock.](https://github.com/h908714124/jbock)

````sh
gradle clean run --args='-Xhorse=12 -Xsheep=4'
gradle clean run --args='--help'
gradle -Duser.language=es clean run --args='--help'
````

Or [compile to native](https://github.com/oracle/graal/releases) first:

````sh
gradle shadowJar
native-image --no-fallback -H:IncludeResourceBundles=de.h90.example.bundle.MyBundle -jar build/libs/jbock-map-example-all.jar map_example
./map_example -Xhorse=12 -Xsheep=4
./map_example --help
````

