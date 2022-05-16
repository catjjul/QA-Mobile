import com.google.gson.Gson;

public class PersonParser {
    public static Person Parse(String data) {
        Gson g = new Gson();
        Person person = g.fromJson(data, Person.class);
        return person;
    }
}