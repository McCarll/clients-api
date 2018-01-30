package ru.mccarl.client.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * Created by vrudometkin on 27/01/2018.
 */
@Data
@EqualsAndHashCode
public class Client {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String secondName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String patronymic;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date birthday;

    @Field("accounts")
    @JsonSerialize(using = ToStringSerializer.class)
    private List<ObjectId> _ids;


}
