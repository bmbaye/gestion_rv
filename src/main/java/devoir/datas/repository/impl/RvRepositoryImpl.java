package devoir.datas.repository.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import devoir.core.repository.impl.RepositoryImpl;
import devoir.datas.entities.Medecin;
import devoir.datas.entities.Rv;
import devoir.datas.repository.MedecinRepository;
import devoir.datas.repository.RvRepository;

public class RvRepositoryImpl extends RepositoryImpl<Rv> implements RvRepository{
    private MedecinRepository medecinRepository;

    public RvRepositoryImpl(){
        this.medecinRepository = new MedecinRepositoryimpl();
        try {
            this.getConnexion();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Rv> selectAll() {
        List<Rv> rvs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rv";
            this.ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Rv  rv = new Rv();
            while (rs.next()) {
                rv.setId(rs.getInt("id_rv"));
                rv.setDate(rs.getDate("date"));
                rv.setHeure(rs.getString("heure"));

                int medecin_id = rs.getInt("medecin_id");
                rv.setMedecin(this.medecinRepository.getById(medecin_id));

                rvs.add(rv);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rvs;
    }

    @Override
    public boolean insert(Rv rv) {
        int last_id =0;
        try {
            String sql = "INSERT INTO rv (id_rv, date, heure, medecin_id) VALUES (?, ?, ?, ?)";
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setInt(1, rv.getId());
            this.ps.setDate(2, rv.getDate());
            this.ps.setString(3, rv.getHeure());
            this.ps.setInt(4, rv.getMedecin().getId_medecin());

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
    public List<Rv> getByDate(Date date) {
        Rv rv =null;
        List<Rv> rvs = new ArrayList<>();
        try {
            String sql ="SELECT * FORM rv where date like ?";
            
            this.ps.setString(1, date.toString());
            ResultSet rs =this.ps.executeQuery();

            if (rs.next()) {
                rv.setId(rs.getInt("id_rv"));
                rv.setDate(rs.getDate("date"));
                rv.setHeure(rs.getString("heure"));

                int medecin_id = rs.getInt("medecin_id");
                rv.setMedecin(this.medecinRepository.getById(medecin_id));

                rvs.add(rv);
            }
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
        return rvs;
    }
    
}
