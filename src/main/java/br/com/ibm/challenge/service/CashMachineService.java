package br.com.ibm.challenge.service;

import org.springframework.stereotype.Service;

@Service
public class CashMachineService {

    public String getExtract(){
        return "Saldo: R$ 10.000,00";
    }
}
