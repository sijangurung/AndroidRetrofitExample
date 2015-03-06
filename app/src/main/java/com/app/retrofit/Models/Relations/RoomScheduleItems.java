package com.app.retrofit.Models.Relations;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.app.retrofit.Models.Rooms;
import com.app.retrofit.Models.Sessions;

/**
 * Created by djlophu on 04/03/15.
 */
@Table(name="RoomScheduleItems")
public class RoomScheduleItems extends Model {

    @Column(name= "sessionId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Sessions sessions;

    @Column(name="roomId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Rooms rooms;

    public RoomScheduleItems() {
        super();
    }

}
