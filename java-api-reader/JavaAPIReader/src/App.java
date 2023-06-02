import java.io.FileWriter;
import java.io.BufferedWriter;
//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class App {

    public static void main(String[] args) throws URISyntaxException {
        String outputFile = "kemanim.txt";
        try {
            String apiUrl = "https://api-nba-v1.p.rapidapi.com/games?season=2022";

            // Create URL object
            URL url = new URI(apiUrl).toURL(); // new URL(apiUrl);

            // Create HttpURLConnection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Set request headers
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("X-RapidAPI-Key", "");
            conn.setRequestProperty("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com");
            // Add any other required headers

            // Check if the request was successful
            if (conn.getResponseCode() == 200) {
                InputStreamReader reader = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
                StringBuilder response = new StringBuilder();
                char[] buffer = new char[1024];
                int bytesRead;
                while ((bytesRead = reader.read(buffer)) != -1) {
                    response.append(buffer, 0, bytesRead);
                }
                reader.close();

                // Write response to file
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                writer.write(response.toString());
                writer.close();
                System.out.println("Reponse written to file");

                
            } else {
                System.out.println("Failed to fetch data. HTTP error code: " + conn.getResponseCode());
            }

            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
