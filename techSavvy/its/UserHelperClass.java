package techSavvy.its;

public class UserHelperClass {

    String _name,_username,_email,_password,_phoneNo;

    public UserHelperClass() {

    }

    public UserHelperClass(String _name, String _username, String _email, String _password,String _phoneNo) {
        this._name = _name;
        this._username = _username;
        this._email = _email;
        this._password = _password;
        this._phoneNo = _phoneNo;



    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_phoneNo() {
        return _phoneNo;
    }

    public void set_phoneNo(String _phoneNo) {
        this._phoneNo = _phoneNo;
    }


}
