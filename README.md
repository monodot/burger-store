# burger-store

A demo application for ordering tasty burgers.

## Running locally

Use the included docker-compose file, which....
 
- builds a container image of the burger-store app and runs it, with the [OpenTelemetry Java agent][javaagent] attached, which tries to push metrics to the Collector on port 4317
- runs a local OpenTelemetry [Collector][collector] -- this standalone component collects traces and telemetry from the application and pushes it to an application which implements the OpenTelemetry receiving API

The OpenTelemetry collector sends data to an instance of Tempo - I've tested this with _Grafana Cloud_.
 
```
export TEMPO_AUTH_STRING="$(echo -n "<your user id>:<your api key>" | base64)
export TEMPO_ENDPOINT=tempo-eu-west-0.grafana.net:443

podman-compose -f docker-compose.yml build
podman-compose -f docker-compose.yml up
```

To test the API (and send traces to Tempo):

```
curl http://localhost:8083/menu
```

## How this was created

1.  Use the Spring Initializr at start.spring.io

2.  Install a JDK locally, using sdkman, e.g. `sdk install java 11.0.15-tem` (for Eclipse Temurin 17)


[collector]: https://opentelemetry.io/docs/collector/
[javaagent]: https://opentelemetry.io/docs/instrumentation/java/automatic/
