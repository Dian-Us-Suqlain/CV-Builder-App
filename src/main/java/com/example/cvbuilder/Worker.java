package com.example.cvbuilder;

public class Worker {
    private String username;
    private String workerAbout;
    private String phone;
    private String email;
    private String password;
    private String address;
    private String instituteName;
    private String degree;
    private String major1;
    private String major2;
    private String major3;
    private String project1;
    private String project2;
    private String project1Desc;
    private String project2Desc;
    private String areaOfInterest;
    private String getAreaOfInterestDesc;
    private String keySkill1;
    private String keySkill2;
    private String keySkill3;

    public Worker() {
    }

    Worker(String username, String workerAbout, String phone, String email, String address,
           String instituteName, String degree, String major1, String major2, String major3, String project1,
           String project2, String project1Desc, String project2Desc, String areaOfInterest, String getAreaOfInterestDesc,
           String keySkill1, String keySkill2, String keySkill3) {
        this.username = username;
        this.workerAbout = workerAbout;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.instituteName = instituteName;
        this.degree = degree;
        this.major1 = major1;
        this.major2 = major2;
        this.major3 = major3;
        this.project1 = project1;
        this.project2 = project2;
        this.project1Desc = project1Desc;
        this.project2Desc = project2Desc;
        this.areaOfInterest = areaOfInterest;
        this.getAreaOfInterestDesc = getAreaOfInterestDesc;
        this.keySkill1 = keySkill1;
        this.keySkill2 = keySkill2;
        this.keySkill3 = keySkill3;
    }

    String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String getWorkerAbout() {
        return workerAbout;
    }

    public void setWorkerAbout(String workerAbout) {
        this.workerAbout = workerAbout;
    }

    String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    String getMajor1() {
        return major1;
    }

    public void setMajor1(String major1) {
        this.major1 = major1;
    }

    String getMajor2() {
        return major2;
    }

    public void setMajor2(String major2) {
        this.major2 = major2;
    }

    String getMajor3() {
        return major3;
    }

    public void setMajor3(String major3) {
        this.major3 = major3;
    }

    String getProject1() {
        return project1;
    }

    public void setProject1(String project1) {
        this.project1 = project1;
    }

    String getProject2() {
        return project2;
    }

    public void setProject2(String project2) {
        this.project2 = project2;
    }

    String getProject1Desc() {
        return project1Desc;
    }

    public void setProject1Desc(String project1Desc) {
        this.project1Desc = project1Desc;
    }

    String getProject2Desc() {
        return project2Desc;
    }

    public void setProject2Desc(String project2Desc) {
        this.project2Desc = project2Desc;
    }

    String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    String getGetAreaOfInterestDesc() {
        return getAreaOfInterestDesc;
    }

    public void setGetAreaOfInterestDesc(String getAreaOfInterestDesc) {
        this.getAreaOfInterestDesc = getAreaOfInterestDesc;
    }

    String getKeySkill1() {
        return keySkill1;
    }

    public void setKeySkill1(String keySkill1) {
        this.keySkill1 = keySkill1;
    }

    String getKeySkill2() {
        return keySkill2;
    }

    public void setKeySkill2(String keySkill2) {
        this.keySkill2 = keySkill2;
    }

    String getKeySkill3() {
        return keySkill3;
    }

    public void setKeySkill3(String keySkill3) {
        this.keySkill3 = keySkill3;
    }
}
