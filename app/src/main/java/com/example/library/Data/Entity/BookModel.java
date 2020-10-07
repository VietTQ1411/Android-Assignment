package com.example.library.Data.Entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookModel{
    private int id;
    private String imageUrl;
    private String name;
    private String author;
    private int rate;
    private String description;


    public static ArrayList<BookModel> generateFakeBooks() {
        ArrayList<BookModel> books = new ArrayList<>();
        books.add(new BookModel(1,"https://www.scotsman.com/images-e.jpimedia.uk/imagefetch/http://www.scotsman.com/webimage/Prestige.Item.1.74151213!image/image.jpg?crop=982:524,smart&width=990",
                "Lap trinh C", "Nguyen Van A", 3, "Day la quteb CCC"));
        books.add(new BookModel(2,"https://www.scotsman.com/images-e.jpimedia.uk/imagefetch/http://www.scotsman.com/webimage/1.4921349!image/image.jpg?&width=640",
                "Android Koptlin", "bu ge wlkds ", 1, "Day la quteb CCC"));
        books.add(new BookModel(3,"https://www.scotsman.com/images-e.jpimedia.uk/imagefetch/http://www.scotsman.com/webimage/1.4921351!image/image.jpg?&width=640","C# lap trinh", "Alelne", 3, "Day la quteb CCC"));
        books.add(new BookModel(4,"https://www.scotsman.com/images-e.jpimedia.uk/imagefetch/http://www.scotsman.com/webimage/1.4921351!image/image.jpg?&width=640","Kotlin", "Joe je", 5, "Day la quteb CCC"));
        books.add(new BookModel(5,"https://www.scotsman.com/images-e.jpimedia.uk/imagefetch/http://www.scotsman.com/webimage/1.4921351!image/image.jpg?&width=640","ReactJS", "rrttr", 3, "Day la quteb CCC"));
        books.add(new BookModel(6,"https://www.scotsman.com/images-e.jpimedia.uk/imagefetch/http://www.scotsman.com/webimage/1.4921351!image/image.jpg?&width=640","Flutter", "sewerw", 5, "Day la quteb CCC"));
        books.add(new BookModel(7,"https://www.scotsman.com/images-e.jpimedia.uk/imagefetch/http://www.scotsman.com/webimage/1.4921351!image/image.jpg?&width=640","Dotnet Core", "weere", 2, "Day la quteb CCC"));
        books.add(new BookModel(8,"https://www.scotsman.com/images-e.jpimedia.uk/imagefech/http://www.scotsman.com/webimage/1.4921351!image/image.jpg?&width=640","ios", "eeewwrwer", 1, "Day la quteb CCC"));

        return books;
    }

    public static BookModel convertFromJSonToObject(JSONObject object) {
        try {
            return BookModel.builder()
                    .id(object.getInt("id"))
                    .imageUrl(object.getString("imageUrl"))
                    .name(object.getString("name"))
                    .author(object.getString("author"))
                    .rate(object.getInt("rate"))
                    .description(object.getString("description"))
                    .build();
        } catch (JSONException e) {
            return null;
        }
    }
}