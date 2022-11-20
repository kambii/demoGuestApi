package com.example.demoguesttest.guest;

import javax.persistence.*;


@Entity
@Table
public class Guest {

    @Id
    @SequenceGenerator(
            name = "guest_sequence",
            sequenceName = "guest_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guest_sequence"
    )
    private Long id;
    private String guestName;

    public Guest() {
    }

    public Guest(Long id, String guestName) {
        this.id = id;
        this.guestName = guestName;
    }

    public Guest(String guestName) {
        this.guestName = guestName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                '}';
    }
}
