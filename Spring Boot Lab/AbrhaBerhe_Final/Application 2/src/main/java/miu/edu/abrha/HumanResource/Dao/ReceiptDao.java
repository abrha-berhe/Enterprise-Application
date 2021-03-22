package miu.edu.abrha.HumanResource.Dao;

 import miu.edu.abrha.HumanResource.Enitity.Receipt2;
 import miu.edu.abrha.springBoot_Thymleaf.model.Receipt;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ReceiptDao extends JpaRepository<Receipt2, Long> {
 @Query("SELECT max(amount) FROM Receipt2")
 public Float findCurrentAmount();
}
