# Udger-local-api-v4

User-Agent parser v4 microservice with a REST API, intended to run in Docker.

## Description

Udger-local-api-v4 is an application that runs a scalable pool of Udger parsers. It exposes a REST API, can be easily containerized with Docker, and used as a microservice. The project provides a basic Dockerfile based on **Alpine Linux** and uses **Meecrowave** (Jakarta EE/MicroProfile) for high efficiency.

## Project components

The project consists of the following components:

* [REST API description](https://github.com/udger/udger-local-api-v4/blob/master/openapi.yaml) in [OpenAPI](https://swagger.io) format.
* Java 17 Maven project, running on Java 25 in Docker.
* [Dockerfile](https://github.com/udger/udger-local-api-v4/blob/master/Dockerfile) based on [AlpineLinux + Java 25](https://hub.docker.com/_/eclipse-temurin) with the [Meecrowave](http://openwebbeans.apache.org/meecrowave/index.html) microprofile.
* Simple [build & run](https://github.com/udger/udger-local-api-v4/blob/master/buildAndRun.sh) script. Builds the project, builds the Docker image, and runs the Docker container.
* [Testing scripts](https://github.com/udger/udger-local-api-v4/tree/master/utils) in Python.
* [Hosted Docker image](https://hub.docker.com/r/udgercom/udger-local-api-v4/) on [Docker Hub](https://hub.docker.com/).

## Quick start

* Run the [`buildAndRun.sh`](https://github.com/udger/udger-local-api-v4/blob/master/buildAndRun.sh) script.

## Application parameters

Udger-local-api-v4 can be configured using the following Java system properties:

* `-Dudger.poolsize=N` where `N` is the number of parsers in the pool. Default: `5`.
* `-Dudger.cachesize=N` where `N` is the number of items in the parser’s LRU cache. Default: `10000`.
* `-Dudger.clientkey=KEY` where `KEY` is the client key used to access the DB file from `http://data.udger.com/`. Default: empty.
* `-Dudger.db=dbFile` where `dbFile` is the path to the database file. Default: `/udgerdb/udgerdb_v4.dat`.
* `-Dudger.autoupdate.time=4:42` schedules the daily auto-update time (HH:mm format), e.g., `04:42`.

## Use the full `udgerdb_v4.dat`

* Replace `udgerdb_test_v4.dat` with the full database `udgerdb_v4.dat` in the [`Dockerfile`](https://github.com/udger/udger-local-api-v4/blob/master/Dockerfile).

## Examples

* `parse/ua`

```
wget http://localhost:8080/udger-local-api-v4/parse/ua/Mozilla%2F5.0+%28Windows+NT+10.0%3B+WOW64%3B+rv%3A40.0%29+Gecko%2F20100101+Firefox%2F40.0
```

* `parse/ua-v4`

```
curl -X POST -H "Content-Type: application/xml" -d '<parseUaV4Request>
  <uaString></uaString>
  <secChUa>" Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97"</secChUa>
  <secChUaFullVersionList></secChUaFullVersionList>
  <secChUaMobile>?0</secChUaMobile>
  <secChUaFullVersion>"97.0.4692.71"</secChUaFullVersion>
  <secChUaPlatform></secChUaPlatform>
  <secChUaPlatformVersion></secChUaPlatformVersion>
  <secChUaModel></secChUaModel>
</parseUaV4Request>' http://localhost:8080/udger-local-api-v4/parse/ua-v4
```

* `parse/ip`

```
wget http://localhost:8080/udger-local-api-v4/parse/ip/12.118.188.126
```

* `statistic`

```
wget http://localhost:8080/udger-local-api-v4/statistic
```

* `set/updatedata`

```
curl -F 'file=@udgerdb_v4.dat' http://127.0.0.1:8080/udger-local-api-v4/set/datafile
```
