package ion.project1.patient;

import junit.framework.TestCase;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class PatientEntityTest extends TestCase {

    public void testCheckCnp() {
        PatientEntity patient = new PatientEntity();
        String testString = "1741011020035";
        boolean isValid = patient.checkCnp(testString);
        assertTrue(isValid);
    }

    public void testCalculateAge() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Cristi");
        patient.setLastName("Mugur");
        patient.setBirthday(LocalDate.of(1996, 01, 21));
        patient.setCnp("1930521524279");
        patient.setPhone("0784589665");
    }
}