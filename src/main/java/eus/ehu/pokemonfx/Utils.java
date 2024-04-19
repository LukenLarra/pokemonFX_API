package eus.ehu.pokemonfx;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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



    public static String query(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
