package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.Account;
import br.com.ibm.challenge.domain.CashMachine;
import br.com.ibm.challenge.repository.IcashMachineRepository;
import org.springframework.stereotype.Service;

@Service
public class CashMachineService {

    public String makeDeposit(String cashMachineSerial, String accountNumber, Double depositValue){
        CashMachine cashMachine = IcashMachineRepository.findOperationalCash(cashMachineSerial);
        Account account = IcashMachineRepository.findAccountByNumber(accountNumber);

        return "lógica do deposito em construção";
    }
}
