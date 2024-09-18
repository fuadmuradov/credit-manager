package org.example.creditmanager.model.requset;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.creditmanager.enums.Status;

@Getter
@Setter
@ToString
@Builder
public class HistoryRequest {
    private Status status;
    private Long creditId;
}
