package com.sparta.mz.logging;

import java.io.IOException;
import java.util.logging.*;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        LOGGER.setUseParentHandlers(false); // removed default options for logger
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO); // At that level and higher
        consoleHandler.setFormatter(new XMLFormatter());
        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("src/main/java/com/sparta/mz/logging/my-logfile.xml");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new XMLFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        LOGGER.addHandler(consoleHandler);
        LOGGER.addHandler(fileHandler);
        LOGGER.setLevel(Level.ALL);
        LOGGER.log(Level.INFO, "This is an info message");
        LOGGER.log(Level.WARNING, "This is a warning message");
        LOGGER.log(Level.FINE, "This is a fine message");
    }
}
