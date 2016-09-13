package com.biomined.ouchihuahua.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 5/1/13
 * Time: 3:19 PM
 */
@Entity
public class PainEvent implements IsSerializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date onset;

    private Integer severity;
    private String painType;
    private Integer hoursSlept;
    private String notes;
    private String tags;
    private String remedies;
    private double latitude;
    private double longitude;

    @ManyToOne
    private User user;

    public PainEvent() {
    }

    public PainEvent(PainEventDTO painEventDTO) {

        if (painEventDTO.getId() != null) {
            this.id = new Long(painEventDTO.getId());
        }

        if (painEventDTO.getCreated() != null) {
            this.created = new Date(painEventDTO.getCreated());
        }

        if (painEventDTO.getOnset() != null) {
            this.onset = new Date(painEventDTO.getOnset());
        }

        if (painEventDTO.getSeverity() != null) {
            this.severity = new Integer(painEventDTO.getSeverity());
        }

        if (painEventDTO.getPainType() != null) {
            this.painType = painEventDTO.getPainType();
        }

        if (painEventDTO.getHoursSlept() != null) {
            this.hoursSlept = new Integer(painEventDTO.getHoursSlept());
        }

        if (painEventDTO.getNotes() != null) {
            this.notes = painEventDTO.getNotes();
        }

        this.latitude = painEventDTO.getLatitude();
        this.longitude = painEventDTO.getLongitude();

        if (painEventDTO.getTags() != null) {
            this.tags = painEventDTO.getTags();
        }

        if (painEventDTO.getRemedies() != null) {
            this.remedies = painEventDTO.getRemedies();
        }

        if (painEventDTO.getUserDTO() != null) {
            this.user = new User(painEventDTO.getUserDTO());
        }

    }

    public Long getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getOnset() {
        return onset;
    }

    public void setOnset(Date onset) {
        this.onset = onset;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getPainType() {
        return painType;
    }

    public void setPainType(String type) {
        this.painType = type;
    }

    public Integer getHoursSlept() {
        return hoursSlept;
    }

    public void setHoursSlept(Integer hoursSlept) {
        this.hoursSlept = hoursSlept;
    }

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

    public String getRemedies() {
        return remedies;
    }

    public void setRemedies(String remedies) {
        this.remedies = remedies;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PainEvent)) return false;

        PainEvent painEvent = (PainEvent) o;

        if (!id.equals(painEvent.id)) return false;

        return true;
    }
}
