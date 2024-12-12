package com.estacaojr10.api.Services;
import com.estacaojr10.api.Dto.BraceletDto;
import com.estacaojr10.api.Dto.BraceletHistoryDto;
import com.estacaojr10.api.Dto.BraceletWithHistory;
import com.estacaojr10.api.Entities.Bracelet.Bracelet;
import com.estacaojr10.api.Entities.Bracelet.BraceletRepository;
import com.estacaojr10.api.Entities.BraceletHistory.BraceletHistory;
import com.estacaojr10.api.Entities.BraceletHistory.BraceletHistoryRepository;
import com.estacaojr10.api.Entities.Client.Client;
import com.estacaojr10.api.Entities.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<BraceletDto> findBracelet(Pageable pageable) {
        // Chama o repositório com paginação para obter uma página de resultados
        Page<BraceletHistory> historyPage = braceletHistoryRepository.findAll(pageable);
        return getBraceletDtos(historyPage.getContent());
    }

    public List<BraceletDto> findBraceletDetails(String number) {
        List<BraceletHistory> historyList = braceletHistoryRepository.findBraceletDetails(number);
        return getBraceletDtos(historyList);
    }

    private List<BraceletDto> getBraceletDtos(List<BraceletHistory> historyList) {
        List<BraceletDto> responseList = new ArrayList<>();
        for (BraceletHistory history : historyList) {
            Bracelet bracelet = history.getBracelet();

            // Mapeando a pulseira e o histórico para o DTO
            BraceletDto dto = mapToBraceletDto(history, bracelet);

            responseList.add(dto);
        }
        return responseList;
    }

    private BraceletDto mapToBraceletDto(BraceletHistory history, Bracelet bracelet) {
        Client client = clientRepository.findAllById(bracelet.getClientId());
        String name = client.getName();
        String cpfCnpj = client.getCpfCnpj();
        return new BraceletDto(
                name,
                cpfCnpj,
                history.getNumber(),
                history.getPaymentMethodId().getId(),
                history.getPrice(),
                history.getDiscount(),
                history.getCreatedAt(),
                history.getExpiredAt()
        );
    }

    public BraceletWithHistory createBraceletWithHistory(BraceletWithHistory request) {
        // 1. Converta o DTO para uma entidade Bracelet
        Bracelet bracelet = new Bracelet();
        bracelet.setClientId(request.getClient());
        bracelet.setUserId(request.getUser());

        // 2. Salve o Bracelet no banco de dados
        Bracelet createdBracelet = braceletRepository.save(bracelet);

        // 3. Crie e salve o histórico associado ao Bracelet
        List<BraceletHistory> histories = new ArrayList<>();
        for (BraceletHistoryDto historyDto : request.getHistory()) {
            BraceletHistory history = new BraceletHistory(historyDto, createdBracelet);
            histories.add(history);
        }
        braceletHistoryRepository.saveAll(histories);

        // Retorne o objeto DTO com os dados salvos, se necessário
        request.setBraceletId(createdBracelet.getId());
        return request;
    }
}
