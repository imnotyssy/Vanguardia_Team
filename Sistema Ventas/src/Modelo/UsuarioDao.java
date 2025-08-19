package Modelo;

import Conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao {

    /** Devuelve el Usuario si usuario+password son correctos, si no, null */
    public usuario validar(String nombre, String passwordPlano) {
        String sql = "SELECT id, nombre, rol, estado " +
                     "FROM usuarios " +
                     "WHERE nombre = ? AND password_hash = SHA2(?, 256) AND estado = 1";

        try (Connection con = CConexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, passwordPlano);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("rol"),
                        rs.getInt("estado") == 1
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // puedes reemplazarlo por un logger
        }
        return null;
    }

    /** Crea un usuario nuevo con hash SHA2(256) calculado por MySQL */
    public boolean crear(String nombre, String passwordPlano, String rol) {
        String sql = "INSERT INTO usuarios(nombre, password_hash, rol) VALUES (?, SHA2(?,256), ?)";
        try (Connection con = CConexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, passwordPlano);
            ps.setString(3, rol == null ? "USER" : rol);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

//modificaciones



