package com.biomined.ouchihuahua.shared.model;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.Date;

/**
 * Created by stephencole on 4/11/14.
 */
public class PainEventSummary implements IsSerializable {

    private String painType;
    private Date onset;
    private Long id;

    public PainEventSummary(PainEvent painEvent) {

        id = painEvent.getId();
        painType = painEvent.getPainType();
        onset = painEvent.getOnset();
    }

    public PainEventSummary() {
    }

    public String getPainType() {
        return painType;
    }

    public Date getOnset() {
        return onset;
    }

    public Long getId() {
        return id;
    }

    public String getDisplayString() {

        StringBuilder sb = new StringBuilder();
        sb.append(painType);
        sb.append(" : ");
        sb.append(DateTimeFormat.getFormat("MMM d, yyyy HH:mm").format(onset).toString());
        sb.append(" ");
        return sb.toString();
    }

    public void setPainType(String painType) {
        this.painType = painType;
    }

    public void setOnset(Date onset) {
        this.onset = onset;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
