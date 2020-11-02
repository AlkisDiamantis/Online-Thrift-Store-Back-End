
package com.project.thrifting.service;

import com.project.thrifting.models.Messages;
import java.util.List;

public interface MessagesServiceInterface {
    
    public void insertMessage (Messages message);
    
    public List<Messages> getMessagesByUserReceiveId(int userreceiveid);
    
      public void deleteMessage(int id_messages);
    
}
