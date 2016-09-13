package com.biomined.ouchihuahua.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 5/1/13
 * Time: 3:09 PM
 */
@Entity
@Table
public class User implements IsSerializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CascadeOnDelete
    private Long id;
    private String username;
    private String email;
    private boolean active = true;

    @OneToMany(mappedBy = "user")
    private List<PainEvent> painEvents = new ArrayList<PainEvent>();
    private String passwordHash;
    private String tags;


    public User() {
    }

    public User(String username, String passwordHash) {

        this.username = username;
        this.passwordHash = passwordHash;
    }

    public User(String username) {
        this.username = username;
    }

    public User(UserDTO userDTO) {

        if (userDTO.getId() != null) {
            this.id = userDTO.getId();
        }

        if (userDTO.getUsername() != null) {
            this.username = userDTO.getUsername();
        }

        if (userDTO.getPasswordHash() != null) {
            this.passwordHash = userDTO.getPasswordHash();
        }

        if (userDTO.getEmail() != null) {
            this.email = userDTO.getEmail();
        }

    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public List<PainEvent> getPainEvents() {
        return painEvents;
    }


    public void setPainEvents(List<PainEvent> painEvents) {
        this.painEvents = painEvents;
    }

    public void addPainEvent(PainEvent painEvent) {
        painEvents.add(painEvent);
    }

    public Long getId() {
        return id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", painEvents=" + painEvents +
                ", passwordHash='" + passwordHash + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
