package HealthClinic;

import HealthClinic.dao.ConsultationDAO;
import HealthClinic.dao.DoctorDAO;
import HealthClinic.dao.PatientDAO;
import HealthClinic.dao.TreatmentDAO;
import HealthClinic.model.Patient;
import HealthClinic.model.Treatment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Demo {

    public static void main(String[] args) throws SQLException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        PatientDAO patientDAO = new PatientDAO();
        TreatmentDAO treatmentDAO = new TreatmentDAO();
        ConsultationDAO consultationDAO = new ConsultationDAO();

        System.out.println(doctorDAO.getAllDoctors());
        System.out.println(patientDAO.getAllPatients());
        System.out.println(treatmentDAO.getAllTreatments());
        System.out.println(consultationDAO.getAllConsultations());

        TreatmentFile treatmentFile = new TreatmentFile();
        for (Treatment t : treatmentDAO.getAllTreatments()) {
            treatmentFile.addTreatment(t);
        }
        treatmentFile.showMedicationByDoctor("Anna Grigoryan");

        Patient[] patients = toArray(patientDAO.getAllPatients());
        System.out.println(patients[findNextPatientIndex(patients)]);
    }

    private static int findNextPatientIndex(Patient[] patients) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] != null && patients[i].getPriority() > max) {
                max = patients[i].getPriority();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static Patient[] toArray(ArrayList<Patient> list) {
        Patient[] patients = new Patient[10];
        for (int i = 0; i < list.size() && i < patients.length; i++) {
            patients[i] = list.get(i);
        }
        return patients;
    }
}
