/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaJdbc;

/**
 *部屋データ
 * @author hangt
 */
public class HeyaBean {

    private String roomId;
    private String syozokuPropertyId;
    private String roomName;
    private String roomFloor;
    private String price;
    private String station;
    private String roomArea;
    private String minutesFromStation;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSyozokuPropertyId() {
        return syozokuPropertyId;
    }

    public void setSyozokuPropertyId(String syozokuPropertyId) {
        this.syozokuPropertyId = syozokuPropertyId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea;
    }

    public String getMinutesFromStation() {
        return minutesFromStation;
    }

    public void setMinutesFromStation(String minutesFromStation) {
        this.minutesFromStation = minutesFromStation;
    }
    
}

