package com.app.retrofit.Models.Relations;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.app.retrofit.Models.Participants;
import com.app.retrofit.Models.Tags;

/**
 * Created by djlophu on 04/03/15.
 */
@Table(name="ParticipantsTags")
public class ParticipantsTags extends Model {

    @Column(name= "tagId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Tags tags;

    @Column(name="participantId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Participants participants;

    public ParticipantsTags() {
        super();
    }

}
