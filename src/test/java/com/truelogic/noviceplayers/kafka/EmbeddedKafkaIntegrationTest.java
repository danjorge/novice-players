package com.truelogic.noviceplayers.kafka;

import com.truelogic.noviceplayers.configuration.KafkaConsumer;
import com.truelogic.noviceplayers.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class EmbeddedKafkaIntegrationTest {

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaTemplate<String, Object> producer;

    @Test
    public void givenEmbeddedKafkaBroker_whenSendingtoSimpleProducer_thenMessageReceived() 
      throws Exception {
        Player player = Player.builder().name("Scorpion").type("novice").build();

        producer.send("novice-players", player.toString());
        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);

        assertThat(consumer.getLatch().getCount()).isEqualTo(0L);
        assertThat(consumer.getPayload()).isEqualTo("Player(id=null, name=Scorpion, type=novice)");
    }
}