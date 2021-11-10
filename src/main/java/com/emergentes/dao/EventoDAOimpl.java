package com.emergentes.dao;

import com.emergentes.modelo.Evento;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventoDAOimpl extends ConexionDB implements EventoDAO {

    @Override
    public void insert(Evento evento) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO seminarios (titulo,expositor,fecha,hora,cupo) VALUES (?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, evento.getTitulo());
            ps.setString(2, evento.getExpositor());
            ps.setString(3, evento.getFecha());
            ps.setString(4, evento.getHora());
            ps.setInt(5, evento.getCupo());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Evento evento) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE seminarios SET titulo=?, expositor=?, fecha=?, hora=?, cupo=? WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, evento.getTitulo());
            ps.setString(2, evento.getExpositor());
            ps.setString(3, evento.getFecha());
            ps.setString(4, evento.getHora());
            ps.setInt(5, evento.getCupo());
            ps.setInt(6, evento.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM seminarios WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Evento getById(int id) throws Exception {
        Evento evn = new Evento();
        try {
            this.conectar();
            String sql = "SELECT * FROM seminarios WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                evn.setId(rs.getInt("id"));
                evn.setTitulo(rs.getString("titulo"));
                evn.setExpositor(rs.getString("expositor"));
                evn.setFecha(rs.getString("fecha"));
                evn.setHora(rs.getString("hora"));
                evn.setCupo(rs.getInt("cupo"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return evn;
    }

    @Override
    public List<Evento> getAll() throws Exception {
        List<Evento> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Evento>();
            while (rs.next()) {
                Evento evn = new Evento();
                evn.setId(rs.getInt("id"));
                evn.setTitulo(rs.getString("titulo"));
                evn.setExpositor(rs.getString("expositor"));
                evn.setFecha(rs.getString("fecha"));
                evn.setHora(rs.getString("hora"));
                evn.setCupo(rs.getInt("cupo"));
                lista.add(evn);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
