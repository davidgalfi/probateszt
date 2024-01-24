package hello;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

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
    public void testDataLoad() {
        DataLoader dataLoader = new DataLoader();
        dataLoader.contextInitialized();

        assertNotEquals(0, DataLoader.numberOfWords);
    }

    @Test
    public void checkIsValidWord() {
        DataLoader dataLoader = new DataLoader();
        dataLoader.contextInitialized();

        assertTrue(DataLoader.isValidWord("got"));
        assertTrue(DataLoader.isValidWord("hello"));
        assertTrue(DataLoader.isValidWord("window"));
        assertFalse(DataLoader.isValidWord("asd"));
        assertFalse(DataLoader.isValidWord("aple"));
        assertFalse(DataLoader.isValidWord("app-le"));
    }

    @Test
    public void testAllPermutation() {
        Anagram anagram = new Anagram();

        List<String> anagramAllPermutationResponse_01 = anagram.getAllPermutation("asd");
        List<String> anagramAllPermutationResponse_02 = anagram.getAllPermutation("aple");
        List<String> anagramAllPermutationResponse_03 = anagram.getAllPermutation("hello");
        List<String> anagramAllPermutationResponse_04 = anagram.getAllPermutation("window");
        List<String> anagramAllPermutationResponse_05 = anagram.getAllPermutation("asd");
        List<String> anagramAllPermutationResponse_06 = anagram.getAllPermutation("a");
        List<String> anagramAllPermutationResponse_07 = anagram.getAllPermutation("window");

        assertEquals(6, anagramAllPermutationResponse_01.size());
        assertEquals(24, anagramAllPermutationResponse_02.size());
        assertEquals(120, anagramAllPermutationResponse_03.size());
        assertEquals(720, anagramAllPermutationResponse_04.size());
        assertNotEquals(0, anagramAllPermutationResponse_05.size());
        assertNotEquals(0, anagramAllPermutationResponse_06.size());
        assertNotEquals(0, anagramAllPermutationResponse_07.size());
    }

    @Test
    public void testRightPermutations() throws Exception {
        Anagram anagram = new Anagram();
        DataLoader dataLoader = new DataLoader();
        dataLoader.contextInitialized();

        List<String> anagramRightPermutationResponse_01 = anagram.getRightPermutation("gto");
        List<String> anagramRightPermutationResponse_02 = anagram.getRightPermutation("aple");
        List<String> anagramRightPermutationResponse_03 = anagram.getRightPermutation("say");
        List<String> anagramRightPermutationResponse_04 = anagram.getRightPermutation("let");
        List<String> anagramRightPermutationResponse_05 = anagram.getRightPermutation("asd");
        List<String> anagramRightPermutationResponse_06 = anagram.getRightPermutation("dus");
        List<String> anagramRightPermutationResponse_07 = anagram.getRightPermutation("windov");
        List<String> anagramRightPermutationResponse_08 = anagram.getRightPermutation("ap-ple");

        assertEquals(2, anagramRightPermutationResponse_01.size());
        assertEquals(4, anagramRightPermutationResponse_02.size());
        assertEquals(3, anagramRightPermutationResponse_03.size());
        assertEquals(2, anagramRightPermutationResponse_04.size());
        assertEquals(2, anagramRightPermutationResponse_05.size());
        assertEquals(1, anagramRightPermutationResponse_06.size());
        assertEquals(0, anagramRightPermutationResponse_07.size());
        assertEquals(0, anagramRightPermutationResponse_08.size());
    }
}
