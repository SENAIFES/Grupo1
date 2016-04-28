/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import br.senai.dao.TarefaDAO;
import br.senai.entity.Tarefa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alexsander_leal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TarefaDAO tarefaDAO = new TarefaDAO();
        
        List<Tarefa> lista = tarefaDAO.listarTodos();
        for (Tarefa t : lista) {
            System.out.println(t.getDescricao());
        }
     
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	String dateInString = "7-Jun-2013";

	try {

		Date date = formatter.parse(dateInString);
		System.out.println(date);
		System.out.println(formatter.format(date));

	} catch (ParseException e) {
		e.printStackTrace();
	}
    }
    
}
