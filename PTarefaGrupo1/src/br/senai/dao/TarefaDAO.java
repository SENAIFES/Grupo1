package br.senai.dao;

import br.senai.entity.Tarefa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TarefaDAO {

    private boolean insert(Tarefa tarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("INSERT INTO tarefa "
                            + "(descricao, prazo, concluido) "
                            + "VALUES ( ?, ?, ?)");
            ps.setString(1, tarefa.getDescricao());
            ps.setDate(2, new java.sql.Date(tarefa.getPrazo().getTime()));
            ps.setBoolean(3, tarefa.getConcluido());

            ps.execute();
            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean update(Tarefa tarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE tarefa "
                    + "SET descricao = ?, prazo = ?, concluido = ?"
                    + " WHERE idtarefa= ?");
            ps.setString(1, tarefa.getDescricao());
            ps.setDate(2, new java.sql.Date(tarefa.getPrazo().getTime()));
            ps.setBoolean(3, tarefa.getConcluido());

            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean salvar(Tarefa tarefa) {
        if (tarefa.getId() == 0) {
            return insert(tarefa);
        } else {
            return update(tarefa);
        }
    }

    public boolean delete(int id) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("DELETE FROM tarefa "
                            + "WHERE idtarefa = ?");
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

    public List<Tarefa> listarTodos() {
        List<Tarefa> lista = new ArrayList<Tarefa>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("SELECT * FROM tarefa");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("idtarefa"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setPrazo(rs.getDate("prazo"));
                tarefa.setConcluido(rs.getBoolean("concluido"));

                lista.add(tarefa);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Tarefa> buscarPorDescricao(String descricao) {
        List<Tarefa> lista = new ArrayList<Tarefa>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("SELECT * FROM tarefa WHERE descricao LIKE ?");
            ps.setString(1, descricao + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("idtarefa"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setPrazo(rs.getDate("prazo"));
                tarefa.setConcluido(rs.getBoolean("concluido"));

                lista.add(tarefa);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public Tarefa buscarPorId(int id) {
        Connection conn = ConnectionManager.getConnection();
        Tarefa tarefa = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT idtarefa, "
                    + "descricao, prazo, concluido "
                    + "FROM tarefa WHERE idtarefa = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                tarefa = new Tarefa();
                tarefa.setId(rs.getInt("idtarefa"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setPrazo(rs.getDate("prazo"));
                tarefa.setConcluido(rs.getBoolean("concluido"));

            }
            rs.close();
            ps.close();
            conn.close();
            return tarefa;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

   

}
