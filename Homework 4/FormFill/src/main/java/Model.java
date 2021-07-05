import java.util.Calendar;

/**
 * Notebook entry model class.
 * @author student
 */
public class Model {

    /** surname field*/
    private String surname;

    /** subscriber name field*/
    private String subscriberName;

    /** patronymic field*/
    private String patronymic;

    /** nickname field*/
    private String nickname;

    /** comment field*/
    private String comment;

    /** home phone field*/
    private String homePhone;

    /** mobile phone field*/
    private String mobilePhone;

    /** repeated mobile phone field*/
    private String mobilePhoneSecond;

    /** email field*/
    private String email;

    /** skype field*/
    private String skype;

    /** address field*/
    private Address address;

    /** note entry date field*/
    private Calendar noteEntryDate;

    /** note last update date field*/
    private Calendar noteLastUpdateDate;

    public Model() {}

    /**
     * Constructor - creating a new object with specific values
     * @param surname user's surname
     * @param subscriberName user's name
     * @param patronymic user's patronymic
     * @param nickname user's nickname
     * @param comment user's comment
     * @param homePhone user's home phone
     * @param mobilePhone user's mobile phone
     * @param mobilePhoneSecond user's repeated mobile phone
     * @param email user's email
     * @param skype user's skype
     * @param address user's address
     * @param noteEntryDate user's note entry date
     * @param noteLastUpdateDate user's note last update date
     */
    public Model(String surname, String subscriberName, String patronymic,
                 String nickname, String comment, String homePhone, String mobilePhone,
                 String mobilePhoneSecond, String email, String skype, Address address,
                 Calendar noteEntryDate, Calendar noteLastUpdateDate) {
        this.surname = surname;
        this.subscriberName = subscriberName;
        this.patronymic = patronymic;
        this.nickname = nickname;
        this.comment = comment;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.mobilePhoneSecond = mobilePhoneSecond;
        this.email = email;
        this.skype = skype;
        this.address = address;
        this.noteEntryDate = noteEntryDate;
        this.noteLastUpdateDate = noteLastUpdateDate;
    }

    /**
     * Method for getting surname and first letter of a name as a String
     * @return String
     */
    public String getShortName() {
        return surname + " " + subscriberName.charAt(0) + ".";
    }

    /**
     * Method for getting field value {@link Model#surname}
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Method for initializing the field {@link Model#surname}
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Method for getting field value {@link Model#subscriberName}
     * @return subscriberName
     */
    public String getSubscriberName() {
        return subscriberName;
    }

    /**
     * Method for initializing the field {@link Model#subscriberName}
     * @param subscriberName
     */
    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    /**
     * Method for getting field value {@link Model#patronymic}
     * @return patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Method for initializing the field {@link Model#patronymic}
     * @param patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Method for getting field value {@link Model#nickname}
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Method for initializing the field {@link Model#nickname}
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Method for getting field value {@link Model#comment}
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Method for initializing the field {@link Model#comment}
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Method for getting field value {@link Model#homePhone}
     * @return homePhone
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Method for initializing the field {@link Model#comment}
     * @param homePhone
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Method for getting field value {@link Model#mobilePhone}
     * @return mobilePhone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Method for initializing the field {@link Model#mobilePhone}
     * @param mobilePhone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Method for getting field value {@link Model#mobilePhoneSecond}
     * @return mobilePhoneSecond repeated mobile phone
     */
    public String getMobilePhoneSecond() {
        return mobilePhoneSecond;
    }

    /**
     * Method for initializing the field {@link Model#mobilePhoneSecond}
     * @param mobilePhoneSecond
     */
    public void setMobilePhoneSecond(String mobilePhoneSecond) {
        this.mobilePhoneSecond = mobilePhoneSecond;
    }

    /**
     * Method for getting field value {@link Model#email}
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method for initializing the field {@link Model#email}
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method for getting field value {@link Model#skype}
     * @return skype
     */
    public String getSkype() {
        return skype;
    }

    /**
     * Method for initializing the field {@link Model#skype}
     * @param skype
     */
    public void setSkype(String skype) {
        this.skype = skype;
    }

    /**
     * Method for getting field value {@link Model#address}
     * @return Address class object
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Method for initializing the field {@link Model#address}
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }


    /**
     * Method for getting field value {@link Model#noteEntryDate}
     * @return note entry date as Calendar class object
     */
    public Calendar getNoteEntryDate() {
        return noteEntryDate;
    }

    /**
     * Method for initializing the field {@link Model#noteEntryDate}
     * @param noteEntryDate Calendar class object
     */
    public void setNoteEntryDate(Calendar noteEntryDate) {
        this.noteEntryDate = noteEntryDate;
    }

    /**
     * Method for getting field value {@link Model#noteLastUpdateDate}
     * @return last update date of a note as Calendar class object
     */
    public Calendar getNoteLastUpdateDate() {
        return noteLastUpdateDate;
    }

    /**
     * Method for initializing the field {@link Model#noteLastUpdateDate}
     * @param noteLastUpdateDate Calendar class object
     */
    public void setNoteLastUpdateDate(Calendar noteLastUpdateDate) {
        this.noteLastUpdateDate = noteLastUpdateDate;
    }
}
