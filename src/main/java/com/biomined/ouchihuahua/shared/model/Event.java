package com.biomined.ouchihuahua.shared.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by scole on 11/6/14.
 */
@Entity
public class Event {

    private enum Type {
        MIGRAINE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    private Type type = Type.MIGRAINE;
    private String tags;


}
