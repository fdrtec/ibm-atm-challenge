package br.com.ibm.challenge.domain;

import br.com.ibm.challenge.domain.Enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    @Getter @Setter
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate operationDate;

    @JoinColumn(name = "cashMachine_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CashMachine cashMachineId;

    @JoinColumn(name = "account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account AccountId;

    @Getter @Setter
    private TransactionType type;

    @Getter @Setter
    private Double value;




}
