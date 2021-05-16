package entities;

/**
 * User class represents user
 */

public class User {
    /**
     * Constant for female sex
     */
    public static final int FEMALE = 1;
    /**
     * Constant for male sex
     */
    public static final int MALE = 2;

    /**
     * User's id
     */
    private int person_id;
    /**
     * User's sex
     */
    private int sex;
    /**
     * User's login
     */
    private String login;
    /**
     * User's password
     */
    private Password password;
    /**
     * User's name
     */
    private String name;
    /**
     * User's surname
     */
    private String surname;
    /**
     * User's phone number
     */
    private String ph_number;
    /**
     * User's test id
     */
    private int test_id;

    /**
     * Constructor without parameters
     */
    public User(){
        this.password = new Password();
    }

    /**
     * Constructor with parameters
     * @param login
     * @param password
     */
    public User(String login, String password){
        this.login = login;
        this.password = new Password(password, login);;
    }

    /**
     * @return user's id
     */
    public int getPerson_id(){
        return this.person_id;
    }

    /**
     * Sets new user's id
     * @param person_id
     */
    public void setPerson_id(int person_id){
        this.person_id = person_id;
    }

    /**
     * @return user's sex
     */
    public int getSex(){
        return this.sex;
    }

    /**
     * Sets new sex
     * @param sex
     */
    public void setSex(int sex){
        this.sex = sex;
    }

    /**
     * @return user's login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets new login
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return password
     */
    public Password getPassword() {
        return password;
    }

    /**
     * Sets new password
     * @param PassHash
     */
    public void setPassword(String PassHash){
        this.password.setPassHash(PassHash);
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets new surname
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return phone number
     */
    public String getPh_number() {
        return ph_number;
    }

    /**
     * Sets new phone number
     * @param ph_number
     */
    public void setPh_number(String ph_number) {
        this.ph_number = ph_number;
    }

    /**
     * Sets new test id
     * @param test_id
     */
    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    /**
     * @return test id
     */
    public int getTest_id(){
        return test_id;
    }

    /**
     * @return String representation uf user as name, surname and phone number
     */
    public String getUserContact(){
        String UserContact = new String();
        if (name != null)
            UserContact += name;
        if (surname != null)
            UserContact += " " + surname;
        if (ph_number != null)
            UserContact += " " + ph_number;

        return UserContact;
    }
}
