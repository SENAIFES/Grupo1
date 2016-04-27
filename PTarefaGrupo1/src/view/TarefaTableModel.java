package view;

import br.senai.entity.Tarefa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TarefaTableModel extends AbstractTableModel {

    private List<Tarefa> lista;

    public List<Tarefa> getLista() {
        return lista;
    }

    public void setLista(List<Tarefa> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tarefa umaTarefa = lista.get(rowIndex);
        if (columnIndex == 0) {
            return umaTarefa.getDescricao();
        } else if (columnIndex == 1) {
            return umaTarefa.getPrazo();
        } else if (columnIndex == 2) {
            String c = "";
            if (umaTarefa.getConcluido()) {
                c = "Sim";
            } else {
                c = "Não";
            }
            return c;
        } else {
            return "";
        }
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0: {
                return "Descrição";
            }
            case 1: {
                return "Prazo";
            }
            case 2: {
                return "Concluído";
            }
            default: {
                return "";
            }
        }
    }
}
