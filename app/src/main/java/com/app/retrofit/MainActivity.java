package com.app.retrofit;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.app.retrofit.Models.Category;
import com.app.retrofit.Models.Item;
import com.app.retrofit.Models.MainTable;
import com.app.retrofit.Models.Participants;
import com.app.retrofit.Models.Rooms;
import com.app.retrofit.Models.Tags;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.app.com.androidretrofitexample.R;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class MainActivity extends Activity {
    public final String TAG ="MainActivity";
    public final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ1cm46bWljcm9zb2Z0OndpbmRvd3MtYXp1cmU6enVtbyIsImF1ZCI6InVybjptaWNyb3NvZnQ6d2luZG93cy1henVyZTp6dW1vIiwibmJmIjoxNDI0OTc5NTQ0LCJleHAiOjE0Mjc1NzE1NDQsInVybjptaWNyb3NvZnQ6Y3JlZGVudGlhbHMiOiJ7fSIsInVpZCI6IjMsMyIsInZlciI6IjIifQ.YgQydkIxi3GgsR-w5FulV-Xff0IfIS15pBlet84hF3Y";
    TextView txtAll,txtStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        txtAll = (TextView) findViewById(R.id.editTextAll);
        txtStatus = (TextView) findViewById(R.id.txtStatus);

        //new SyncDatabase().execute();

        Category restaurants = new Category();
        restaurants.name = "Restaurants";

        restaurants.save();

        Item item = new Item();
        item.category = restaurants;
        item.name = "Outback Steakhouse";
        item.save();

        item = new Item();
        item.category = restaurants;
        item.name = "Red Robin";
        item.save();

        item = new Item();
        item.category = restaurants;
        item.name = "Olive Garden";
        item.save();

    }

    private class SyncDatabase extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtStatus.setText("Loading...");

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtStatus.setText("All data Loaded...");
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            try{
                RequestInterceptor requestInterceptor = new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("X-ZUMO-AUTH", token);
                    }
                };

                Gson gson=new GsonBuilder()
                        .registerTypeAdapterFactory(new TagsTypeAdapterFactory()) // This is the important line ;)
                        .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                        .create();

                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint("https://eventeye.azure-mobile.net/api")
                        .setConverter(new GsonConverter(gson))
                        .setRequestInterceptor(requestInterceptor)
                        .build();
                         EventEyeService eventService = restAdapter.create(EventEyeService.class);

                eventService.getTags(null, new Callback<MainTable>() {
                    @Override
                    public void success(MainTable maintable, Response response) {
                        ActiveAndroid.beginTransaction();
                        try {
                            ArrayList<Tags> tagsObject = maintable.getTags();
                            for (int i = 0; i < tagsObject.size(); i++) {
                                //This is going to DB...
                                Tags tags = tagsObject.get(i);
                                tags.save();
                            }
                            txtAll.setText("ALL THE TAGS Saved..\n");

                            ArrayList<Participants> participantsObject = maintable.getParticipants();
                            for (int i = 0; i < participantsObject.size(); i++) {
                                      //This is going to DB..
                                Participants participants = participantsObject.get(i);
                                           participants.save();
                                //now for the relation part..
                                maintable.saveParticipantTags(participantsObject.get(i).getTags(), participantsObject.get(i).participantId);
                            }
                            txtAll.setText(txtAll.getText() + "ALL THE Participants Saved.....\n");

                            ArrayList<Rooms> roomObject = maintable.getRooms();
                            txtAll.setText(txtAll.getText() + "ALL THE Rooms ----> \n");
                            for (int i = 0; i < roomObject.size(); i++) {

                            }
                            ActiveAndroid.setTransactionSuccessful();
                        }finally{
                            ActiveAndroid.endTransaction();
                        }

                    }//END of SUCCESS..


                    @Override
                    public void failure(RetrofitError retrofitError) {
                        Log.e(TAG,"error occurred!"+retrofitError);

                    }
                });
            }catch(Exception e){
                e.printStackTrace();
                return "failure";
            }
            return "success";
        }
    }
}

