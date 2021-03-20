package ion.project1.patient;

import java.util.List;

public interface PatientRepository {
    Integer createPatient(PatientEntity patient);  // pacientul nou creat
    void updatePatient(PatientEntity patient);

    List<PatientEntity> getAllPatients();

    void deletePatient(Integer id);

    PatientEntity getPatientById(Integer id) throws Exception;
}
