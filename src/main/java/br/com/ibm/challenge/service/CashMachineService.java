package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.CashMachine;
import br.com.ibm.challenge.repository.IcashMachineRepository;
import org.springframework.stereotype.Service;

@Service
public class CashMachineService {

    public CashMachine getExtract(){
        return IcashMachineRepository.findOperationalCash("open");
    }
}
