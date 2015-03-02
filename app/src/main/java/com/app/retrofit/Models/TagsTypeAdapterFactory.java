package com.app.retrofit.Models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by djlophu on 02/03/15.
 */
public class TagsTypeAdapterFactory implements TypeAdapterFactory {
    public final String TAG = "AdapterFactory";
    @Override
    public <T> TypeAdapter<T> create(Gson gson,final TypeToken<T> tTypeToken) {
        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, tTypeToken);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

        return new TypeAdapter<T>() {

            @Override
            public T read(JsonReader jsonReader) throws IOException {
              //  JsonElement jsonElement = elementAdapter.read(jsonReader);

                JsonElement jsonElement = valuesOrElement(elementAdapter.read(jsonReader));


                if (jsonElement.isJsonArray()) {

                    JsonArray jsonArray = jsonElement.getAsJsonArray();

                    System.out.println("I am in with: "+jsonArray.toString());

                }


                return delegate.fromJsonTree(jsonElement);
            }
            @Override
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                delegate.write(jsonWriter , t);
            }
        }.nullSafe();
    }
    private JsonElement valuesOrElement(JsonElement element) {
        if (!element.isJsonObject()) return element;

        JsonObject obj = element.getAsJsonObject();
        if (!hasJsonArrayKey("values", obj)) return element;

        return obj.get("values");
    }

    private boolean hasJsonArrayKey(String key, JsonObject json) {
        return json.has(key) && json.get(key).isJsonArray();
    }
}
