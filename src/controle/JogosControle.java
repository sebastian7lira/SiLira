/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.JogosMsl;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u07679183120
 */
     public class JogosControle extends AbstractTableModel {
private List lista;

public void setList(List lista){
this.lista=lista;
this.fireTableDataChanged();
}


public JogosMsl getbean(int linha){
return (JogosMsl) lista.get(linha);
}
@Override
public int getRowCount() {
        return lista.size();
    }
@Override
public int getColumnCount() {
      return 4;
    }
@Override
public Object getValueAt(int rowIndex, int columnIndex) {
        JogosMsl jogosMsl = (JogosMsl) lista.get(rowIndex);
      if (columnIndex == 0) {
             return jogosMsl.getIdjogosMsl();
        }
        if (columnIndex == 1) {
             return jogosMsl.getNomeMsl();
        }
        if (columnIndex == 2) {
             return jogosMsl.getPlataformaMsl();
        }
        if (columnIndex == 3) {
             return jogosMsl.getTipoDeJogoMsl();
        
        }
       return null;
    }
@Override
public String getColumnName(int columnIndex){
        if (columnIndex == 0) {
             return "ID";
        }
        if (columnIndex == 1) {
             return "Nome";
        }
        if (columnIndex == 2) {
             return "Plataforma";
        }
        if (columnIndex == 3) {
             return "Tipo de Jogo";
        }
       
    return null;
    }
}

