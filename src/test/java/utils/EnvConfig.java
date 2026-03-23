package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {

    public static final Dotenv dotenv = Dotenv.load();

    private EnvConfig(){}
    // user1
    public static String getRegUsername1(){
        String value = dotenv.get("REG_USERNAME_1");
        if(value == null){
            throw new RuntimeException("REG_USERNAME_1 is not specified in .env file");
        }
        return value;
    }

    public static String getRegEmail1(){
        String value = dotenv.get("REG_EMAIL_1");
        if(value == null){
            throw  new RuntimeException("REG_EMAIL_1 is not specified in .env file");
        }
        return value;
    }

    public static String getRegPassword1(){
        String value = dotenv.get("REG_PASSWORD_1");
        if(value == null){
            throw new RuntimeException("REG_PASSWORD_1 is not specified in .env file");
        }
        return value;
    }
    //user2
    public static String getRegUsername2(){
        String value = dotenv.get("REG_USERNAME_2");
        if(value == null){
            throw new RuntimeException("REG_USERNAME_2 is not specified in .env file");
        }
        return value;
    }

    public static String getRegEmail2(){
        String value = dotenv.get("REG_EMAIL_2");
        if(value == null){
            throw  new RuntimeException("REG_EMAIL_2 is not specified in .env file");
        }
        return value;
    }

    public static String getRegPassword2(){
        String value = dotenv.get("REG_PASSWORD_2");
        if(value == null){
            throw new RuntimeException("REG_PASSWORD_2 is not specified in .env file");
        }
        return value;
    }
}
