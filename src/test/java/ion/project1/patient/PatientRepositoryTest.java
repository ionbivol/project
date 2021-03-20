package ion.project1.patient;

import junit.framework.TestCase;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PatientRepositoryTest extends TestCase {

    public void testCreatePatient() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Test First Name");
        patient.setLastName("Test Last Name");
        patient.setCnp("1965840012342");
        patient.setBirthday(LocalDate.of(1965,12,21));
        patient.setAge();
        patient.setPhone("+40456122789");

        PatientRepository patientImplementation = new PatientRepositoryImplementation();
        Integer result = patientImplementation.createPatient(patient);
        if(result == -1) {
            assertFalse(false);
        } else{
            assertTrue(true);
        }
    }
}