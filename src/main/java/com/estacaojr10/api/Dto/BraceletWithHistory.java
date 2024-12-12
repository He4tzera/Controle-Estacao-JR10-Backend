package com.estacaojr10.api.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BraceletWithHistory {
    private String braceletId;
    @NotNull
    private String client;
    private String user;
    @NotNull
    private List<BraceletHistoryDto> history;
}


