package com.easyhao.micro.personnel.controller;

import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.utils.bean.ChatMsgBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class WebSocketController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsgBean chatMsg) {
        if (chatMsg.getTo() == null) {
            //前端没有选择要发送消息的用户
            return;
        }
        SysUser user = (SysUser) authentication.getPrincipal();
        chatMsg.setFrom(user.getUserName());
        chatMsg.setFromNickName(user.getNickName());
        chatMsg.setDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(), "/queue/chat", chatMsg);
    }


}
