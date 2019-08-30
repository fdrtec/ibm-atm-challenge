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

    @GetMapping("extract")
    public CashMachine getExtract(){
        return cashMachineService.getExtract();
    }

}
