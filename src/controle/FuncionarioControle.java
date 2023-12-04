/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.FuncionarioMsl;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u07679183120
 */
public class FuncionarioControle extends AbstractTableModel{
    private List lista;

public void setList(List lista){
this.lista=lista;
this.fireTableDataChanged();
}


public FuncionarioMsl getbean(int linha){
return (FuncionarioMsl) lista.get(linha);
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
       FuncionarioMsl funcionarioMsl = (FuncionarioMsl) lista.get(rowIndex);
      if (columnIndex == 0) {
             return funcionarioMsl.getIdfuncionarioMsl();
        }
        if (columnIndex == 1) {
             return funcionarioMsl.getNomeMsl();
        }
        if (columnIndex == 2) {
             return funcionarioMsl.getEmailMsl();
        }
        if (columnIndex == 3) {
             return funcionarioMsl.getTelefoneMsl();
        
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
             return "Email";
        }
        if (columnIndex == 3) {
             return "Telefone";
        }
       
    return null;
    }
}
