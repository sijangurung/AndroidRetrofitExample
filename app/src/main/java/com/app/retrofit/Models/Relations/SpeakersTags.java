package com.app.retrofit.Models.Relations;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.app.retrofit.Models.Speakers;
import com.app.retrofit.Models.Tags;

/**
 * Created by djlophu on 04/03/15.
 */
@Table(name="SpeakersTags")
public class SpeakersTags extends Model {

    @Column(name= "tagId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Tags tags;

    @Column(name="speakerId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Speakers speakers;

    public SpeakersTags() {
        super();
    }

}
