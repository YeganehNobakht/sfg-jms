This is a sample for java messaging system with activemq.

Running the activemq image:

There are different methods to run a Docker image, from interactive Docker to Kubernetes and Docker Compose. This documentation will cover only Docker with an interactive terminal mode. You should refer to the appropriate documentation for more information around other execution methods.

To run ActiveMQ with AMQP, JMS and the web console open (if your are running 2.3.0 or later), run the following command:

docker run -it --rm -p 8161:8161 -p 61616:61616 vromero/activemq-artemis

After a few seconds you'll see in the output a block similar to:

_        _               _
/ \  ____| |_  ___ __  __(_) _____
/ _ \|  _ \ __|/ _ \  \/  | |/  __/
/ ___ \ | \/ |_/  __/ |\/| | |\___ \
/_/   \_\|   \__\____|_|  |_|_|/___ /
Apache ActiveMQ Artemis x.x.x

HH:mm:ss,SSS INFO  [...] AMQ101000: Starting ActiveMQ Artemis Server


At this point you can open the web server port at 8161 and check the web console using the default username and password of artemis / simetraehcapa.

Setting the username and password:

If you wish to change the default username and password of artemis / simetraehcapa, you can do so with the ARTEMIS_USERNAME and ARTEMIS_PASSWORD environment variables:

docker run -it --rm -e ARTEMIS_USERNAME=myuser -e ARTEMIS_PASSWORD=otherpassword vromero/activemq-artemis

Setting the memory values
By default this image does leverage the new features that came in Java 8u131 related to memory ergonomics in containerized environments, more information about it here.

It does use a -XX:MaxRAMFraction=2 meaning that half of the memory made avaiable to the container will be used by the Java heap, leaving the other half for other types of Java memory and other OS purposes. However, in some circumstances it might be advisable to fine tune the memory to manual values, in that case you can set the memory that you application needs by using the parameters ARTEMIS_MIN_MEMORY and ARTEMIS_MAX_MEMORY:

docker run -it --rm -e 'ARTEMIS_MIN_MEMORY=1512M' -e 'ARTEMIS_MAX_MEMORY=3048M' vromero/activemq-artemis
The previous example will launch Apache ActiveMQ Artemis in docker with 1512 MB of memory, with a maximum usage of 3048 MB of memory. The format of the values passed is the same than the format used for the Java -Xms and -Xmx parameters and its documented here.

This document is fully available in https://github.com/vromero/activemq-artemis-docker.