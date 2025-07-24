package GemeniApi;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;

public class GeminiBatch2Api {
    public static void main(String[] args) throws Exception {
        String apiKey = "YOUR_API_KEY_HERE";
        String urlStr = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your query (press enter to continue): ");
        String query = userInput.nextLine();
        String json = "{\"contents\":[{\"parts\":[{\"text\":\"" + query + "\"}]}]}";

        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        os.write(json.getBytes());
        os.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            responseBuilder.append(line);
        }
        br.close();

        // Parse the JSON response
        JSONObject responseJson = new JSONObject(responseBuilder.toString());
        JSONArray candidates = responseJson.getJSONArray("candidates");
        if (candidates.length() > 0) {
            JSONObject firstCandidate = candidates.getJSONObject(0);
            JSONObject content = firstCandidate.getJSONObject("content");
            JSONArray parts = content.getJSONArray("parts");
            if (parts.length() > 0) {
                String answer = parts.getJSONObject(0).getString("text");
                System.out.println("\nResponse:\n" + answer);
            }
        } else {
            System.out.println("No answer found.");
        }

    }
}
