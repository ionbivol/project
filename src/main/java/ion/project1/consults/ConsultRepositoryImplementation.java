package ion.project1.consults;

import ion.project1.session.SessionCreation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ConsultRepositoryImplementation implements ConsultRepository {

    @Override
    public void createConsult(ConsultEntity consult) {
            try{
                Session session = SessionCreation.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                session.save(consult);
                transaction.commit();
                session.close();

            }catch (HibernateException e){
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void updateConsult(Integer id, Double price, String diagnostic) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            ConsultEntity consult = session.find(ConsultEntity.class, id);
            if (consult != null) {
                consult.setPrice(price);
                consult.setDiagnostic(diagnostic);
                session.update(consult);
            } else {
                this.createConsult(consult);

            }
            transaction.commit();
            session.close();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<ConsultEntity> getAllConsults() {
        List<ConsultEntity> consultList = new ArrayList<>();
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            String stringQuery = "from ConsultEntity";
            Query query = session.createQuery(stringQuery, ConsultEntity.class);
            consultList = query.list();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return consultList;
    }

    @Override
    public ConsultEntity getConsultById(Integer Id) throws Exception {
        ConsultEntity consult = new ConsultEntity();

        Session session = SessionCreation.getSessionFactory().openSession();
        consult = session.find(ConsultEntity.class, Id);
        if(consult==null) {
            throw new  Exception ("The consult with ID" + Id + "does not exist in database");
        }
        session.close();

        return consult;
    }

    @Override
    public void deleteConsult(Integer id) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            ConsultEntity consult = session.find(ConsultEntity.class, id);
            Transaction transaction = session.beginTransaction();
            session.delete(consult);
            transaction.commit();
            session.close();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    }

