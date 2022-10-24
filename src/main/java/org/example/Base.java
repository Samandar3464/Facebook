package org.example;

import lombok.Data;

@Data
public abstract class Base {
     private static int idgen=0;
     protected int id;

     public Base() {
          this.id=idgen++;
     }

}
