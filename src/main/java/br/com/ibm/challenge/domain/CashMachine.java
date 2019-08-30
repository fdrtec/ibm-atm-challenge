package br.com.ibm.challenge.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cashMachine")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class CashMachine {

    @Id
    @GeneratedValue
    @Getter @Setter
    private UUID Id;

    @Getter @Setter
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @Getter @Setter
    private String stateCash;

    @Getter @Setter
    private Double finalBalance;

    @Getter @Setter
    private Double openBalance;
}
