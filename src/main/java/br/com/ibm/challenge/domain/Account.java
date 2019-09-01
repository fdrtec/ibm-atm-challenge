package br.com.ibm.challenge.domain;

import br.com.ibm.challenge.domain.Enums.AccountType;
import br.com.ibm.challenge.domain.Enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Builder
@Getter
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private UUID id;
    private Integer agency;
    private String number;
    private AccountType type;
    private String userName;

    @Setter
    private Double balance;

    public Double incrementBalance(Double depositValue){
        return balance += depositValue;
    }
}
