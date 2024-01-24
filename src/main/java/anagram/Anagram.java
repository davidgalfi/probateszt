package anagram;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.GET;

import Utils.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Path("/")
public class Anagram {

    public List<String> getAllPermutation(String word) {
        return (ArrayList<String>) Util.generateWordPermutations(word);
    }

    public List<String> getRightPermutation(String word) throws IOException {
        ArrayList<String> allPermutation = (ArrayList<String>) Util.generateWordPermutations(word);
        return getContainedWords(allPermutation, DataLoader.WORDS);
    }

    public List<WordApiResponse> getWordsAttribute(String word) throws IOException, InterruptedException {
        OkHttpClient client = new OkHttpClient();

        ArrayList<String> allWord= (ArrayList<String>) getRightPermutation(word);
        ArrayList<WordApiResponse> allInformation = new ArrayList<>();
        for(String words : allWord){
            Request request = new Request.Builder()
                    .url("https://api.dictionaryapi.dev/api/v2/entries/en/" + words)
                    .build();

            Call call = client.newCall(request);
            Response response = call.execute();

            String jsonResponse = response.body().string();

            Gson gson = new Gson();
            Type listType = new TypeToken<List<WordApiResponse>>() {}.getType();
            List<WordApiResponse> wordApiResponseList = gson.fromJson(jsonResponse, listType);

            System.out.println(wordApiResponseList);

            allInformation.addAll(wordApiResponseList);
        }

        for(WordApiResponse wordApiResponse : allInformation){
            System.out.println(wordApiResponse);
        }

        return allInformation;
    }

    @GET
    @Path("/permutations")
    public JSONObject getAllPermutationApi(@QueryParam("word") String word) throws IOException, InterruptedException {
        List<String> words = getAllPermutation(word);
        return new JSONObject().put("anagram", new JSONArray(words));
    }

    @GET
    @Path("/anagram")
    public JSONObject getAllAnagramApi(@QueryParam("word") String word) throws IOException, InterruptedException {
        List<WordApiResponse> wordApiResponses = getWordsAttribute(word);
        return new JSONObject().put("anagram", new JSONArray(wordApiResponses));
    }

    public static ArrayList<String> getContainedWords(ArrayList<String> allPermutation, List<String> words) {
        ArrayList<String> wordArray = new ArrayList<>();
        for(String word : allPermutation){
            if(DataLoader.isValidWord(word)) wordArray.add(word);
        }
        return wordArray;
    }
}
