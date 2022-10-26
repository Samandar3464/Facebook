package org.example.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Base;
@Data
@AllArgsConstructor
public class Commit extends Base {
    private String commit;
    private int postId;
    private String commitWriter;
    public Commit() {
    }
}
