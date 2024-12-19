package Lesson7;

class Therapist extends Doctor {
    @Override
    public void treat(Patient patient) {
        System.out.println("The therapist examines the patient.");
    }

    public void assignDoctorAndTreat(Patient patient) {
        Doctor assignedDoctor;
        switch (patient.getTreatmentPlan()) {
            case 1:
                assignedDoctor = new Surgeon();
                patient.setDoctor(assignedDoctor);
                System.out.println("The patient has been assigned a surgeon.");
                break;
            case 2:
                assignedDoctor = new Dentist();
                patient.setDoctor(assignedDoctor);
                System.out.println("The patient has been assigned a dentist.");
                break;
            default:
                assignedDoctor = this;
                patient.setDoctor(assignedDoctor);
                System.out.println("The patient has been assigned a therapist.");
        }
        assignedDoctor.treat(patient);
    }
}