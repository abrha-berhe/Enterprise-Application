package miu.edu.abrha.HumanResource.Service;

import miu.edu.abrha.HumanResource.Dao.ReceiptDao;
import miu.edu.abrha.HumanResource.Enitity.Receipt2;
import miu.edu.abrha.springBoot_Thymleaf.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReceiptService {
    @Autowired
    private ReceiptDao receiptDao;

    public void addReceipt(Receipt2 receipt) {
        receiptDao.save(receipt);
       // return ResponseEntity.status(200).build();
    }
    public Float getCurrentAmount() {
        Float max = receiptDao.findCurrentAmount();
        if(max==null)
            return 0.0f;
        else
        return receiptDao.findCurrentAmount();
    }
}
