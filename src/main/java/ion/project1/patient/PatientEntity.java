package ion.project1.patient;


import ion.project1.consults.ConsultEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "patients")
public class PatientEntity {
    @Id                                                   //primary key
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //autoincrement column id
    private Integer patientId;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    private String cnp;
    private Integer age;
    private LocalDate birthday;
    private String phone;


    @OneToMany(mappedBy = "patient")                         //one patient can have more consults
    private List<ConsultEntity> consults;


    public PatientEntity(String lastName, String firstName, String cnp, LocalDate birthday, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.cnp = cnp;
        this.birthday = birthday;
        this.age = calculateAge();
        this.phone = phone;
    }

    public PatientEntity() {

    }

    public PatientEntity(String ion, String bivol, String s) {
    }

    public List<ConsultEntity> getConsults() {
        return consults;
    }

    public void setConsults(List<ConsultEntity> consults) {
        this.consults = consults;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {

        if(this.checkCnp(cnp)) {
            this.cnp = cnp;
        }
        else {
            System.out.println("data is incorrect");
        }
    }
    public boolean checkCnp(String string) {
        final String regex ="[0-9]*";
        final Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(string);
        return matcher.matches() && string.length() == 13;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge() {
        this.age = calculateAge();
    }

    //calculate age using birthday
    public Integer calculateAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(this.birthday, now);

        return age = period.getYears();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Integer setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return null;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Patient Id: ").append(patientId).append(" ");
        stringBuilder.append("First Name: ").append(firstName).append(" ");
        stringBuilder.append("Last Name: ").append(lastName).append(" ");
        stringBuilder.append("CNP: ").append(cnp).append(" ");
        stringBuilder.append("Age :").append(age).append(" ");
        stringBuilder.append("Birth Date: ").append(birthday).append(" ");
        stringBuilder.append("Phone Number: ").append(phone).append(" ");
        return stringBuilder.toString();
    }
}
