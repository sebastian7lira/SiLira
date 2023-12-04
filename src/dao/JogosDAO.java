package dao;



import bean.JogosMsl;
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
public class JogosDAO extends DAO_Abstract {

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
        Criteria criteria = session.createCriteria(JogosMsl.class);
        criteria.add(Restrictions.eq("idjogosMsl", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
    }

    @Override
    public List listAll() {

        session.beginTransaction();
        Criteria criteria = session.createCriteria(JogosMsl.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;

    }
     public List listNome(String nome){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JogosMsl.class);
        criteria.add(Restrictions.like("nomeMsl", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listPlataforma(String plataforma){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JogosMsl.class);
        criteria.add(Restrictions.like("plataformaMsl", "%" + plataforma + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listNomeEPlataforma(String nome, String plataforma){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JogosMsl.class);
        criteria.add(Restrictions.like("nomeMsl", "%" + nome + "%"));
        criteria.add(Restrictions.like("plataformaMsl", "%" + plataforma + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
public static void main(String[] args) {
        JogosDAO jogosDAO = new JogosDAO();
        List lista = jogosDAO.listNome("quem voce esta procurando");
        for (Object jogosMsl : lista){
        System.out.println("nome:"+ ((JogosMsl)jogosMsl).getNomeMsl());
        }
    }
}
    
 