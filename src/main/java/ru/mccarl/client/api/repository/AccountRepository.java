package ru.mccarl.client.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.mccarl.client.api.entity.Account;

/**
 * Created by vrudometkin on 27/01/2018.
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    Account findOneBySecondName(String secondName);
}
