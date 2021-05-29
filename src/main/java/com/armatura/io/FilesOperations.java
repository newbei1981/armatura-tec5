package com.armatura.io;

/*
        А class for reading all text files from the project directory, adding a file
    to the directory and writing each line of the received files line by line to
    the Database.
        Working directory with files is ".../resources/static/valves
 */

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilesOperations {

    private static String PATH_FILES = "src/main/resources/static/valves/";

    private List<Path> filesList() {
        File folder = new File(PATH_FILES);
        List<Path> tempListFiles = new ArrayList<>();
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                tempListFiles.add(file.toPath());
            }
        }
        return tempListFiles;
    }

    @SneakyThrows
    public List<String> readingAllLinesFromAllFiles() {
        List<String> stringsLinesFromFiles = new ArrayList<>();
        for(Path filePath:filesList()){
            stringsLinesFromFiles.addAll(Files.readAllLines(filePath));
        }
       // stringsLinesFromFiles.stream().forEach(p -> System.out.println(p));
        return stringsLinesFromFiles;
    }


}
