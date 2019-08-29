Collecting parameters into a key-value map with [jbock.](https://github.com/h908714124/jbock)

````sh
gradle run --args='-horse=12 -sheep=4'
gradle run --args='--help'
gradle -Duser.language=es run --args='--help'
````

Or [compile to native](https://github.com/oracle/graal/releases) first:

````sh
gradle shadowJar
native-image --no-fallback -H:ResourceConfigurationFiles=config-native-image/resource-config.json -jar build/libs/jbock-map-example-all.jar map_example
./map_example -horse=12 -sheep=4
./map_example --help
./map_example -Duser.language=es --help
````

