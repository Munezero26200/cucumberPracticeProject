package customParameter;

import DomainObj.*;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

    @ParameterType(".*")
    public Product product(String name){
        return new Product(name);
    }

    @ParameterType(".*")
    public Username username(String name){
        return new Username(name);
    }
    @ParameterType(".*")
    public Password password(String password){
        return new Password(password);
    }
    @ParameterType(".*")
    public DisplayedLoginUsername expectedUsername(String username){
        return new DisplayedLoginUsername(username);
    }
    @ParameterType(".*")
    public Email email(String emailAddress){
        return new Email(emailAddress);
    }

}

