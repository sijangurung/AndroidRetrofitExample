package com.app.retrofit.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by djlophu on 04/03/15.
 */
@Table(name="ParticipantsTags")
public class ParticipantsTags extends Model {

    @Column(name= "tagId")
    public Integer tagId;

    @Column(name="participantId")
    public Integer participantId;

    public ParticipantsTags() {
        super();
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }
}
