package com.armatura.io;

import com.armatura.model.Valve;
import com.armatura.repository.ValvesRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.armatura.io.ValvesMapedLocation.insertPosition;

@Component
public class CreationDbFromFiles {

    final static String block1  = "src/main/resources/static/ArmaturaTEC5/block1.txt";
    final static String block2  = "src/main/resources/static/ArmaturaTEC5/block2.txt";
    final static String block3  = "src/main/resources/static/ArmaturaTEC5/kotel3.txt";

    ValvesRepository valvesRepository;

    @Autowired
    CreationDbFromFiles(ValvesRepository valvesRepository){
        this.valvesRepository = valvesRepository;
    }

    @SneakyThrows
    private List<String> readValvesFromFile(String fileName){
        List<String> myList = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()){
            myList.add(scanner.nextLine());
        }
        fileReader.close();
        return myList;
    }

    public List<String> sumReadingValves(){
            List<String> tempList = new ArrayList<>(readValvesFromFile(block1));
            tempList.addAll(readValvesFromFile(block2));
            tempList.addAll(readValvesFromFile(block3));
        return tempList;
    }

    public void createDB(){
        List<String> allStrings = sumReadingValves();
        List<String> oneString = new ArrayList<>();
        Valve valve;
        for(String tempString:allStrings){
            oneString.clear();
            valve = new Valve();
            for (String retval : tempString.split("[|]")) {
                   String temporal = retval.trim();
                   oneString.add(temporal);
            }
            if (oneString.size()==6){
                valve.setBiu(oneString.get(0));
                valve.setName(oneString.get(1));
                valve.setAssembly(oneString.get(2));
                valve.setLocker(oneString.get(3));
                valve.setPosition(oneString.get(4));
                valve.setLocation(oneString.get(5));
            }
                else {
                    if (oneString.size()==5) {
                        valve.setBiu(oneString.get(0));
                        valve.setName(oneString.get(1));
                        valve.setAssembly(oneString.get(2));
                        valve.setLocker(oneString.get(3));
                        valve.setPosition(oneString.get(4));
                        valve.setLocation(insertPosition(valve.getAssembly()));
                    }
                }
                if (valve.getName()!=null) valvesRepository.save(valve);
        }
    }
}
