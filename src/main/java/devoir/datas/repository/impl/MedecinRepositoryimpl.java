package devoir.datas.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import devoir.core.repository.impl.RepositoryImpl;
import devoir.datas.entities.Medecin;
import devoir.datas.entities.Rv;
import devoir.datas.repository.MedecinRepository;

public class MedecinRepositoryimpl extends RepositoryImpl<Medecin> implements MedecinRepository{

    @Override
    public List<Medecin> selectAll() {
       List<Medecin> medecins = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medecin";
            this.ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Medecin medecin = new Medecin();
            while (rs.next()) {
                medecin.setId_medecin(rs.getInt("id_medecin"));
                medecin.setNom(rs.getString("nom"));
                medecin.setPrenom(rs.getString("prenom"));

                medecins.add(medecin);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return medecins;
    }

    @Override
    public boolean insert(Medecin medecin) {
        int last_id =0;
        try {
            String sql = "INSERT INTO medecin (id_medcin, nom, prenom) VALUES (?, ?, ?)";
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setInt(1, medecin.getId_medecin());
            this.ps.setString(2, medecin.getNom());
            this.ps.setString(3, medecin.getPrenom());

            this.ps.executeUpdate();

            ResultSet rs = this.ps.getGeneratedKeys();
            while (rs.next()) {
                last_id =rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return last_id >0;
    }

    @Override
    public Medecin getById(int id) {
        Medecin med = new Medecin();
        try {
            String sql ="SELECT * FORM medecin where id_medecin = ?";
            
            this.ps.setInt(1, id);
            ResultSet rs =this.ps.executeQuery();

            if (rs.next()) {
                med.setId_medecin(rs.getInt("id_medecin"));
                med.setNom(rs.getString("nom"));
                med.setPrenom(rs.getString("prenom"));
            }
            return med;
        }
        catch (SQLException e) {
            System.out.println("Echec de la connection a la base de donnees");
            e.printStackTrace();
        }
        finally{
            try {
                this.closeConenxion();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
    
}
