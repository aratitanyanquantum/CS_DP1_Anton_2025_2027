package HealthClinic;

import HealthClinic.model.Treatment;

public class TreatmentFile {
    private Treatment[] treatments = new Treatment[10];
    private int index = 0;
    private int index2 = 0;

    public void addTreatment(Treatment treatment) {
        if (index == treatments.length) {
            System.out.println("The treatment file is full.");
        } else {
            treatments[index++] = treatment;
        }
    }

    public Treatment getNext() {
        return treatments[index2++];
    }

    public boolean hasNext() {
        return index2 < index;
    }

    public void reset() {
        index2 = 0;
    }

    public void showMedicationByDoctor(String doctor) {
        reset();
        while (hasNext()) {
            Treatment t = getNext();
            if (t.getDoctor().getName().equals(doctor)) {
                System.out.println(t.getMedication());
            }
        }
    }
}
