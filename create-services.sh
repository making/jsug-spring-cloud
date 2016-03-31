#!/bin/sh

cf create-service p-service-registry standard demo-jsug-eureka
cf create-service p-circuit-breaker-dashboard standard demo-jsug-hystrix
