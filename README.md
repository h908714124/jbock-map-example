# jbock gradle test

Tested with gradle 4.10

````sh
gradle clean distTar
cd build/distributions/
tar xf jbock-gradle-example-1.0-SNAPSHOT.tar
cd jbock-gradle-example-1.0-SNAPSHOT/bin
./jbock-gradle-example foo bar
````
