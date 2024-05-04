package banking;

 enum Grade {
    LOW(1, "low-level"),
    MID(2, "mid-level"),
    HIGH(3, "high-level");

    private int value;
    private String stringValue;

    private Grade(int value, String stringValue) {
        this.value = value;
        this.stringValue = stringValue;
    }

    public int getValue() {
        return value;
    }

    public String getStringValue() {
        return stringValue;
    }

    // Method to get Priority enum based on integer value
    public static Grade fromInt(int value) {
        for (Grade priority : Grade.values()) {
            if (priority.getValue() == value) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid integer value for Priority enum: " + value);
    }
}
