package br.com.ibm.challenge.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DepositRequestDto {
    private String cashMachineSerial;
    private String accountNumber;
    private Double depositValue;
}