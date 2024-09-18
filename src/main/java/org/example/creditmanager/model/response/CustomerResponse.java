package org.example.creditmanager.model.response;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.creditmanager.entity.CreditEntity;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class CustomerResponse {
    private Long id;
    private String pin;
    private String fullName;
    private String phoneNumber;
    private List<CreditResponse> credits;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
