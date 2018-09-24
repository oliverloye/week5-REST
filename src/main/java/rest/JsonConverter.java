package rest;

import com.google.gson.Gson;
import entity.Pet;
import java.util.List;

public class JsonConverter {

    public static Pet getPersonFromJson(String json) {
        return new Gson().fromJson(json, Pet.class);
    }

    public static String getJSONFromPerson(Pet pet) {
        return new Gson().toJson(pet);
    }

    public static String getJSONFromPersons(List<Pet> pets) {
        return new Gson().toJson(pets);
    }
}
