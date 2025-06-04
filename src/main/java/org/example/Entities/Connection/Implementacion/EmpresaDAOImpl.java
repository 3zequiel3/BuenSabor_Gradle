package org.example.Entities.Connection.Implementacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Connection.Conexion;
import org.example.Entities.Connection.DAOs.EmpresaDAO;
import org.example.Entities.Geography.Empresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class EmpresaDAOImpl implements EmpresaDAO {
    private final Connection con = Conexion.ConectarBD();

    @Override
    public List<Empresa> buscarPorNombre(String nombre) {
        return List.of();
    }

    @Override
    public void guardar(Empresa entidad) {
        String sql = "INSERT INTO empresas(nombre,razon_social,cuil) VALUES (?,?,?)";
        try (PreparedStatement ps = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getRazonSocial());
            ps.setLong(3, entidad.getCuil());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entidad.setId(rs.getInt(1)); // ✅ ya no es null
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Empresa buscarPorId(Empresa entidad) {
        String sql = "SELECT * FROM empresas WHERE id=?";
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            ps.setInt(1, entidad.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getInt("id"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setRazonSocial(rs.getString("razon_social"));
                empresa.setCuil(rs.getLong("cuil"));
                return empresa;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Empresa> buscarTodos() {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM empresas";
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getInt("id"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setRazonSocial(rs.getString("razon_social"));
                empresa.setCuil(rs.getInt("cuil"));
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empresas;
    }

    @Override
    public void actualizar(Empresa entidad) {
        String sql = "UPDATE empresas SET nombre=?, razon_social=?, cuil=? WHERE id=?";
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getRazonSocial());
            ps.setLong(3, entidad.getCuil());
            ps.setInt(4, entidad.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(Empresa entidad) {
        String sql = "DELETE FROM empresas WHERE id=?";
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
