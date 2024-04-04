package acac.airbnb.be.service;

import acac.airbnb.be.data.dto.RoomDTO;
import acac.airbnb.be.data.dto.MainDTO;

public interface RoomService {
    /**
     * 비지니스 로직 인터페이스
     */

    // Create

    // Read
    MainDTO getMainRoomsInfo();
    RoomDTO getRoomInfo(Integer roomId);

    // Update

    // Delete
}