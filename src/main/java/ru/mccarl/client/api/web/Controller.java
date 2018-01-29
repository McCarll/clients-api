package ru.mccarl.client.api.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mccarl.client.api.entity.Account;
import ru.mccarl.client.api.entity.Client;
import ru.mccarl.client.api.repository.AccountRepository;
import ru.mccarl.client.api.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrudometkin on 24/11/2017.
 */
@RestController
@Configuration
@RequestMapping(produces = "application/json")
public class Controller {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @ApiOperation(value = "Получение клиентов")
    @GetMapping("/clients")
    public ResponseEntity getClients(){
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @ApiOperation(value = "Получение клиентов со счетами")
    @GetMapping("/clients")
    public ResponseEntity getClientsWithAccounts(){

        List<Client> clientList = clientRepository.findAll();
        clientList.forEach(client -> {
            List<Account> accountList = new ArrayList<>();
            client.get_ids()
                    .forEach(id -> accountList.add(accountRepository.findOne(id.toString())));
            client.setAccountsList(accountList);
        });
        return ResponseEntity.ok(clientList);
    }

    @GetMapping("/clients")
    public ResponseEntity getClient(@RequestParam String secondName){
        return ResponseEntity.ok(accountRepository.findOneBySecondName(secondName));
    }

    @ApiOperation(value = "Добавление счета клиенту")
    @PutMapping("/clients/accounts")
    public ResponseEntity putAccountForClient(
            @RequestParam String clientSecondName,
            @RequestBody Account account){
        account = accountRepository.save(account);
        Client client = clientRepository.findOne(clientSecondName);
        client.get_ids().add(account.get_id());
        client = clientRepository.save(client);
        return ResponseEntity.ok(client);
    }

    @ApiOperation(value = "Изменение свойств клиента")
    @PatchMapping("/clients")
    public ResponseEntity changeClientInfo(@RequestBody Client client){
        Client oldClient = clientRepository.findOne(client.getSecondName());
        BeanUtils.copyProperties(oldClient, client);
        clientRepository.save(client);
        return ResponseEntity.ok(client);
    }

    @ApiOperation(value = "Удаление клиента")
    @DeleteMapping("/clients/")
    public ResponseEntity deleteClient(@RequestBody Client client){
        clientRepository.delete(client.getSecondName());
        return ResponseEntity.ok().build();
    }






}
