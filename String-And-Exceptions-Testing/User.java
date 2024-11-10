public class User implements ValidatePhone{
    String username;
    String password;
    String phoneNum;

    public User(String username, String password, String phoneNum) throws WrongUserException, WrongPhoneNumberException{
        if(!validateUsername(username)){
            throw new WrongUserException("Invalid username.");
        }
        if(!validatePassword(password)){
            throw new IllegalArgumentException("The password must have at least 11 symbols");
        }
        if(!validatePhoneNumber(phoneNum)){
            throw new WrongPhoneNumberException("Invalid phone number");
        }
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws WrongUserException{
        if(!validateUsername(username)){
            throw  new WrongUserException("Invalid username!");
        }
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) throws WrongPhoneNumberException{
        if(!validatePhoneNumber(phoneNum)){
            throw new WrongPhoneNumberException("Invalid phone number!");
        }
        this.phoneNum = phoneNum;
    }



    private boolean validateUsername(String username){
        return username.matches("^[a-z0-9_-]{3,15}$");
    }

    private boolean validatePassword(String password){
        return password.length() >= 11 && password.matches("^[a-zA-Z]+$");
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException{
        if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")){
            throw new WrongPhoneNumberException("Invalid phone number!");
        }
        return true;
    }
}

