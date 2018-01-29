package ru.mccarl.client.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by vrudometkin on 27/01/2018.
 */
@Data
public class Client {

    @Id
    @JsonIgnore
    private ObjectId _id;

    private String name;

    private String secondName;

    private String patronymic;

    @Field("accounts")
    @JsonIgnore
    private List<ObjectId> _ids;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Account> accountsList;

}
