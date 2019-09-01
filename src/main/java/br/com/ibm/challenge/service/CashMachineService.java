package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.Account;
import br.com.ibm.challenge.domain.CashMachine;
import br.com.ibm.challenge.domain.dto.DepositRequestDto;
import br.com.ibm.challenge.repository.IcashMachineRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CashMachineService {
    private CashMachine cashMachine;
    private Account account;
    private JSONObject response;

    public String makeDeposit(DepositRequestDto depositRequestDto){
        try{
            cashMachine = IcashMachineRepository.findOperationalCash(depositRequestDto.getCashMachineSerial());
            account = IcashMachineRepository.findAccountByNumber(depositRequestDto.getAccountNumber());
            Double inicialBalance = account.getBalance();
            account.setBalance(account.incrementBalance(depositRequestDto.getDepositValue()));
            cashMachine.setFinalBalance(cashMachine.incrementBalance(depositRequestDto.getDepositValue()));

            response = new JSONObject()
                    .put("Saldo inicial da conta", inicialBalance)
                    .put("Saldo após deposito",account.getBalance())
                    .put("valor atualizado do estoque do ATM",cashMachine.getFinalBalance());

        } catch (Exception e) {
            return  e.getMessage();
        }
        return response.toString();
    }
}
