package ru.mccarl.client.api.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mccarl.client.api.entity.Client;
import ru.mccarl.client.api.repository.ClientRepository;

/**
 * Created by vrudometkin on 24/11/2017.
 */
@RestController
@Configuration
@RequestMapping(produces = "application/json")
public class Controller {

    @Autowired
    private ClientRepository clientRepository;

    @ApiOperation(value = "Получение клиентов")
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ResponseEntity getClients(){
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @ApiOperation(value = "Получение клиента")
    @RequestMapping(value = "/clients", method = RequestMethod.GET, params = "id")
    public ResponseEntity getClient(@RequestParam String id){
        return ResponseEntity.ok(clientRepository.findOne(id));
    }

    @ApiOperation(value = "Добавление клиента")
    @PostMapping("/clients")
    public ResponseEntity addClient(@RequestBody Client client){
        return ResponseEntity.ok(clientRepository.save(client));
    }

    @ApiOperation(value = "Добавление параметров клиента")
    @PutMapping("/clients")
    public ResponseEntity putAccountForClient(
            @RequestBody Client client){
        Client oldClient = clientRepository.findOne(client.get_id().toString());
        BeanUtils.copyProperties(oldClient, client);
        clientRepository.save(oldClient);
        return ResponseEntity.ok(oldClient);
    }

    @ApiOperation(value = "Изменение свойств клиента")
    @PatchMapping("/clients")
    public ResponseEntity changeClientInfo(@RequestBody Client client){
        Client oldClient = clientRepository.findBySecondName(client.getSecondName());
        BeanUtils.copyProperties(oldClient, client);
        clientRepository.save(oldClient);
        return ResponseEntity.ok(oldClient);
    }

    @ApiOperation(value = "Удаление клиента")
    @DeleteMapping("/clients")
    public ResponseEntity deleteClient(@RequestBody Client client){
        clientRepository.delete(client.getSecondName());
        return ResponseEntity.ok().build();
    }
}
