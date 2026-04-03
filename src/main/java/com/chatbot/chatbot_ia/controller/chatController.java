package com.chatbot.chatbot_ia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.chatbot_ia.services.LlamaAIServices;


@RestController
public class chatController {


    @Autowired
    private LlamaAIServices llamaAIServices;


    @GetMapping("api/ollama")
    public String generate(@RequestParam(value= "PromptMessage") String promtMessage){
        return llamaAIServices.generateResult(promtMessage);
    }






}
