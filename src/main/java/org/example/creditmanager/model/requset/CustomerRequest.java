package org.example.creditmanager.model.requset;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CustomerRequest {
    private String pin;
    private String fullName;
    private String phoneNumber;
}
