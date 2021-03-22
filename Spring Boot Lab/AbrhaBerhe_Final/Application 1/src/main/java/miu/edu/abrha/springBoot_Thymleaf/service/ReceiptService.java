package miu.edu.abrha.springBoot_Thymleaf.service;

import miu.edu.abrha.springBoot_Thymleaf.dao.EmployeeDao;
import miu.edu.abrha.springBoot_Thymleaf.dao.ReceiptDao;
import miu.edu.abrha.springBoot_Thymleaf.model.Employee;
import miu.edu.abrha.springBoot_Thymleaf.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReceiptService {
    @Autowired
    private ReceiptDao receiptDao;

    public ResponseEntity<Receipt> addReceipt(Receipt receipt) {
        receiptDao.save(receipt);
        return ResponseEntity.status(200).build();
    }

    public float getCurrentAmount() {
        return receiptDao.findCurrentAmount();
    }

}
