package com.mohanadalkrunz99.firebaseauth;

public class Note {
    String id;
    String title ;
    String desc;
    long createdAt;
    long lastUpdate;


    public Note(){}

    public Note(String id, String title, String desc, long createdAt, long lastUpdate) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
