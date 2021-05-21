# Meplato Store API Demo

This is a simple demo project illustrating the usage of the
[Meplato Store API for Java](https://github.com/meplato/store2-java-client).

## Prerequisites

* Java 1.8
* Maven
* Your Meplato Store API token

## Install

The demo comes with a local JAR that needs to be installed first:

```sh
mvn install:install-file -Dfile=lib/meplato-store2-2.1-SNAPSHOT.jar -Dversion=2.1-SNAPSHOT -DgroupId=com.meplato -DartifactId=meplato-store2 -Dpackaging=jar
```

## Compile

Compile with:

```sh
mvn install
```

## Run

The example lists your catalogs found in Store. You need to pass
your Meplato Store API token via an argument to `storedemo`, or
set the `STORE_TOKEN` environment variable. Then run:

```sh
$ export STORE_TOKEN=my-secret-token
$ ./storedemo
You have 1 catalog(s).
Catalog with ID=1234 has name Testkatalog.
```

## License

Copyright (C) 2017-present Meplato GmbH. All rights reserved.
