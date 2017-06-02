package com.syscall.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by harley on 02/06/2017.
 */
@Entity
public class Cliente {

    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
