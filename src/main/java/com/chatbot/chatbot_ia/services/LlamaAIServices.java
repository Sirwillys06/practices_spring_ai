package com.chatbot.chatbot_ia.services;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamaAIServices {



    @Autowired
    private OllamaChatModel chatModel;


    public  String generateResult(String promt){

        OllamaOptions options = new OllamaOptions();

        ChatResponse response = chatModel.call(new Prompt(promt, options));

        if (response != null){
            return response.getResult().getOutput().getContent();

        }

        return "Error: no hay respuesta.";


    }


     


    








}
