package acac.airbnb.be.service;

import acac.airbnb.be.data.dto.ImagePathDTO;

public interface RoomService {
    // =======================
    /* 비지니스 로직 인터페이스 */
    // =======================

    // Create

    // Read
    ImagePathDTO getImagePath(Integer roomId);

    // Update

    // Delete
}