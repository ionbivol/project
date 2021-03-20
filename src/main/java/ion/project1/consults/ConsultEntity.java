package ion.project1.consults;


import ion.project1.doctor.DoctorEntity;
import ion.project1.patient.PatientEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "consults")
public class ConsultEntity {
    @Id
    @Column(name="consult_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consultId;

    private LocalDate date;
    private Double price;
    private String diagnostic;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    public ConsultEntity() {
    }

    public ConsultEntity(LocalDate date, PatientEntity patient, DoctorEntity doctor) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Integer getConsultId() {
        return consultId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consultId: ").append(consultId).append("\n ");
        stringBuilder.append("date: ").append(date).append("\n");
        stringBuilder.append(doctor).append("\n ");
        stringBuilder.append(patient).append(" \n");
        stringBuilder.append("diagnostic : ").append(diagnostic).append(" ");
        stringBuilder.append("price").append(price).append(" ");
        return stringBuilder.toString();
    }
}
