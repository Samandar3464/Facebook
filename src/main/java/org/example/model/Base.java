package org.example.model;

import lombok.Data;

@Data
public abstract class Base {
     private static int idGeneration=0;
     protected int id;

     public Base() {
          this.id=idGeneration++;
     }

}
