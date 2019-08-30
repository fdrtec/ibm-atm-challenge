package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.CashMachine;
import org.springframework.stereotype.Repository;

@Repository
public interface IcashMachineRepository {

    public static CashMachine findOperationalCash(String state){
        return new CashMachine();
    }
}
