package com.example.demoguesttest.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/guest")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> getGuests(){
        return guestService.getGuests();
    }

    @PostMapping
    public void registerNewGuest(@RequestBody Guest guest){
        guestService.addNewGuest(guest);
    }

    @DeleteMapping("{guestId}")
    public void deleteGuest(@PathVariable("guestId") Long guestId){
        guestService.deleteGuest(guestId);
    }

    @PutMapping(path = "{guestId}")
    public void updateGuest(
            @PathVariable("guestId") Long guestId,
            @RequestParam(required = false) String guestName){
        guestService.updateGuest(guestId, guestName);
    }
}
