package org.example.creditmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.creditmanager.enums.Status;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "credit")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedEntityGraph(
        name = "CreditEntity.offersAndStatusHistories",
        attributeNodes = {
                @NamedAttributeNode("offers"),
                @NamedAttributeNode("statusHistories")
        }
)
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal requestedAmount;
    private BigDecimal amount;
    @Column(name = "check_date")
    private LocalDateTime checkDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            mappedBy = "credit")
    private List<StatusHistoryEntity> statusHistories;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            mappedBy = "credit")
    private List<OfferEntity> offers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}
