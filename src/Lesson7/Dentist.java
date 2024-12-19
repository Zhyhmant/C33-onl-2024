package Lesson7;

class Dentist extends Doctor {
    @Override
    public void treat(Patient patient) {
        System.out.println("The dentist treats the patient's teeth.");
    }
}
