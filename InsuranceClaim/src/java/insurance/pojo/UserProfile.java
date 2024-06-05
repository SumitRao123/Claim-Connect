/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.pojo;

public class UserProfile {
    private static String name;
    private  static String email;
    private  static int password;
    private static int uniqueId;
    private  static int age;
    private static String Gender;
    private static String CurrentStatus;
    private static long maxLimit;
    private static String compName;
    private static long aadharNo;
    private static long currentAmount;    

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserProfile.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserProfile.email = email;
    }

    public static int getPassword() {
        return password;
    }

    public static void setPassword(int password) {
        UserProfile.password = password;
    }

    public static int getUniqueId() {
        return uniqueId;
    }

    public static void setUniqueId(int uniqueId) {
        UserProfile.uniqueId = uniqueId;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        UserProfile.age = age;
    }

    public static String getGender() {
        return Gender;
    }

    public static void setGender(String Gender) {
        UserProfile.Gender = Gender;
    }

    public static String getCurrentStatus() {
        return CurrentStatus;
    }

    public static void setCurrentStatus(String CurrentStatus) {
        UserProfile.CurrentStatus = CurrentStatus;
    }

    public static long getMaxLimit() {
        return maxLimit;
    }

    public static void setMaxLimit(long maxLimit) {
        UserProfile.maxLimit = maxLimit;
    }

    public static String getCompName() {
        return compName;
    }

    public static void setCompName(String compName) {
        UserProfile.compName = compName;
    }

    public static long getAadharNo() {
        return aadharNo;
    }

    public static void setAadharNo(long aadharNo) {
        UserProfile.aadharNo = aadharNo;
    }

    public static long getCurrentAmount() {
        return currentAmount;
    }

    public static void setCurrentAmount(long currentAmount) {
        UserProfile.currentAmount = currentAmount;
    }
}
