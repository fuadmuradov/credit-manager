package org.example.creditmanager.mapper;

import org.example.creditmanager.entity.StatusHistoryEntity;
import org.example.creditmanager.model.requset.HistoryRequest;
import org.example.creditmanager.model.response.HistoryResponse;

import static org.example.creditmanager.mapper.CreditMapper.CREDIT_MAPPER;

public enum HistoryMapper {
    HISTORY_MAPPER;
    public StatusHistoryEntity mapToEntity(HistoryRequest history) {
        return StatusHistoryEntity.builder()
                .status(history.getStatus())
                .build();
    }

    public HistoryResponse mapToResponse(StatusHistoryEntity history) {
        return HistoryResponse.builder()
                .status(history.getStatus())
                .id(history.getId())
                .createdAt(history.getCreatedAt())
                .updatedAt(history.getUpdatedAt())
                .build();
    }
}
