package org.example.banktransactions.service;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.example.banktransactions.model.BankBalance;
import org.example.banktransactions.topology.BankBalanceTopology;
import org.springframework.stereotype.Service;

@Service
public class BankBalanceService {

    private final KafkaStreams kafkaStreams;

    public BankBalanceService(KafkaStreams kafkaStreams) {
        this.kafkaStreams = kafkaStreams;
    }

    public BankBalance getBankBalanceById(Long bankBalanceId) {
        return getStore().get(bankBalanceId);
    }

    private ReadOnlyKeyValueStore<Long, BankBalance> getStore() {
        return kafkaStreams.store(
                StoreQueryParameters.fromNameAndType(
                        BankBalanceTopology.BANK_BALANCES_STORE,
                        QueryableStoreTypes.keyValueStore()
                )
        );
    }
}