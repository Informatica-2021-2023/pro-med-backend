package gov.edu.ce.anm.promed.domain.client;

public enum BloodType {

    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");

    private final String type;

    BloodType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
