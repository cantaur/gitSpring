package sp2.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int seq;
    private String name;
    private String addr;
    private Date rdate;
}
