package dao;



import bean.ClienteMsl;
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
public class ClienteDAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();//limpa
        session.clear();//não grava erro
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();//limpa
        session.clear();//não grava erro
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClienteMsl.class);
        criteria.add(Restrictions.eq("idclienteMsl", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {

        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClienteMsl.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;

    }
      public List listNome(String nome){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClienteMsl.class);
        criteria.add(Restrictions.like("nomeMsl", "%" + nome + "%" ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listCpf(String cpf){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClienteMsl.class);
        criteria.add(Restrictions.like("cpfMsl", "%" + cpf + "%" ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listNomeECpf(String nome,String cpf){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClienteMsl.class);
        criteria.add(Restrictions.like("nomeMsl", "%" + nome + "%" ));
        criteria.add(Restrictions.like("cpfMsl", "%" + cpf + "%" ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        List lista = clienteDAO.listNome("O que procura");
        for (Object clienteMsl : lista){
        System.out.println("nome:" + ((ClienteMsl)clienteMsl).getNomeMsl());
        }
    }
    
    
}
    
