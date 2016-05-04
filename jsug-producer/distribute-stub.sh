#!/bin/sh

./mvnw clean accurest:convert accurest:generateStubs
version=`./mvnw help:evaluate -Dexpression=project.version | egrep -v '(^\[INFO])'`

for d in 'jsug-consumer';do
    pushd ../${d}
        distdir=src/test/resources/m2repo/repository/com/example/jsug-producer/${version}
        mkdir -p ${distdir}
    popd
    cp target/*-stubs.jar ../${d}/${distdir}
done