package com.app.retrofit.Models.Relations;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.app.retrofit.Models.Participants;
import com.app.retrofit.Models.Sessions;

/**
 * Created by djlophu on 04/03/15.
 */
@Table(name="ParticipantScheduleItems")
public class ParticipantScheduleItems extends Model {

    @Column(name= "sessionId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Sessions sessions;

    @Column(name="participantId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Participants participants;

    public ParticipantScheduleItems() {
        super();
    }

}
