
package insurance.pojo;

public class PatientPojo {

    public long getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(long currentAmount) {
        this.currentAmount = currentAmount;
    }

    public PatientPojo() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getCurrentStatus() {
        return CurrentStatus;
    }

    public void setCurrentStatus(String CurrentStatus) {
        this.CurrentStatus = CurrentStatus;
    }

    public long getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(long maxLimit) {
        this.maxLimit = maxLimit;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public long getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(long aadharNo) {
        this.aadharNo = aadharNo;
    }
    private String name;
    private String email;
    private int password;
    private int uniqueId;
    private int age;
    private String Gender;
    private String CurrentStatus;
    private long maxLimit;
    private String compName;
    private long aadharNo;
    private long currentAmount;
}

