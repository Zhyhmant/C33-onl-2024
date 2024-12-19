package Lesson7;

class Surgeon extends Doctor {
    @Override
    public void treat(Patient patient) {
        System.out.println("The surgeon performs the operation on the patient.");
    }
}
