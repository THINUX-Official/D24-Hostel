package lk.ijse.d24.hostel.bo;

/*
    @author THINUX
    @created 13-Apr-23 - 11:24 
*/

import lk.ijse.d24.hostel.bo.custom.impl.RoomBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        return boFactory == null
                ? boFactory = new BOFactory()
                : boFactory;
    }

    public enum BOTypes{
        ROOM, STUDENT, RESERVATION, USER
    }

    public SuperBO getBOTypes(BOTypes boTypes){
        switch (boTypes){
            case ROOM:
                return new RoomBOImpl();
            default:
                return null;
        }
    }
}
