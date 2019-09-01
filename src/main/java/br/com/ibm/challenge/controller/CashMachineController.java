package br.com.ibm.challenge.controller;

import br.com.ibm.challenge.domain.CashMachine;
import br.com.ibm.challenge.domain.dto.DepositRequestDto;
import br.com.ibm.challenge.service.CashMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class CashMachineController {

    @Autowired
    private CashMachineService cashMachineService;

//    body para requisição POST no postman
//    http://localhost:8080/api/make-deposit
//    {
//        "cashMachineSerial": "2019/001",
//        "accountNumber":"5555-444",
//        "depositValue": 156.87
//    }

    @PostMapping("make-deposit")
    public String makeDeposit(@RequestBody DepositRequestDto depositRequestDto){
        return cashMachineService.makeDeposit(depositRequestDto);
    }
}
