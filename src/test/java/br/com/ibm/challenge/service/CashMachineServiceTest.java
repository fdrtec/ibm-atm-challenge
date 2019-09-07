package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.Account;
import br.com.ibm.challenge.domain.CashMachine;
import br.com.ibm.challenge.domain.dto.RequestDto;
import br.com.ibm.challenge.repository.IcashMachineRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@SpringJUnitConfig
@PowerMockRunnerDelegate(SpringRunner.class)
public class CashMachineServiceTest {
    private static final String EXPECTED_DESPOSIT_RESPONSE = "{\"Saldo inicial da conta\":29000,\"Saldo após deposito\":29156.87,\"valor atualizado do estoque do ATM\":500156.87}";
    private static final String EXPECTED_DRAW_RESPONSE = "{\"Valor Sacado\":156.87,\"Saldo Inicial da conta\":29000,\"Saldo Atual da conta\":28843.13,\"Estoque Atual do ATM\":499843.13}";

    @InjectMocks
    private CashMachineService service;
    private RequestDto requestDto = new RequestDto();

    @Before
    public void setUp() throws Exception {
        requestDto.setCashMachineSerial("2019/001");
        requestDto.setAccountNumber("5555-444");
        requestDto.setValue(156.87);
    }

    @Test
    public void makeDeposit_should_return_confirmation_of_operation() {
        assertEquals(service.makeDeposit(requestDto), EXPECTED_DESPOSIT_RESPONSE);
    }

    @Test
    public void makeDraw_should_return_confirmation_of_operation() {
        assertEquals(service.makeDraw(requestDto), EXPECTED_DRAW_RESPONSE);
    }
}