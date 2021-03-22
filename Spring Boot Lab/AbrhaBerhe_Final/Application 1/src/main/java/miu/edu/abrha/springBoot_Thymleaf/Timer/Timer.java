package miu.edu.abrha.springBoot_Thymleaf.Timer;

import miu.edu.abrha.springBoot_Thymleaf.model.Receipt;
import miu.edu.abrha.springBoot_Thymleaf.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

 @Component
public class Timer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
   private ReceiptService receiptService;

  //  @Scheduled(cron = "0/3 * * * * *")
    public void sendReceipt() {
        Receipt receipt = new Receipt(new Date(), 0.1f );
        System.out.println(" ------ Receipt Sent at "+receipt.getDate()+"---- ");
        jmsTemplate.convertAndSend("receiptQueue",receipt );
    }
}



