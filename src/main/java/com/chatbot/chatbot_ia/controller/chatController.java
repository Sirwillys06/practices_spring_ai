package com.chatbot.chatbot_ia.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class chatController {

        private final ChatClient chatClient;

    
  public chatController(ChatClient chatClient) {
    this.chatClient = chatClient;
}

    @GetMapping("/ia")
    public String preguntar(@RequestParam String mensaje) {
        return chatClient.prompt()//inicia la conversacion
                .user(mensaje)//capturar mensaje del suuario y enviarlo a openia
                .call() //llamar a openia
                .content(); //extraer respuesta
    }


}
