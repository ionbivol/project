package ion.project1.doctor;

import junit.framework.TestCase;

import static org.junit.Assert.assertTrue;

public class DoctorEntityTest extends TestCase {

    public void testSetEmail() {
        DoctorEntity doctorEntity = new DoctorEntity();
        String emailTest = "vani12_.vol@gmail.com";
        boolean isValid = doctorEntity.checkEmailByRegex(emailTest);
        assertTrue(isValid);

    }
}