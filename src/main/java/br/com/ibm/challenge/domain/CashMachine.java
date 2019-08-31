package br.com.ibm.challenge.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "cashMachine")
//@ToString(exclude="id")
//@EqualsAndHashCode(of="id")
@Getter
@Builder
public class CashMachine {

    @Id
    @GeneratedValue
    private UUID Id;

    private String serialNumber;

    @Setter
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @Setter
    private Boolean isOpen;

    @Setter
    private Double finalBalance;

    @Setter
    private Double openBalance;

//    @ElementCollection
//    private List transactions;

//    private Map moneyBills;
}
