/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.ClienteMsl;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u07679183120
 */
    public class ClienteControle extends AbstractTableModel {
private List lista;

public void setList(List lista){
this.lista=lista;
this.fireTableDataChanged();
}

public ClienteMsl getbean(int linha){
return (ClienteMsl) lista.get(linha);
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
        ClienteMsl clienteMsl = (ClienteMsl) lista.get(rowIndex);
      if (columnIndex == 0) {
             return clienteMsl.getIdclienteMsl();
        }
             if (columnIndex == 1) {
             return clienteMsl.getNomeMsl();
        }
             if (columnIndex == 2) {
             return clienteMsl.getCpfMsl();
        }
        
             if (columnIndex == 3) {
             return clienteMsl.getRgMsl();
        
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
             return "Cpf";
        }
        if (columnIndex == 3) {
             return "Eg";
        }
       
    return null;
    }
}

    
    

