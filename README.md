# myDevContainer
test and use dev container

# Create a local docker registry

    $ docker run -d -p 5001:5000 --restart always --name customRegistry registry:2.8.3

# Push ubuntu image in registry

    $ docker pull ubuntu:24.04
    $ docker tag ubuntu:24.04 localhost:5001/ubuntu:24.04
    $ docker push localhost:5001/ubuntu:24.04
    $ docker image rm ubuntu:24.04

# Create custom image

In the folder docker

    $ docker build -t env-java-21-dev-container .
    $ docker tag env-java-21-dev-container:latest localhost:5001/env-java-21-dev-container:1.0
    $ docker image rm env-java-21-dev-container:latest
    $ docker push localhost:5001/env-java-21-dev-container:1.0

In the folder docker

    $ docker build -f Dockerfile17 -t env-java-17-dev-container .
    $ docker tag env-java-17-dev-container:latest localhost:5001/env-java-17-dev-container:1.0
    $ docker image rm env-java-17-dev-container:latest
    $ docker push localhost:5001/env-java-17-dev-container:1.0

# Push postgre image in registry

    $ docker pull postgres:16.3
    $ docker tag postgres:16.3 localhost:5001/postgres:16.3
    $ docker push localhost:5001/postgres:16.3
    $ docker image rm postgres:16.3

