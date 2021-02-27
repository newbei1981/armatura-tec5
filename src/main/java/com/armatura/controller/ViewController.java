package com.armatura.controller;

import com.armatura.io.CreationDbFromFiles;
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
    private CreationDbFromFiles createDB;

    @Autowired
    ViewController(ValvesRepository valvesRepository, CreationDbFromFiles creatDB){
        this.valvesRepository = valvesRepository;
        this.createDB = creatDB;
    }

    @GetMapping("/valves")
    public String mainPage(
            @RequestParam (name="inputString", required = false, defaultValue = "Введите запрос") String inputString,
            Map<String, Object> model){
            model.put("inputString", inputString);
       return "main";
    }

    @PostMapping("/valves")
    public String inputString(@RequestParam String inputString, Map<String,Object> model){
        if (inputString.equalsIgnoreCase("create")) createDB.createDB();
         else {
             if (inputString.startsWith("??")) {
                 List<Valve> valves = valvesRepository.findAllByAssemblyIsContainingIgnoreCase(inputString.substring(3));
                 model.put("valves", valves);
             }
             else {
                 List<Valve> valves = valvesRepository.findAllByBiuIsContainingIgnoreCase(inputString);
                 valves.addAll(valvesRepository.findAllByNameIsContainingIgnoreCase(inputString));
                 model.put("valves", valves);
             }

         }
        return "main";
    }
}
