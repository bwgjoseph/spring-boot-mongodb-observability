# Spring Boot MongoDB Observability

## Start MongoDB

```bash
docker compose up -d
```

Note: The port for MongoDB is set to `28017`

## Application

Run the following curl command to trigger an API to generate the traces

```bash
curl localhost:8080/pokemon
```

The log will appear with traceId and spanId

```console
2025-01-09T23:28:19.284+08:00 DEBUG 19868 --- [spring-boot-mongodb-observability] [nio-8080-exec-1] [spring-boot-mongodb-observability,98918740e795120cb0af718151b7b8e5,62623714463de384].s.d.m.o.MongoObservationCommandListener : Instrumenting the command started event
```

Ignore the error about exporting spans

```console
Failed to export spans. The request could not be executed. Full error message: Failed to connect to localhost/[0:0:0:0:0:0:0:1]:4318
```

## Monitoring Stack

### Grafana

To configure datasource in `./container/provisioning/datasources`, create 1 yaml per source. To configure for `jsonData`, one trick is to manually configure via the UI, and launch devtools, monitor the network and look out for `<datasource-uid>?accesscontrol=true` which will show how the `jsonData` is formed. Or even better, call `http://localhost:3000/api/datasources` to extract it.

## References

- [Spring Data MongoDB Observability](https://docs.spring.io/spring-data/mongodb/reference/observability/observability.html)
- [spring-boot-monitoring](https://github.com/cristianprofile/spring-boot-monitoring)
- [observability-with-spring-boot-3](https://spring.io/blog/2022/10/12/observability-with-spring-boot-3)
- [grafana-provisioning](https://grafana.com/docs/grafana/latest/administration/provisioning/)
- [grafana-sample-datasources](https://fossies.org/linux/grafana/devenv/datasources.yaml)
  - [tempo](https://grafana.com/docs/grafana/latest/datasources/tempo/configure-tempo-data-source/#provision-the-data-source)