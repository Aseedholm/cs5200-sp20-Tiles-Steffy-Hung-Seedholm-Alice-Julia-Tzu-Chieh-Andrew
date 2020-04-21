package edu.northeastern.cs5200.dataloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.northeastern.cs5200.daos.LibraryDao;
import edu.northeastern.cs5200.models.Author;
import edu.northeastern.cs5200.models.Book;
import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.net.URI;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Scanner;

public class GoodReadsAPI {

    /**
     * Here is your developer key for using the Goodreads API. This key must be appended to every request using the form variable 'key'. (If you're using our write API, you'll need your secret too.)
     *
     * key: QkpUAjvtyYyvQf3WSsYCfQ
     * secret: ijf4LlK4Cq5Zi18yhHU6g7AdYMRfimeEDh6Ewuo99Po
     */


    LibraryDao libraryDao;

    public GoodReadsAPI(LibraryDao libraryDao){
        this.libraryDao = libraryDao;
    }


    public String authorToAuthorID(String authorName) throws IOException, ParseException, ParserConfigurationException, SAXException, XPathExpressionException {

        String url = "https://www.goodreads.com/api/author_url/" + authorName + "?key=QkpUAjvtyYyvQf3WSsYCfQ";

        System.out.println("url: " + url);
        // Cast API call into URL object
        URL myURL = new URL(url);

        // Cast into HttpURLConnection object, specify GET request, start connection
        HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        // Make sure connection works
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("HttpResponseCode: " + conn.getResponseCode());
        }

        // Retrieve JSON data
        else {
            String result = "";

            Scanner sc = new Scanner(myURL.openStream());
            while (sc.hasNext()) {
                result += sc.nextLine();
            }

            sc.close();
            conn.disconnect();


            InputSource source = new InputSource(new StringReader(result));
            XPath xpath = XPathFactory.newInstance().newXPath();
            Object author = xpath.evaluate("/GoodreadsResponse/author", source, XPathConstants.NODE);
            String id = xpath.evaluate("@id", author);

            System.out.println("id: " + id);
            return id;


        }
    }



}
