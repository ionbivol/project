package ion.project1.doctor;

import ion.project1.session.SessionCreation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepositoryImplementation implements DoctorRepository {
    @Override
    public void createDoctor(DoctorEntity doctor) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(doctor);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateDoctor(DoctorEntity doctor) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(doctor);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteDoctor(Integer id) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            DoctorEntity doctor = session.find(DoctorEntity.class, id);
            Transaction transaction = session.beginTransaction();
            session.delete(doctor);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<DoctorEntity> getAllDoctors() {

        List<DoctorEntity> doctorList = new ArrayList<>();
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Query query = session.createQuery("from DoctorEntity", DoctorEntity.class);
            doctorList = query.list();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());

        }

        return doctorList;
    }

    @Override
    public DoctorEntity getDoctorById(Integer id) throws Exception {

        DoctorEntity doctor = null;

        Session session = SessionCreation.getSessionFactory().openSession();
        doctor = session.find(DoctorEntity.class,id);
        if(doctor == null) {
            throw new Exception("The doctor with id: " + id + " does not exist in the database");
        } else {
            session.close();
            return doctor;
        }
    }
}
