package com.emsi.Client.controller;

import com.emsi.Client.entites.Client;
import com.emsi.Client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping
    public List<Client> findAll(){
        return  clientService.findAll();
    }
    @GetMapping("/{id}")
    public Client findById(@PathVariable int id)throws  Exception{
        return  clientService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Client client){
       clientService.addClient(client);
    }


}
