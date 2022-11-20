package com.example.demoguesttest.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests(){
      return guestRepository.findAll();
    }

    public void addNewGuest(Guest guest) {
        Optional<Guest> guestOptional = guestRepository.findGuestByName(guest.getGuestName());
        if (guestOptional.isPresent()){
            throw new IllegalStateException("guestName taken");
        }
        guestRepository.save(guest);
    }

    public void deleteGuest(Long guestId) {
        boolean exists = guestRepository.existsById(guestId);
        if (!exists){
            throw new IllegalStateException("guest with id" + guestId + "does not exists");
        }
        guestRepository.deleteById(guestId);
    }

    @Transactional
    public void updateGuest(Long guestId, String guestName) {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new IllegalStateException(
                        "guest with id" + guestId + "does not exist"));

        if (guestName != null && guestName.length() > 0 &&
        !Objects.equals(guest.getGuestName(), guestName)){
            guest.setGuestName(guestName);
        }
    }
}
