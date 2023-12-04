/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.UsuariosMsl;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author u07679183120
 */
public class UsuarioControle extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public UsuariosMsl getbean(int linha) {
        return (UsuariosMsl) lista.get(linha);
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
        UsuariosMsl usuariosMsl = (UsuariosMsl) lista.get(rowIndex);
        if (columnIndex == 0) {
            return usuariosMsl.getIdusuariosMsl();
        }
        if (columnIndex == 1) {
            return usuariosMsl.getNomeMsl();
        }
        if (columnIndex == 2) {
            return usuariosMsl.getCpfMsl();
        }
        if (columnIndex == 3) {
            return usuariosMsl.getApelidoMsl();

        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
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
            return "Apelido";
        }

        return null;
    }
}
