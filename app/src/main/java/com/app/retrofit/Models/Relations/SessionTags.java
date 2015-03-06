package com.app.retrofit.Models.Relations;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.app.retrofit.Models.Sessions;
import com.app.retrofit.Models.Tags;

/**
 * Created by djlophu on 04/03/15.
 */
@Table(name="SessionTags")
public class SessionTags extends Model {

    @Column(name= "sessionId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Sessions sessions;

    @Column(name="tagId",onDelete = Column.ForeignKeyAction.CASCADE, onUpdate = Column.ForeignKeyAction.CASCADE)
    public Tags  tags;

    public SessionTags() {
        super();
    }

}
