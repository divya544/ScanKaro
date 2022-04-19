
package dmacc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.MenuItems;

@Repository
public interface MenuItemsRepoitory extends MongoRepository<MenuItems, Long> {

}
