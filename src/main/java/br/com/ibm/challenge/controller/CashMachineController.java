package br.com.ibm.challenge.controller;

import br.com.ibm.challenge.domain.CashMachine;
import br.com.ibm.challenge.service.CashMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CashMachineController {

    @Autowired
    private CashMachineService cashMachineService;

    @GetMapping("make-deposit")
    public String makeDeposit(){
        String cashMachineSerial = "2019/001";
        String accountNumber = "5555-444";
        return cashMachineService.makeDeposit(cashMachineSerial, accountNumber, 500.00);
    }
}
