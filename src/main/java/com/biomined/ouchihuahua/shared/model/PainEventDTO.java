package com.biomined.ouchihuahua.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/1/13
 * Time: 4:01 PM
 */
public class PainEventDTO implements IsSerializable {

    private String id;
    private String created;
    private String onset;
    private String severity;
    private String type;
    private String hoursSlept;
    //    private String location;
    private String notes;
    private double latitude;
    private double longitude;
    private String tags;
    private String remedies; //map of medicine : time taken
    private UserDTO userDTO;


    public PainEventDTO() {
    }

    public PainEventDTO(PainEvent painEvent) {

        this.id = painEvent.getId().toString();

        if (painEvent.getCreated() != null) {
            this.created = painEvent.getCreated().toLocaleString();
        }

        if (painEvent.getOnset() != null) {
            this.onset = painEvent.getOnset().toLocaleString();
        }

        if (painEvent.getSeverity() != null) {
            this.severity = painEvent.getSeverity().toString();
        }

        if (painEvent.getPainType() != null) {
            this.type = painEvent.getPainType();
        }

        if (painEvent.getHoursSlept() != null) {
            this.hoursSlept = painEvent.getHoursSlept().toString();
        }

        if (painEvent.getNotes() != null) {
            this.notes = painEvent.getNotes();
        }

        this.latitude = painEvent.getLatitude();
        this.longitude = painEvent.getLongitude();

        if (painEvent.getTags() != null) {
            this.tags = painEvent.getTags();
        }

        if (painEvent.getRemedies() != null) {
            this.remedies = painEvent.getRemedies();
        }

        if (painEvent.getUser() != null) {
            this.userDTO = new UserDTO(painEvent.getUser());
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getOnset() {
        return onset;
    }

    public void setOnset(String onset) {
        this.onset = onset;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getPainType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemedies() {
        return remedies;
    }

    public void setRemedies(String remedies) {
        this.remedies = remedies;
    }

    public String getHoursSlept() {
        return hoursSlept;
    }

    public void setHoursSlept(String hoursSlept) {
        this.hoursSlept = hoursSlept;
    }

//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDisplayString() {
        return null;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
