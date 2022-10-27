package org.example.model;

import lombok.Data;
import org.example.DataBase;

import java.util.Date;

@Data
public abstract class Base {
    public int id;
    private boolean isActive;
    private Date date;
    public Base() {
        this.id = DataBase.idGeneration++;
        this.date = new Date();
        this.isActive = true;
    }
}
