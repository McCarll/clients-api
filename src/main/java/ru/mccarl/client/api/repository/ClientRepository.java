package ru.mccarl.client.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.mccarl.client.api.entity.Client;

/**
 * Created by vrudometkin on 27/01/2018.
 */
@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    Client findBySecondName(String secondName);

    Client findOne(String _id);

}
