package banking;

 class Branch {
    private int code;
    private String city;
    private Grade grade;

    public Branch(int code, String city, Grade grade) {
        this.code = code;
        this.city = city;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "banking.Branch :" +
                "with branch code=" + code +
                ", in city='" + city + '\'' +
                ", with grade=" + grade.getStringValue();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
