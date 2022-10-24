package org.example;

import lombok.Data;

@Data
public abstract class Base {
     private static int idgen=0;
     private int id;

     public Base() {
          this.id=idgen++;
     }

}
