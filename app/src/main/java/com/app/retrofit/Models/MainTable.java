package com.app.retrofit.Models;

import com.app.retrofit.Models.Relations.ParticipantsTags;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by djlophu on 02/03/15.
 */
public class MainTable {

    @SerializedName("tags")
    public ArrayList<Tags> tags;
    @SerializedName("participants")
    public ArrayList<Participants> participants;
    @SerializedName("speakers")
    public ArrayList<Speakers> speakers;
    @SerializedName("sessions")
    public ArrayList<Sessions> sessions;
    @SerializedName("rooms")
    public ArrayList<Rooms> rooms;

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public ArrayList<Participants> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participants> participants) {
        this.participants = participants;
    }

    public ArrayList<Speakers> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(ArrayList<Speakers> speakers) {
        this.speakers = speakers;
    }

    public ArrayList<Sessions> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Sessions> sessions) {
        this.sessions = sessions;
    }

    public ArrayList<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Rooms> rooms) {
        this.rooms = rooms;
    }


    public void saveParticipantTags(Tags tag , Participants participant) {

            ParticipantsTags ptObject = new ParticipantsTags();
            ptObject.tags=tag;
            ptObject.participants=participant;
            ptObject.save();


    }
}
