package ion.project1.doctor;

import java.util.List;

public interface DoctorRepository {

    void createDoctor(DoctorEntity doctor);
    void updateDoctor(DoctorEntity doctor);
    void  deleteDoctor(Integer id);

    List<DoctorEntity> getAllDoctors();
    DoctorEntity getDoctorById( Integer id) throws Exception;
}
