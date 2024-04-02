TLA Kafka Cluster 
==============
This repo is a clone of the Kafka cluster used to route xAPI within the ADL's TLA reference implementation.  

It contains the container definitions and scripts for standing up up a 3/3 SASL-authenticated Kafka cluster with Docker. Images are slightly modified versions of the Confluent Docker images for both Zookeeper and Kafka, with the only adjustments being to relay Compose variables to the Kafka/Zookeeper config files.

Note: This is a relatively humble configuration.  We run this within a `t3.xlarge` EC2 instance, but more robust systems will want to add brokers and split them across machines / availability zones.

## What's in the box
Everything necessary to stand up the Kafka cluster, including:
- `docker-compose.yml`: The Compose file we use to stand up:
  - 3 Kafka Brokers
  - 3 Zookeeper nodes
- **Scripts to maintain the cluster:**
  - `tla-topics.txt`: Text file with the Kafka topics.
  - `export-topics.sh`: Creates the Kafka topics (this is necessary as we disable auto-topics).
  - `list-topics.sh`: Lists all topics available in the cluster.

## Setup
We've tried to remove all pain from setting up a Kafka cluster with SASL authentication, but Kafka can still be a bit clunky to get running.

First, you will need to change the `.env` file accordingly:
  - **CHANGE**: the `KAFKA_HOST` to an accessible IP / domain name running this.  This must match how your Kafka consumers / producers refer to it.
  - **CHANGE**: the `KAFKA_SASL_USER` and `KAFKA_SASL_PASS` to something more secure.
    
### TL;DR Initial Setup
1. `git clone https://github.com/vbhayden/sasl-kafka-cluster`
1. `cd sasl-kafka-cluster`
1. `sudo ./install-reqs.sh`
1. `sudo docker-compose up -d --build`
1. `sudo docker logs -f kafka_1`, then wait until the text stops
1. `sudo ./export-topics.sh`

## Topics
Each topic on the cluster exists for a reason, but we also have topics for testing purposes.  By default, there are 3 topics you can use to test out messages and demo producers / consumers: `test-1`, `test-2`, and `test-3`.  

#### `learner-xapi`
All statements sent to the LRS will be pushed into this topic by our LRS proxy Kafka producers.  

#### `system-xapi`
Historically used to emit logs sent as xAPI statements, but not currently used.

#### `resolve-pending`
Topic reserved for statements that were deemed MOM relevant but require additional resolution.

#### `resolved-xapi`
Transactional statements.  These statements have been either resolved or confirmed relevant to the current TLA enclave.

#### `authority-xapi`
Authoritative statements.  These statements have influenced a competency decision -- usually assertions.
