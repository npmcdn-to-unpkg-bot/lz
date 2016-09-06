package sk.liptovzije.model;

import java.util.Date;

/**
 * Created by jan.husenica on 9/2/2016.
 */
public class Event {

    private long id;
    private Date startsDate;
    private Date endDate;
    private String headline;

    public Event (long id, Date start, Date end, String name) {
        this.id = id;
        this.startsDate = start;
        this.endDate = end;
        this.headline = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartsDate() {
        return startsDate;
    }

    public void setStartsDate(Date startsDate) {
        this.startsDate = startsDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}
