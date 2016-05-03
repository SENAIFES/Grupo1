package br.senai.dao;

import br.senai.entity.Lista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaDAO {

    private boolean insert(Lista listaTarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("INSERT INTO lista "
                            + "(nome) "
                            + "VALUES (?)");
            ps.setString(1, listaTarefa.getNome());

            ps.execute();
            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean update(Lista listaTarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE lista "
                    + "SET nome = ? WHERE idlista= ?");
            ps.setString(1, listaTarefa.getNome());

            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean salvar(Lista listaTarefa) {
        if (listaTarefa.getId() == 0) {
            return insert(listaTarefa);
        } else {
            return update(listaTarefa);
        }
    }

    public boolean delete(int id) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("DELETE FROM lista "
                            + "WHERE idlista = ?");
            ps.setInt(1, id);

            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Lista> listarTodos() {
        List<Lista> lista = new ArrayList<Lista>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("SELECT * FROM lista");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Lista listaTarefa = new Lista();
                listaTarefa.setId(rs.getInt("idlista"));
                
                listaTarefa.setNome(rs.getString("nome"));

                lista.add(listaTarefa);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Lista> buscarPorDescricao(String nome) {
        List<Lista> lista = new ArrayList<Lista>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("SELECT * FROM lista WHERE nome LIKE ?");
            ps.setString(1, nome + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Lista listaTarefa = new Lista();
                listaTarefa.setId(rs.getInt("idlista"));
                listaTarefa.setNome(rs.getString("nome"));

                lista.add(listaTarefa);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public Lista buscarPorId(int id) {
        Connection conn = ConnectionManager.getConnection();
        Lista listaTarefa = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT idlista, "
                    + "nome "
                    + "FROM lista WHERE idlista = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                listaTarefa = new Lista();
                listaTarefa.setId(rs.getInt("idlista"));
                listaTarefa.setNome(rs.getString("nome"));
              

            }
            rs.close();
            ps.close();
            conn.close();
            return listaTarefa;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
