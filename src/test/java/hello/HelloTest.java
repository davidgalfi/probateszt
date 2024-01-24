package hello;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import anagram.Anagram;
import anagram.DataLoader;
import anagram.WordApiResponse;
import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HelloTest {

    @Test
    public void testHello() throws Exception {
        Hello hello = new Hello();

        JSONObject helloResponse = hello.getHello();

        assertThat(helloResponse.keySet().size(), Matchers.equalTo(1));
        assertThat(helloResponse.keySet(), Matchers.contains("hello"));
        assertThat(helloResponse.getString("hello"), Matchers.equalTo("Hello"));
    }

    @Test
    public void testAllPermutation() throws Exception {
        Anagram anagram = new Anagram();

        List<String> anagramAllPermutationResponse = anagram.getAllPermutation("asd");

        assertEquals(6, anagramAllPermutationResponse.size());
    }

    @Test
    public void testRightPermutations() throws Exception {
        Anagram anagram = new Anagram();
        DataLoader dataLoader = new DataLoader();
        dataLoader.contextInitialized();

        List<String> anagramRightPermutationResponse = anagram.getRightPermutation("gto");

        assertEquals(2, anagramRightPermutationResponse.size());
    }

    @Test
    public void testWordsAttribute() throws Exception {
        Anagram anagram = new Anagram();
        DataLoader dataLoader = new DataLoader();
        dataLoader.contextInitialized();

        List<WordApiResponse> information = anagram.getWordsAttribute("gto");

        assertEquals(3, information.size());
    }
}
