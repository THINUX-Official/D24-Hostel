package lk.ijse.d24.hostel.view.tm;

/*
    @author THINUX
    @created 13-Apr-23 - 11:40 
*/

public class RoomTM {
    String roomTypeId;
    String roomType;
    String keyMoney;
    int roomQty;

    public RoomTM() {
    }

    public RoomTM(String roomTypeId, String roomType, String keyMoney, int roomQty) {
        this.roomTypeId = roomTypeId;
        this.roomType = roomType;
        this.keyMoney = keyMoney;
        this.roomQty = roomQty;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getRoomQty() {
        return roomQty;
    }

    public void setRoomQty(int roomQty) {
        this.roomQty = roomQty;
    }

    @Override
    public String toString() {
        return "RoomTM{" +
                "roomTypeId='" + roomTypeId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", keyMoney='" + keyMoney + '\'' +
                ", roomQty=" + roomQty +
                '}';
    }
}

