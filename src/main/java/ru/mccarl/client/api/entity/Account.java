package ru.mccarl.client.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by vrudometkin on 27/01/2018.
 */
@Data

public class Account {

    @Id
    @JsonIgnore
    private ObjectId _id;

    private String name;

    private String count;

    private String currency;

}
