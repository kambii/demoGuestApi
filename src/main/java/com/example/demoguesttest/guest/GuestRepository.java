package com.example.demoguesttest.guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    @Query("SELECT s FROM Guest s WHERE s.guestName = ?1")
    Optional<Guest> findGuestByName(String guestName);
}
