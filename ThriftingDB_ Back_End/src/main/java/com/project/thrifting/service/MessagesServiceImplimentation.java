/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.thrifting.service;

import com.project.thrifting.models.Messages;
import com.project.thrifting.models.repository.MessagesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alkis
 */
@Service
public class MessagesServiceImplimentation implements MessagesServiceInterface {

    @Autowired
    MessagesRepository messagesRepository;

    @Override
    public void insertMessage(Messages message) {
        messagesRepository.save(message);
    }

    @Override
    public List<Messages> getMessagesByUserReceiveId(int userreceiveid) {
        List<Messages> emptyList = new ArrayList();
        return messagesRepository.findByUserreceiveid(userreceiveid).orElse(emptyList);
    }

    @Override
    public void deleteMessage(int id_messages) {
        messagesRepository.deleteById(id_messages);
    }

}
