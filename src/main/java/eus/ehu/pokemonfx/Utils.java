package eus.ehu.pokemonfx;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static String readFile(String filename) {
        String content = "";
        try {
            // read filename from resources folder
            URL fileURL = Utils.class.getResource(filename);
            content = new String(Files.readAllBytes(Paths.get(fileURL.getFile())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
