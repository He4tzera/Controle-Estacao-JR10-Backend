package com.estacaojr10.api.Services;

import com.estacaojr10.api.Dto.BraceletDto;
import com.estacaojr10.api.Entities.Bracelet.Bracelet;
import com.estacaojr10.api.Entities.Bracelet.BraceletRepository;
import com.estacaojr10.api.Entities.BraceletHistory.BraceletHistory;
import com.estacaojr10.api.Entities.BraceletHistory.BraceletHistoryRepository;
import com.estacaojr10.api.Entities.Client.ClientRepository;
import com.estacaojr10.api.Entities.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BraceletServices {
    @Autowired
    private BraceletRepository braceletRepository;

    @Autowired
    private BraceletHistoryRepository braceletHistoryRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    public List<BraceletDto> findBracelet() {
        List<BraceletHistory> historyList = braceletHistoryRepository.findBracelet();
        return getBraceletDto(historyList);
    }

    public List<BraceletDto> findBraceletDetails(String number) {
        List<BraceletHistory> historyList = braceletHistoryRepository.findBraceletDetails(number);
        return getBraceletDto(historyList);
    }

    private List<BraceletDto> getBraceletDto(List<BraceletHistory> historyList) {
        List<BraceletDto> responseList = new ArrayList<>();
        for (BraceletHistory history : historyList) {
            // Obtendo a pulseira associada ao histórico
            Bracelet bracelet = history.getBracelet();

            // Chamando o método para mapear o histórico e a pulseira para o DTO
            List<BraceletDto> response = getBraceletDto(history, bracelet);

            // Adicionando o DTO à lista de respostas
            responseList.add(response);
        }
        return responseList;
    }
}