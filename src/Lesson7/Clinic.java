package Lesson7;

public class Clinic {
    public static void main(String[] args) {
        Patient patient = new Patient();
        patient.setTreatmentPlan(2);

        Therapist therapist = new Therapist();
        therapist.assignDoctorAndTreat(patient);
    }
}
