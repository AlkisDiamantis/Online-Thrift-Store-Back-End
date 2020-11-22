package com.project.thrifting.controllers;

import com.project.thrifting.models.Messages;
import com.project.thrifting.service.MessagesServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/welcome")
public class MessageController {

    @Autowired
    MessagesServiceInterface messagesServiceInterface;

    @PostMapping("/insertMessage")
    public String insertmessage(@RequestBody Messages messages) {

        messagesServiceInterface.insertMessage(messages);
        return "Message Send Succefully";
    }

    @GetMapping("/getMessageByuserReceiveid/{userreceiveid}")
     @PreAuthorize("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
    public List<Messages> getMessagesByUserReceiveid(@PathVariable int userreceiveid) {

        return messagesServiceInterface.getMessagesByUserReceiveId(userreceiveid);
    }

    @GetMapping("/deleteMessage/{messageid}")
    public void deleteMessage(@PathVariable int messageid) {

        messagesServiceInterface.deleteMessage(messageid);
    }

}
