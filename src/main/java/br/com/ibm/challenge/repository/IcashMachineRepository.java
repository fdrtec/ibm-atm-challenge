package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.Account;
import br.com.ibm.challenge.domain.CashMachine;
import br.com.ibm.challenge.domain.Enums.AccountType;
import br.com.ibm.challenge.domain.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Repository
public interface IcashMachineRepository {

    static CashMachine findOperationalCash(String serialNumber){
        return CashMachine
                .builder()
                .serialNumber("2019/001")
                .date(LocalDate.now())
                .isOpen(true)
                .openBalance(500000.00)
                .finalBalance(500000.00)
                .build();
    }

    static Account findAccountByNumber(String accountNumber){
        return Account.builder()
                .agency(1234)
                .number("5555-444")
                .type(AccountType.CHECKING_ACCOUNT)
                .userName("Arlindo Nicolau")
                .balance(50000.00)
                .build();
    }
}
