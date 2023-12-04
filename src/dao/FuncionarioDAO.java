package dao;




import bean.FuncionarioMsl;
import bean.UsuariosMsl;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u07679183120
 */
public class FuncionarioDAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FuncionarioMsl.class);
        criteria.add(Restrictions.eq("idfuncionarioMsl", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
    }

    @Override
    public List listAll() {

        session.beginTransaction();
        Criteria criteria = session.createCriteria(FuncionarioMsl.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;

    }
      public List listNome(String nome){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FuncionarioMsl.class);
        criteria.add(Restrictions.like("nomeMsl", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listEmail(String email){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FuncionarioMsl.class);
        criteria.add(Restrictions.like("emailMsl", "%" + email + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listNomeEEmail(String nome, String email){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FuncionarioMsl.class);
        criteria.add(Restrictions.like("nomeMsl", "%" + nome + "%"));
        criteria.add(Restrictions.like("emailMsl", "%" + email + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List lista = funcionarioDAO.listNome("quem voce esta procurando");
        for (Object funcionarioMsl : lista){
        System.out.println("nome:"+ ((FuncionarioMsl)funcionarioMsl).getNomeMsl());
        }
    }

    public List listNomeSalario(String text, double salario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
