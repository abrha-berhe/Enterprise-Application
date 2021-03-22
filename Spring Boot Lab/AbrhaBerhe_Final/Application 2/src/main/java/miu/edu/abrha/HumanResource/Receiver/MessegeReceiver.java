package miu.edu.abrha.HumanResource.Receiver;

import miu.edu.abrha.HumanResource.Enitity.Receipt2;
import miu.edu.abrha.HumanResource.Service.ReceiptService;
import miu.edu.abrha.springBoot_Thymleaf.model.Employee;
import miu.edu.abrha.springBoot_Thymleaf.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;

@Controller
public class MessegeReceiver {
    @Autowired
    private ReceiptService receiptService;

    //    @JmsListener(destination = "employeeQueue")
//    public void receiveMessage(Employee employee){
//        System.out.println("Message received from Human Resource");
//        System.out.println("With Employee "+employee.toString());
//    }

    @JmsListener(destination = "receiptQueue")
    public void receiveMessage(Receipt receipt) {
//        System.out.println("Message received with receipt Details " + receipt);
        Receipt2 receipt2 = new Receipt2();

        receipt2.setId(receipt.getId());
        receipt2.setDate(receipt.getDate());

        float recentAmount = receiptService.getCurrentAmount();
        if(recentAmount<10.0f){
            recentAmount = 10.0f;
        }
        else{
            recentAmount += (float) receipt.getAmount() ;
        }


        receipt2.setAmount(recentAmount);
        receiptService.addReceipt(receipt2);
        System.out.println("---------Receipt Received at "+receipt2.getDate()+" ------------");
        System.out.println(" Receipt Inserted to DB with detail -->"+receipt2);

    }

}


