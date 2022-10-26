package org.example;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public abstract class Base {
    private static int idgen = 0;
    protected int id;
    private Date date;

    public Base() {
        this.id = idgen++;
        this.date=new Date();
    }

}
