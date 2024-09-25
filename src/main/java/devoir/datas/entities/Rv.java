package devoir.datas.entities;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rv {
    private int id;
    private Date date;
    private String heure;
    private Medecin medecin;
}
