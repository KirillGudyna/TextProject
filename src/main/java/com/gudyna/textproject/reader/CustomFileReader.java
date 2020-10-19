package com.gudyna.textproject.reader;

import com.gudyna.textproject.exception.ProgramException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReader {
    private static final Logger LOGGER = LogManager.getLogger(CustomFileReader.class);

    public String readData(String filename) throws ProgramException {
        try {
            Path path = Paths.get(filename);
            String data = new String(Files.readAllBytes(path));
            LOGGER.info("File read successfully!");
            return data;

        } catch (IOException e) {
            LOGGER.error("File read uncorrectable!");
            throw new ProgramException("File read uncorrectable!", e);
        } catch (NullPointerException ioe){
            LOGGER.error("Filename is wrong!!");
            throw new ProgramException("Filename is wrong!!", ioe);
        }
    }
}
