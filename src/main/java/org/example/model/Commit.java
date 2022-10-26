package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Base;

import java.security.Signature;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Data
public class Commit extends Base {
    private String commit;
    private int postId;

    public Commit() {
    }
}
