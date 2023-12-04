/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.VendaMsl;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u07679183120
 */
    public class VendaControle extends AbstractTableModel {
private List lista;

public void setList(List lista){
this.lista=lista;
this.fireTableDataChanged();
}

public VendaMsl getbean(int linha){
return (VendaMsl) lista.get(linha);
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
        VendaMsl vendaMsl = (VendaMsl) lista.get(rowIndex);
        if (columnIndex == 0) {
             return vendaMsl.getIdvendaMsl();
        }
        if (columnIndex == 1) {
             return vendaMsl.getEnderecoMsl();
        }
        if (columnIndex == 2) {
             return vendaMsl.getDataHoraMsl();
        }
        if (columnIndex == 3) {
            return vendaMsl.getVendedorMsl();
        }
       return null;
    }
@Override
 public String getColumnName(int columnIndex){
        if (columnIndex == 0) {
             return "ID";
        }
        if (columnIndex == 1) {
             return "Endereco";
        }
        if (columnIndex == 2) {
             return "Data";
        }
        if (columnIndex == 3) {
             return "Vendedor";
        }
    return null;
    }
}

    
    

