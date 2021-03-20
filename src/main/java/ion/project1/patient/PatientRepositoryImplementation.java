package ion.project1.patient;

import ion.project1.session.SessionCreation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PatientRepositoryImplementation implements PatientRepository{
    @Override
    public Integer createPatient(PatientEntity patient) {  //conectare la baza de date si salvarea

        try{

            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(patient);
            Integer patientId = (Integer) session.save(patient);
            transaction.commit();
            session.close();
            return patientId;

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public void updatePatient(PatientEntity patient ) {

        try {

            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
            session.close();

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<PatientEntity> getAllPatients() {

        List<PatientEntity> patientList = new ArrayList<>();

        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Query<PatientEntity> query = session .createQuery("from PatientEntity",PatientEntity.class);
            patientList = query.list();
            session.close();



        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return patientList;
    }


    @Override
    public void deletePatient(Integer id) {

        try{

            Session session = SessionCreation.getSessionFactory().openSession();
            PatientEntity patientEntity = session.find(PatientEntity.class,id);
            Transaction transaction = session.beginTransaction();
            session.delete(patientEntity);
            transaction.commit();
            session.close();

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public PatientEntity getPatientById(Integer id) throws Exception {

        PatientEntity patient = null;

        Session session = SessionCreation.getSessionFactory().openSession();
        patient = session.find(PatientEntity.class,id);
        if(patient == null){
            System.out.println("This patient " + id + "does not exist" );
        }
        session.close();

        return patient;
    }
}
