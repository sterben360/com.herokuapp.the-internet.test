package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    public List<ToDo> getToDos(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<ToDo>>(){}.getType());
    }

    public List<String> getTitles(String json){
        List<String> titles = new ArrayList<>();
        List<ToDo> toDoList = this.getToDos(json);

        for (ToDo toDo : toDoList) {
            titles.add(toDo.getTitle());
        }

        return titles;
    }
}
