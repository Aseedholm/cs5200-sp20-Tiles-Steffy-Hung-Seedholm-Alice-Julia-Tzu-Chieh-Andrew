package edu.northeastern.cs5200.dataloader;


import edu.northeastern.cs5200.daos.LibraryDao;
import edu.northeastern.cs5200.models.Author;
import edu.northeastern.cs5200.models.Book;
import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

@Component
public class GoogleBooksAPI {

    LibraryDao libraryDao;

    public GoogleBooksAPI(LibraryDao libraryDao){
        this.libraryDao = libraryDao;
    }


    public void loadFromAPI() throws IOException, ParseException {

        // Cast API call into URL object
        //URL myURL = new URL("http://googleapis.com/books/v1/volumes?q=quilting");
        URL myURL = new URL("https://www.googleapis.com/books/v1/volumes?q=quilting" +
                "&key=AIzaSyDzAEzIpOLfuwaEQcXsB-5vSN7b7lzJiMc");

        // Cast into HttpURLConnection object, specify GET request, start connection
        HttpURLConnection conn = (HttpURLConnection)myURL.openConnection();
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
                result+=sc.nextLine();
            }


            sc.close();
            conn.disconnect();

            // This tool will help us parse the unstructured data
            JSONParser parse = new JSONParser();

            // Convert string object into JSON objects
            JSONObject jObj = (JSONObject)parse.parse(result);

            // Convert JSON object into JSONArray object:
            JSONArray jsonarr_1 = (JSONArray) jObj.get("items");

            // Get data in that array
            for (int i = 0; i < jsonarr_1.size(); i++) {
                System.out.println("Book #" + i);
                JSONObject book = (JSONObject) jsonarr_1.get(i);
                Pair<Book, Author> bookAndAuthor = JSONtoBook(book);
                Book newBook = bookAndAuthor.getKey();
                Author newAuthor = bookAndAuthor.getValue();
                System.out.println("BOOK: " + newBook);

                libraryDao.createAuthor(newAuthor);
                libraryDao.createBook(newBook);

            }


        }


    }

    private static Date StringToDate(String input) {

        // Possible inputs:
        /*
        publishedDate": "2019-08-27",
        "publishedDate": "2020-03",
        publishedDate": "1997",
         */

        Integer year = Integer.valueOf(input.substring(0,4));
        Integer month = 1;
        Integer day = 1;

        if (input.length() > 4) {
            month = Integer.valueOf(input.substring(5,6));
        }

        if (input.length() > 7) {
            day = Integer.valueOf(input.substring(8,9));
        }

        Calendar cal = Calendar.getInstance();

        // set Date portion to January 1, 1970
        cal.set( cal.YEAR, year );
        cal.set( cal.MONTH, month );
        cal.set( cal.DATE, day );

        return new java.sql.Date( cal.getTime().getTime() );
    }

    private static Pair<Book,Author> JSONtoBook(JSONObject inputBook) {
        Book newBook = new Book();

        String id = (String) inputBook.get("id");
        newBook.setId(id);

        JSONObject volumeInfo = (JSONObject) inputBook.get("volumeInfo");

        String title = (String) volumeInfo.get("title");
        newBook.setTitle(title);

        JSONArray industryIdentifiers = (JSONArray) volumeInfo.get("industryIdentifiers");

        JSONObject identifierOne = (JSONObject) industryIdentifiers.get(0);
        String isbn = (String) identifierOne.get("identifier");
        newBook.setISBN(isbn);

        Date publishedDate = StringToDate((String)volumeInfo.get("publishedDate"));
        newBook.setYearPublished(publishedDate);

        JSONArray authors = (JSONArray) volumeInfo.get("authors");
        String author = "";
        try {
            author = (String) authors.get(0);
        } catch (NullPointerException e) {
            author = null;
        }

        Author newAuthor = new Author();
        newAuthor.setFirstName(author); //TODO separate first and last name
        newBook.setAuthor(newAuthor);

        System.out.println("book: " + newBook);
        System.out.println("author: " + newAuthor);


        return new Pair<>(newBook,newAuthor);
    }


}
