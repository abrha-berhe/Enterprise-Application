package miu.edu.abrha.springBoot_Thymleaf.dao;

 import miu.edu.abrha.springBoot_Thymleaf.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;

public interface ReceiptDao extends JpaRepository<Receipt, Long> {
 @Query("SELECT max(amount) FROM Receipt")
  public float findCurrentAmount();
}
