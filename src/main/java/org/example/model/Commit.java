package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Commit extends Base {
    private String commit;
    private int postId;
}
