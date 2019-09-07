package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.Account;
import br.com.ibm.challenge.domain.CashMachine;
import br.com.ibm.challenge.domain.dto.RequestDto;
import br.com.ibm.challenge.repository.IcashMachineRepository;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CashMachineService {
    private CashMachine cashMachine;
    private Account account;
    private JSONObject response;

    public String makeDeposit(RequestDto requestDto){
        try{
            isValidSolicitation(requestDto);
            Double inicialBalance = account.getBalance();
            account.setBalance(account.incrementBalance(requestDto.getValue()));
            cashMachine.setFinalBalance(cashMachine.incrementBalance(requestDto.getValue()));

            response = new JSONObject()
                    .put("Saldo inicial da conta", inicialBalance)
                    .put("Saldo após deposito",account.getBalance())
                    .put("valor atualizado do estoque do ATM",cashMachine.getFinalBalance());

        } catch (Exception e) {
            return  e.getMessage();
        }
        return response.toString();
    }

    public String makeDraw(RequestDto requestDto) {
        try{
            isValidSolicitation(requestDto);
            if( account.getBalance() < requestDto.getValue()){
                new Exception("Processo Cancelado: Saldo Insuficiente");
            };
            Double balance = account.getBalance();
            account.setBalance(balance - requestDto.getValue());
            cashMachine.setFinalBalance(cashMachine.getFinalBalance() - requestDto.getValue());

            response = new JSONObject()
                    .put("Valor Sacado",requestDto.getValue())
                    .put("Saldo Inicial da conta", balance)
                    .put("Saldo Atual da conta", account.getBalance())
                    .put("Estoque Atual do ATM", cashMachine.getFinalBalance());
        }catch (Exception e){
            return  e.getMessage();
        }
        return response.toString();
    }

    private Boolean isValidSolicitation(RequestDto requestDto) throws Exception {
        cashMachine = IcashMachineRepository.findOperationalCash(requestDto.getCashMachineSerial());
        account = IcashMachineRepository.findAccountByNumber(requestDto.getAccountNumber());
        return true;
    }
}
