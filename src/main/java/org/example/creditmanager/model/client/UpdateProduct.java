package org.example.creditmanager.model.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.creditmanager.enums.Status;

@Getter
@Setter
@Builder
public class UpdateProduct {
    private Long productId;
    private Status status;
}
