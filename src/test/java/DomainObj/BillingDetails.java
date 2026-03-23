package DomainObj;

public class BillingDetails {
    private String FirstName;
    private String LastName;
    //private String Country;
    private String StreetAddress;
    private String Town;
    private String State;
    private String PostCode;
    private String Email;

    public BillingDetails(String fName, String lName, String StreetAdd, String town, String state, String postCode, String email){
        this.FirstName = fName;
        this.LastName =lName;
        //this.Country = country;
        this.StreetAddress = StreetAdd;
        this.Town = town;
        this.State = state;
        this.PostCode = postCode;
        this.Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

//   // public String getCountry() {
//        return Country;
//    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public String getTown() {
        return Town;
    }

    public String getState() {
        return State;
    }

    public String getPostCode() {
        return PostCode;
    }

    public String getEmail() {
        return Email;
    }
}
