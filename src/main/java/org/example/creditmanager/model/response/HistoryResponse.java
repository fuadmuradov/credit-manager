package org.example.creditmanager.model.response;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.creditmanager.entity.CreditEntity;
import org.example.creditmanager.enums.Status;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class HistoryResponse {
    private Long id;
    private Status status;
    private CreditResponse credit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
