package library;

 class Author {
   private   String name;
    private String lastName;
    private int birthDate;

     public Author(String name, String lastName, int birthDate) {
         this.name = name;
         this.lastName = lastName;
         this.birthDate = birthDate;
     }

     @Override
     public String toString() {
         return "Author{" +
                 "name='" + name + '\'' +
                 ", lastName='" + lastName + '\'' +
                 ", birthDate=" + birthDate +
                 '}';
     }

     public String getName() {
         return name;
     }
     public String getFullName() {
         return name+lastName;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getLastName() {
         return lastName;
     }

     public void setLastName(String lastName) {
         this.lastName = lastName;
     }

     public int getBirthDate() {
         return birthDate;
     }

     public void setBirthDate(int birthDate) {
         this.birthDate = birthDate;
     }
 }
