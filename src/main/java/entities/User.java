package entities;

public class User {
    public static final int FEMALE = 1;
    public static final int MALE = 2;

    private int person_id;
    private int sex;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String ph_number;
    private int test_id;

    public int getPerson_id(){
        return this.person_id;
    }

    public void setPerson_id(int person_id){
        this.person_id = person_id;
    }

    public int getSex(){
        return this.sex;
    }

    public void setSex(int sex){
        this.sex = sex;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPh_number() {
        return ph_number;
    }

    public void setPh_number(String ph_number) {
        this.ph_number = ph_number;
    }

    public void setTest_id(int ph_number) {
        this.test_id = test_id;
    }

    public int getTest_id(){
        return test_id;
    }

    public String getUserContact(){ return name + " " + surname + " " + ph_number; }
}