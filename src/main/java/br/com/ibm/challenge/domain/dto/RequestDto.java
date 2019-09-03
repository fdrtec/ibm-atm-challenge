package br.com.ibm.challenge.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestDto {
    private String cashMachineSerial;
    private String accountNumber;
    private Double value;
}