package mx.edu.utez.examenu2.model;

import mx.edu.utez.examenu2.utils.MySQL;
import mx.edu.utez.examenu2.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPersonal implements Repositorio<BeanPerson> {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQL = new MySQL();

    Response<Object> response = new Response<>();
    @Override
    public List<BeanPerson> findAll() {
        List<BeanPerson> personal = new ArrayList<>();
        BeanPerson person = null;
        try{
            conn = mysql.getConnection();
            String query = "SELECT * FROM peleador";
            ps=conn.prepareStatement(query);
            while(rs.next()){
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthday(rs.getDate("birthday"));
                person.setUtiliza_magia(rs.getInt("utiliza_magia"));
                person.setEstatura(rs.getDouble("estatura"));
                person.setPeso(rs.getDouble("peso"));
                person.setEquipo(rs.getInt("equipo"));
                person.setMagia_id(rs.getInt("magia_id"));
                person.setTipo_lucha_id(rs.getInt("tipo_lucha_id"));
                personal.add(person);

            }
        }catch (SQLException e){
            Logger.getLogger(DaoPersonal.class.getName())
                    .log(Level.SEVERE,"Error = findAll" + e.getMessage());
        }finally {
            mysql.close(conn,ps,rs);
        }
        return personal;
    }

    @Override
    public Response<BeanPerson> findById(long id) {
        Response<BeanPerson> response = new Response<>();
        BeanPerson person = null;
        try {
            conn = mysql.getConnection();
            String query = "SELECT * FROM peleador WHERE id=?" + "VALUES(?)";
            ps = conn.prepareStatement(query);
            ps.setLong(1,  id);
            if (rs.next()) {
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthday(rs.getDate("birthday"));
                person.setUtiliza_magia(rs.getInt("utiliza_magia"));
                person.setEstatura(rs.getDouble("estatura"));
                person.setPeso(rs.getDouble("peso"));
                person.setEquipo(rs.getInt("equipo"));
                person.setMagia_id(rs.getInt("magia_id"));
                person.setTipo_lucha_id(rs.getInt("tipo_lucha_id"));

                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(person);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(person);
            }
        }catch (SQLException e){
            Logger.getLogger((DaoPersonal.class.getName()))
                    .log(Level.SEVERE, "Error -> finAll" + e.getMessage());
            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> " + e.getMessage());
            response.setData(null);
        } finally {
            mysql.close(conn, ps, rs);
        }
        return response;

    }

    @Override
    public Response<BeanPerson> save(BeanPerson object) {
        Response<BeanPerson> response = new Response<>();
        try {
            conn = new MySQL().getConnection();
            String query = "INSERT INTO personal (name, lastname, birthday, utiliza_magia, estatura,peso,equipo,magia_id,tipo_lucha_id)" +
                    "VALUES (?, ?, ?, ?, ?, ?,?,?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, object.getName());
            ps.setString(2, object.getLastname());
            ps.setDate(3, object.getBirthday());
            ps.setInt(4, object.getUtiliza_magia());
            ps.setDouble(5, object.getEstatura());
            ps.setDouble(6, object.getPeso());
            ps.setDouble(7, object.getEquipo());
            ps.setLong(8, object.getMagia_id());
            ps.setLong(8, object.getTipo_lucha_id());

            if (ps.executeUpdate()==1) { //1==1
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(object);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            }

        } catch (SQLException e) {
            Logger.getLogger((DaoPersonal.class.getName()))
                    .log(Level.SEVERE, "Error -> finAll" + e.getMessage());
            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> " + e.getMessage());
            response.setData(null);
        }finally {
            mysql.close(conn, ps, rs);
        }
        return response;
    }

    @Override
    public Response<BeanPerson> update(BeanPerson Object) {
        return null;
    }

    @Override
    public Response<BeanPerson> delete(long id) {
        Response<BeanPerson> response = new Response<>();
        try {
            conn = mysql.getConnection();
            String query = "DELETE FROM personaje where id=?" + "VALUES(?)";
            ps = conn.prepareStatement(query);
            ps.setLong(1,  id);

        }catch (SQLException e){
            Logger.getLogger((DaoPersonal.class.getName()))
                    .log(Level.SEVERE, "Error -> finAll" + e.getMessage());
            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> " + e.getMessage());
            response.setData(null);
        } finally {
            mysql.close(conn, ps, rs);
        }
        return response;

    }
}
