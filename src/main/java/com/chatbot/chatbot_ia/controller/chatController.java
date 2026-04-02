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

        return chatClient.prompt()
                .system("""
                        Eres un asistente especializado en Informatica
                        Reglas:
                        - SOLO respondes sobre informatica.
                        - Ayudas a entender informatica.
                        - Responde claro y breve.
                        - al principio, debes saludar al usuario, si te escribe directamente una pregunta la respondes pero si primero te saluda, le respondes con un saludo tambien
                        - Si la pregunta NO es del tema, responde:
                          "Solo puedo ayudarte con informatica."
                        """)
                .user(mensaje)
                .call()
                .content();
    }

}
