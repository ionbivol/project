package ion.project1.doctor;


import ion.project1.consults.ConsultEntity;

import javax.persistence.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "doctors")
public class DoctorEntity {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    private String firstName;
    private String lastName;
    private String address;
    @Enumerated(EnumType.STRING)
    private DoctorSpecialityEnum speciality;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "doctor")
    private List<ConsultEntity> consults;

    public String getFirstName() {
        return firstName;
    }


    public Integer getDoctorId() {
        return doctorId;
    }

    public List<ConsultEntity> getConsults() {
        return consults;
    }

    public void setConsults(List<ConsultEntity> consults) {
        this.consults = consults;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DoctorSpecialityEnum getSpeciality() {
        return speciality;
    }

    public void setSpeciality(DoctorSpecialityEnum speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(this.checkEmailByRegex(email)){

            this.email = email;
        }else {
            System.out.println("Email is not valid");
        }
    }

    public boolean checkEmailByRegex(String emailAdress){
        final String regex = "([a-zA-Z0-9_.-]*)@([a-zA-Z_.-]*)((\\.([a-zA-Z]*){2,3})+)";
        final Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAdress);

        return matcher.matches();

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new  StringBuilder();

        stringBuilder.append("Doctor Id: ").append(doctorId).append(", ");
        stringBuilder.append("First Name: ").append(firstName).append(", ");
        stringBuilder.append("Last Name: ").append(lastName).append(", ");
        stringBuilder.append("Address: ").append(address).append(", ");
        stringBuilder.append("Speciality: ").append(speciality).append(", ");
        stringBuilder.append("Email: ").append(email).append(", ");
        stringBuilder.append("Phone Number: ").append(phone).append(" ");
        return stringBuilder.toString();
    }
}
