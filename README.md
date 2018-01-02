# AMQP Kata

The purpose of this Kata is to work on a message producer and consumer using Spring Boot. It depends solely on an internal working RabbitMQ system.

## Steps
1. Start RabbitMQ
2. Start the message-listener
3. Start the message-producer... run as many times as you want

Note we are leveraging JSON message formats instead of Serialized objects, mainly because object serialization can be considered dangerous :)
