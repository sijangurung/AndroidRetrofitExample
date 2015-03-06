package com.app.retrofit;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.app.retrofit.Adapters.TagsTypeAdapterFactory;
import com.app.retrofit.Models.MainTable;
import com.app.retrofit.Models.Participants;
import com.app.retrofit.Models.Rooms;
import com.app.retrofit.Models.Sessions;
import com.app.retrofit.Models.Speakers;
import com.app.retrofit.Models.Tags;
import com.app.retrofit.Service.EventEyeService;
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
    Button btnChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAll = (TextView) findViewById(R.id.editTextAll);
        txtStatus = (TextView) findViewById(R.id.txtStatus);

        new SyncDatabase().execute();

        ActiveAndroid.clearCache();



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
            txtStatus.setText("Data Loading Complete...");
        }

        @Override
        protected String doInBackground(String... params) {
            //Working....
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
                            //Universal Declaration so that other can use it.....
                            ArrayList<Sessions> sessionsObject = new ArrayList<Sessions>();
                            //THIS IS FOR THE TAGS.....
                            ArrayList<Tags> tagsObject = maintable.getTags();
                            for (int i = 0; i < tagsObject.size(); i++) {
                                //This is going to DB...
                                Tags tags = tagsObject.get(i);
                                tags.save();
                            }
                            txtAll.setText("ALL THE TAGS Saved..\n");

                            ActiveAndroid.clearCache();

                            //This is for the Participants ... also with ParticipantRelations.......
                            ArrayList<Participants> participantsObject = maintable.getParticipants();
                            for (Participants participants: participantsObject) {
                                //This is going to DB..
                                participants.save();

                                //now for the relation part..
                                //Participants Tags Relations......
                                for(Integer tagid: participants.getTags()){
                                    //Now i need to find out the tag with this id...
                                    System.out.println(" Tagid:"+tagid+" --> ParticipantId: "+participants.getParticipantId());
                                    for(Tags tags: tagsObject){
                                        if(tags.getTagid() == tagid){
                                            maintable.saveParticipantTags(tags, participants);
                                        }
                                    }
                                } //end of participantTags relations...
                                //NOW FOR THE ParticipantScheduleItems.....
                                for(Integer scheduleItems: participants.getScheduleItems()){
                                    System.out.println(" ParticipantId: "+participants.getParticipantId()+"-->  scheduleItems:"+scheduleItems);
                                    //Here we Save SESSIONS OBJECT...
                                    sessionsObject = maintable.getSessions();
                                    for(Sessions sessions: sessionsObject){
                                        sessions.save();
                                        if(sessions.getSessionId() == scheduleItems){
                                            maintable.saveParticipantScheduleItems(sessions, participants);
                                        }
                                    }

                                }

                            } //end of all participants.....
                            txtAll.setText(txtAll.getText() + "ALL THE Participants Saved.....\n");
                            txtAll.setText(txtAll.getText() + "ALL THE ParticipantTags Relation Saved.....\n");
                            txtAll.setText(txtAll.getText() + "ALL THE ParticipantScheduleItems Relation Saved.....\n");

                            ActiveAndroid.clearCache();

                            //NOW for the Speakers....
                            ArrayList<Speakers> speakersObject = maintable.getSpeakers();
                            for(Speakers speakers: speakersObject){
                                speakers.save(); //Speakers table in database...

                                //now for the relations part..
                                for(Integer tagid: speakers.getTags()) {
                                    //Now i need to find out the tag with this id...
                                    System.out.println( "  SpeakerId: " + speakers.getSpeakerId()+" --> Tagid:" + tagid);
                                    for (Tags tags : tagsObject) {
                                        if (tags.getTagid() == tagid) {
                                            maintable.saveSpeakerTags(tags, speakers);
                                        }
                                    }
                                } //end of SpeakerTags relations.....
                                //NOW FOR THE SpeakerScheduleItemss.....
                                for(Integer scheduleItems: speakers.getScheduleItems()){
                                    System.out.println(" SpeakersId: "+speakers.getSpeakerId()+" --> scheduleItems:"+scheduleItems );
                                    sessionsObject = maintable.getSessions();
                                    for(Sessions sessions: sessionsObject){
                                        if(sessions.getSessionId() == scheduleItems){
                                            maintable.saveSpeakerScheduleItems(sessions, speakers);
                                        }
                                    }

                                }//end of speakersScheduleItems relations.......

                            } //end of Speakers..
                            txtAll.setText(txtAll.getText() + "ALL THE Speakers Saved...\n");
                            txtAll.setText(txtAll.getText() + "ALL THE SpeakerTags Saved...\n");
                            txtAll.setText(txtAll.getText() + "ALL THE SpeakerScheduleItems Saved...\n");

                            ActiveAndroid.clearCache();

                            //Now for the Rooms..... We do it before Sessions because we have to use Room for sessionRoom...
                            ArrayList<Rooms> roomObject = maintable.getRooms();
                            for (Rooms rooms: roomObject) {
                                System.out.println(" RoomId:"+rooms.getRoomId()+" saved... ");
                                    rooms.save();
                                //Now for RoomScheduleItems..
                                for(Integer scheduleItems: rooms.getScheduleItems()){
                                    System.out.println(" RoomId: "+rooms.getRoomId()+" --> scheduleItems:"+scheduleItems );
                                    sessionsObject = maintable.getSessions();
                                    for(Sessions sessions: sessionsObject){
                                        if(sessions.getSessionId() == scheduleItems){
                                            maintable.saveRoomScheduleItems(sessions,rooms);
                                        }
                                    }
                                }
                            }

                            txtAll.setText(txtAll.getText() + "ALL THE Rooms Saved... \n");
                            txtAll.setText(txtAll.getText() + "ALL THE RoomsScheduleItems Saved... \n");

                            ActiveAndroid.clearCache();

                            //Now for the Sessions...Only the Relations..
                            ArrayList<Sessions> sessionObject = maintable.getSessions();
                            for(Sessions sessions: sessionObject){
                                //We have already saved sessions.....on participants saving loop..

                                //This is for SessionRoom Class.....
                                System.out.println(" SessionId: "+sessions.getSessionId()+ " ---> RoomId:"+sessions.getRoomId());
                                for(Rooms rooms: maintable.getRooms()){
                                    if(sessions.getRoomId() == rooms.getRoomId()){
                                            maintable.saveSessionRoom(sessions,rooms);
                                    }
                                }
                                //This is for SessionTags Class....
                                for(Integer tagId: sessions.getTags()) {
                                    System.out.println(" SessionId: " + sessions.getSessionId() + " ---> TagsId:" + tagId);
                                    for (Tags tags : maintable.getTags()) {
                                        if(tags.getTagid() == tagId){
                                            maintable.saveSessionTags(sessions,tags);
                                        }
                                    }
                                }
                                //This is for SessionSpeakers Class....
                                for(Integer speakersId : sessions.getSpeakers()){
                                    System.out.println(" SessionId: " + sessions.getSessionId() + " ---> speakersId:" + speakersId);
                                    for(Speakers speakers: maintable.getSpeakers()){
                                        if(speakers.getSpeakerId() == speakersId){
                                            maintable.saveSessionSpeakers(sessions,speakers);
                                        }
                                    }
                                }
                            }//end of sessions......

                            txtAll.setText(txtAll.getText() + "ALL THE SessionRoom Saved... \n");
                            txtAll.setText(txtAll.getText() + "ALL THE SessionTags Saved... \n");
                            txtAll.setText(txtAll.getText() + "ALL THE SessionSpeakers Saved... \n");
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

