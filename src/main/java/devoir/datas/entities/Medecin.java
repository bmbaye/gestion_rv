package devoir.datas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medecin {
    private int id_medecin;
    private String nom;
    private String prenom;
}
