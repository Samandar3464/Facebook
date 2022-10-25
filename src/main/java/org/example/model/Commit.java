package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Base;
@Data
@NoArgsConstructor
public class Commit extends Base {
    private String commit;
    private int commitId;
    private int postId;
}
