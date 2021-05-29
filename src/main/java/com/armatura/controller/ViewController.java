package com.armatura.controller;

import com.armatura.model.Valve;
import com.armatura.repository.ValvesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ViewController {

    private ValvesRepository valvesRepository;

    @Autowired
    ViewController(ValvesRepository valvesRepository){
        this.valvesRepository = valvesRepository;
    }

    @GetMapping("/valves")
    public String mainPage(
            @RequestParam (name="inputString", required = false, defaultValue = "Введите запрос") String inputString,
            Map<String, Object> model){
            model.put("inputString", inputString);
       return "main";
    }

    @PostMapping("/valves")
    public String inputString(@RequestParam String inputString,
                              @RequestParam String act,
                              Map<String,Object> model){

        List<Valve> valves;
        switch (act){
           case "Арматура":
               valves = valvesRepository.findAllByBiuIsContainingIgnoreCase(inputString);
               valves.addAll(valvesRepository.findAllByNameIsContainingIgnoreCase(inputString));
               model.put("valves", valves);
               break;
           case "Сборка":
               valves = valvesRepository.findAllByAssemblyIsContainingIgnoreCase(inputString);
               model.put("valves", valves);
               break;
           case "Блокировка":
               // Поиск и вывод арматуры с блокировками
               break;
        }
        return "main";
    }
}
