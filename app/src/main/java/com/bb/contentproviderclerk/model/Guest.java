package com.bb.contentproviderclerk.model;

public class Guest {

    private int guestId;

    private String guestName;

    private  String guestRoomNumber;

    public Guest(int guestId, String guestName, String guestRoomNumber) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.guestRoomNumber = guestRoomNumber;
    }

    public Guest(String guestName, String guestRoomNumber) {
        this.guestName = guestName;
        this.guestRoomNumber = guestRoomNumber;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestRoomNumber() {
        return guestRoomNumber;
    }

    public void setGuestRoomNumber(String guestRoomNumber) {
        this.guestRoomNumber = guestRoomNumber;
    }

}
