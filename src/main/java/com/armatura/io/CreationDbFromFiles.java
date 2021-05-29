package com.armatura.io;

import com.armatura.model.Valve;
import com.armatura.repository.ValvesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.armatura.io.ValvesMapedLocation.insertPosition;

@Component
public class CreationDbFromFiles {

    private final ValvesRepository valvesRepository;

    @Autowired
    CreationDbFromFiles(ValvesRepository valvesRepository){
        this.valvesRepository = valvesRepository;
    }

    public void createDB(){
        List<String> allStrings = new FilesOperations().readingAllLinesFromAllFiles();
        List<String> oneString = new ArrayList<>();
        Valve valve;
        for(String tempString:allStrings){
            oneString.clear();
            valve = new Valve();
            for (String retval : tempString.split("[|]")) {
                   String temporal = retval.trim();
                   oneString.add(temporal);
            }
            if ((oneString.size()==6) && !oneString.isEmpty()){
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
