package ion.project1;

import ion.project1.consults.ConsultEntity;
import ion.project1.consults.ConsultRepository;
import ion.project1.consults.ConsultRepositoryImplementation;
import ion.project1.doctor.DoctorEntity;
import ion.project1.doctor.DoctorRepository;
import ion.project1.doctor.DoctorRepositoryImplementation;
import ion.project1.doctor.DoctorSpecialityEnum;
import ion.project1.patient.PatientEntity;
import ion.project1.patient.PatientRepository;
import ion.project1.patient.PatientRepositoryImplementation;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    DoctorRepository doctorImplementation;
    PatientRepository patientImplementation;
    ConsultRepository consultImplementation;


    void startMenu() {
        doctorImplementation = new DoctorRepositoryImplementation();
        patientImplementation = new PatientRepositoryImplementation();
        consultImplementation = new ConsultRepositoryImplementation();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("");
            String start = " Start Application ";
            System.out.printf("%25s", start.toUpperCase(Locale.ROOT));
            System.out.println("");
            System.out.println("To enter in doctor menu press  '1'");
            System.out.println("To enter in patient menu press '2'");
            System.out.println("To enter in consult menu press '3'");

            int optional = scanner.nextInt();

            switch (optional) {

                case 1: {
                    System.out.println("To create a doctor press  '1'");
                    System.out.println("To update a doctor press  '2'");
                    System.out.println("To see all doctors press  '3'");
                    System.out.println("To see one doctor press   '4'");
                    System.out.println("To delete a doctor press  '5'");
                    int optional2 = scanner.nextInt();


                    switch (optional2) {
                        case 1: {
                            System.out.println("Start to Create Doctor");
                            DoctorEntity doctor = new DoctorEntity();
                            System.out.println("Insert First Name:");
                            scanner.nextLine();
                            doctor.setFirstName(scanner.nextLine());
                            System.out.println("Insert Last Name:");
                            doctor.setLastName(scanner.nextLine());
                            System.out.println("Insert address:");
                            doctor.setAddress(scanner.nextLine());
                            System.out.println("Insert doctor speciality:");
                            doctor.setSpeciality(DoctorSpecialityEnum.valueOf(scanner.nextLine()));
                            System.out.println("Insert email:");
                            doctor.setEmail(scanner.nextLine());
                            System.out.println("Insert phone number:");
                            doctor.setPhone(scanner.nextLine());
                            doctorImplementation.createDoctor(doctor);

                            break;
                        }
                        case 2: {
                            try {
                                System.out.println("This is the list of doctors whe have: ");
                                doctorImplementation.getAllDoctors().stream().forEach(System.out::println);
                                System.out.println("Input the ID of the doctor you want to update:");
                                Integer id = scanner.nextInt();
                                DoctorEntity doctor = doctorImplementation.getDoctorById(id);
                                System.out.println("Insert First Name:");
                                scanner.nextLine();
                                doctor.setFirstName(scanner.nextLine());
                                System.out.println("Insert Last Name:");
                                doctor.setLastName(scanner.nextLine());
                                System.out.println("Insert address:");
                                doctor.setAddress(scanner.nextLine());
                                System.out.println("Insert doctor speciality:");
                                doctor.setSpeciality(DoctorSpecialityEnum.valueOf(scanner.nextLine()));
                                System.out.println("Insert email:");
                                doctor.setEmail(scanner.nextLine());
                                System.out.println("Insert phone number:");
                                doctor.setPhone(scanner.nextLine());
                                doctorImplementation.updateDoctor(doctor);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        }
                        case 3: {
                            doctorImplementation.getAllDoctors().stream().forEach(System.out::println);
                            break;
                        }

                        case 4: {
                            try {
                                System.out.println("Input the ID of the doctor you want to see: ");
                                Integer id = scanner.nextInt();
                                DoctorEntity doctor = doctorImplementation.getDoctorById(id);
                                System.out.println(doctor.toString());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        }

                        case 5: {
                            try {
                                System.out.println("This is the list of doctors we have: ");
                                doctorImplementation.getAllDoctors().stream().forEach(System.out::println);
                                System.out.println("Input the ID of the doctor you want to delete: ");
                                Integer id = scanner.nextInt();
                                DoctorEntity doctor = doctorImplementation.getDoctorById(id);
                                System.out.println("Are you sure you want to delete?  'yes' 'no'");
                                scanner.nextLine();
                                String answer = scanner.nextLine();
                                if (answer.equals("yes")) {
                                    doctorImplementation.deleteDoctor(id);
                                    System.out.println("Doctor " + doctor.getLastName() + " was successful deleted");
                                }

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    }
                    break;
                }

                case 2: {
                    System.out.println("To create a patient press  '1'");
                    System.out.println("To update a patient press  '2'");
                    System.out.println("To see all patient press   '3'");
                    System.out.println("To see one patient press   '4'");
                    System.out.println("To delete a patient press  '5'");

                    int optional3 = scanner.nextInt();
                    switch (optional3) {

                        case 1: {
                            System.out.println("Start to create a patient!");
                            PatientEntity patient = new PatientEntity();
                            System.out.println("Insert First name:");
                            scanner.nextLine();
                            patient.setFirstName(scanner.nextLine());
                            System.out.println("Insert Last Name:");
                            patient.setLastName(scanner.nextLine());
                            System.out.println("Insert cnp:");
                            patient.setCnp(scanner.nextLine());
                            System.out.println("Insert birthday year:");
                            Integer year = scanner.nextInt();
                            System.out.println("Insert birthday month:");
                            Integer month = scanner.nextInt();
                            System.out.println("Insert day of month:");
                            Integer day = scanner.nextInt();
                            patient.setBirthday(LocalDate.of(year, month, day));
                            patient.calculateAge();
                            System.out.println("Insert phone number:");
                            scanner.nextLine();
                            patient.setPhone(scanner.nextLine());
                            patientImplementation.createPatient(patient);

                            break;

                        }

                        case 2: {
                            try {
                                System.out.println("This is the list of patients");
                                patientImplementation.getAllPatients().stream().forEach(System.out::println);
                                System.out.println("Input the ID of patient you wont to update:");
                                Integer id = scanner.nextInt();
                                PatientEntity patient = patientImplementation.getPatientById(id);
                                System.out.println("Insert First Name:");
                                scanner.nextLine();
                                patient.setFirstName(scanner.nextLine());
                                System.out.println("Insert Last Name: ");
                                patient.setLastName(scanner.nextLine());
                                System.out.println("Insert cnp: ");
                                patient.setCnp(scanner.nextLine());
                                System.out.println("Insert birthday year:");
                                Integer year = scanner.nextInt();
                                System.out.println("Insert birthday month:");
                                Integer month = scanner.nextInt();
                                System.out.println("Insert day of month:");
                                Integer day = scanner.nextInt();
                                patient.setBirthday(LocalDate.of(year, month, day));
                                patient.calculateAge();
                                System.out.println("Insert phone number");
                                scanner.nextLine();
                                patient.setPhone(scanner.nextLine());
                                patientImplementation.updatePatient(patient);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        }

                        case 3: {
                            patientImplementation.getAllPatients().stream().forEach(System.out::println);
                            break;
                        }
                        case 4: {
                            try {
                                System.out.println("Input the ID of the patient you want to see:");
                                Integer id = scanner.nextInt();
                                PatientEntity patient = patientImplementation.getPatientById(id);
                                System.out.println(patient.toString());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case 5: {
                            try {
                                System.out.println("This is the list of patients we have: ");
                                patientImplementation.getAllPatients().stream().forEach(System.out::println);
                                System.out.println("Input the ID of the doctor you want to delete: ");
                                Integer id = scanner.nextInt();
                                PatientEntity patient = patientImplementation.getPatientById(id);
                                System.out.println("Are you sure you want to delete?  'yes' 'no'");
                                scanner.nextLine();
                                String answer = scanner.nextLine();
                                if (answer.equals("yes")) {
                                    patientImplementation.getPatientById(id);
                                    System.out.println("Doctor " + patient.getLastName() + " was successful deleted");
                                    patientImplementation.deletePatient(id);

                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        }
                    }
                    break;

                }
                case 3: {
                    System.out.println("To create a consult press  '1'");
                    System.out.println("To update a consult press  '2'");
                    System.out.println("To see all consult press   '3'");
                    System.out.println("To see one consult press   '4'");
                    System.out.println("To delete a consult press  '5'");

                    int optional4 = scanner.nextInt();
                    switch (optional4) {

                        case 1: {
                            System.out.println("Start to create a consult");
                            ConsultEntity consult = new ConsultEntity();
                            System.out.println("Input date of the consult");
                            System.out.println("year:");
                            int year = scanner.nextInt();
                            System.out.println("month:");
                            int month = scanner.nextInt();
                            System.out.println("day:");
                            int day = scanner.nextInt();
                            consult.setDate(LocalDate.of(year, month, day));
                            System.out.println("Insert the patient id:");
                            try {
                                patientImplementation.getAllPatients();
                                PatientEntity patient = patientImplementation.getPatientById(scanner.nextInt());
                                consult.setPatient(patient);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("Insert doctor id:");
                            try {
                                DoctorEntity doctor = doctorImplementation.getDoctorById(scanner.nextInt());
                                doctorImplementation.getAllDoctors();
                                consult.setDoctor(doctor);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            consultImplementation.createConsult(consult);
                            break;
                        }

                        case 2: {
                            System.out.println("This the list of consults:");
                            consultImplementation.getAllConsults().stream().forEach(System.out::println);
                            System.out.println("Input the ID of the consult you want to update:");
                            Integer id = scanner.nextInt();
                            try {
                                System.out.println("Input the price of the consult:");
                                Double price = scanner.nextDouble();
                                System.out.println("Input diagnostic");
                                scanner.nextLine();
                                String diagnostic = scanner.nextLine();
                                consultImplementation.updateConsult(id, price, diagnostic);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        }

                        case 3: {
                            consultImplementation.getAllConsults().stream().forEach(System.out::println);
                            break;
                        }

                        case 4: {
                            System.out.println("This the list of consults:");
                            consultImplementation.getAllConsults().stream().forEach(System.out::println);
                            System.out.println("Input the ID of the consult you want to print:");
                            Integer id = scanner.nextInt();
                            try {
                                ConsultEntity consult = consultImplementation.getConsultById(id);
                                System.out.println(consult.toString());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }

                        case 5: {
                            System.out.println("This the list of consults:");
                            consultImplementation.getAllConsults().stream().forEach(System.out::println);
                            System.out.println("Input the ID of the consult you want to delete:");
                            Integer id = scanner.nextInt();
                            try {
                                ConsultEntity consult = consultImplementation.getConsultById(id);
                                System.out.println(consult.toString());
                                System.out.println("Are you sure you want to delete this consult? Input yes or no");
                                scanner.nextLine();
                                String answer = scanner.nextLine();
                                if (answer.equals("yes")) {
                                    consultImplementation.deleteConsult(id);
                                    System.out.println("Consult with id: " + id + " was successful deleted");
                                }

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    }
                    break;
                }
            }

        }
    }
}
