
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends MongoRepository<CustomerOrder, Long> {

}
