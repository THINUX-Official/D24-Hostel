package lk.ijse.d24.hostel.entity;

/*
    @author THINUX
    @created 01-Apr-23 - 19:40 
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "room")
public class Room {
    @Id
    @Column(name = "room_type_id", length = 10)
    String roomTypeId;

    @Column(name = "room_type")
    String type;

    @Column(name = "room_key_money")
    String keyMoney;

    @Column(name = "room_qty")
    int qty;

    public Room() {
    }

    public Room(String roomTypeId, String type, String keyMoney, int qty) {
        this.roomTypeId = roomTypeId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomTypeId='" + roomTypeId + '\'' +
                ", type='" + type + '\'' +
                ", keyMoney='" + keyMoney + '\'' +
                ", qty=" + qty +
                '}';
    }
}
