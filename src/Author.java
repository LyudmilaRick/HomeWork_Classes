public class Author {
    private  final String firstName;
    private  final String lastName;

   public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName  = lastName;
    }
    public String getAuthorName() {
        return  getFirstName() +" "+ getLastName();
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
