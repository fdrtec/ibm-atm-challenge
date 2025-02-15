package br.com.ibm.challenge.controller;

import br.com.ibm.challenge.domain.dto.RequestDto;
import br.com.ibm.challenge.service.CashMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class CashMachineController {

    @Autowired
    private CashMachineService cashMachineService;

    /**
     * body para requisição POST no postman
     * http://localhost:8080/api/make-deposit
     * {      "cashMachineSerial": "2019/001",
     * "accountNumber":"5555-444",
     * "value": 156.87             }
     */
    @PostMapping("make-deposit")
    public String makeDeposit(@RequestBody RequestDto requestDto) {
        return cashMachineService.makeDeposit(requestDto);
    }

    /**
     * body para requisição POST no postman
     * http://localhost:8080/api/make-draw
     * {      "cashMachineSerial": "2019/001",
     * "accountNumber":"5555-444",
     * "value": 2156.87             }
     */
    @PostMapping("make-draw")
    public String makeDraw(@RequestBody RequestDto requestDto) {
        return cashMachineService.makeDraw(requestDto);
    }

}
