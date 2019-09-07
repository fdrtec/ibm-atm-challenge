package br.com.ibm.challenge.controller;

import br.com.ibm.challenge.domain.dto.RequestDto;
import br.com.ibm.challenge.service.CashMachineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
public class CashMachineControllerTest {

    @InjectMocks
    private CashMachineController ctrl;
    private CashMachineService service = PowerMockito.spy(new CashMachineService());
    private RequestDto requestDto = new RequestDto();

    @Before
    public void setUp() throws Exception {
        requestDto.setCashMachineSerial("2019/001");
        requestDto.setAccountNumber("5555-444");
        requestDto.setValue(156.87);
    }

    @Test
    public void makeDepositMethod_sould_invoke_makeDeposit_of_CashMachineService() {
        ctrl.makeDeposit(requestDto);
        verify(service, times(1)).makeDeposit(requestDto);
    }

    @Test
    public void makeDrawMethodi_nvoke_makeDraw_of_CashMachineService() {
        ctrl.makeDraw(requestDto);
        verify(service, times(1)).makeDraw(requestDto);
    }
}