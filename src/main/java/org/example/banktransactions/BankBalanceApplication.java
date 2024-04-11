package org.example.banktransactions;

import org.apache.kafka.streams.KafkaStreams;
import org.example.banktransactions.config.StreamConfiguration;
import org.example.banktransactions.topology.BankBalanceTopology;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankBalanceApplication {

    public static void main(String[] args) {
        var configuration = StreamConfiguration.getConfiguration();
        var topology = BankBalanceTopology.buildTopology();
        var kafkaStreams = new KafkaStreams(topology, configuration);

        kafkaStreams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
    }

}
