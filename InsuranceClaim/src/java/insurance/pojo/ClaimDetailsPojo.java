/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.pojo;

public class ClaimDetailsPojo {

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInsCompany() {
        return insCompany;
    }

    public void setInsCompany(String insCompany) {
        this.insCompany = insCompany;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public ClaimDetailsPojo() {
    }

    public String getClaimHeading() {
        return claimHeading;
    }

    public void setClaimHeading(String claimHeading) {
        this.claimHeading = claimHeading;
    }

    public String getTreatmentDesc() {
        return treatmentDesc;
    }

    public void setTreatmentDesc(String treatmentDesc) {
        this.treatmentDesc = treatmentDesc;
    }

    public long getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(long claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getImgLoaction() {
        return imgLoaction;
    }

    public void setImgLoaction(String imgLoaction) {
        this.imgLoaction = imgLoaction;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getImgName() {
        return ImgName;
    }

    public void setImgName(String ImgName) {
        this.ImgName = ImgName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    private String claimHeading;
    private String treatmentDesc;
    private long claimAmount;
    private String imgLoaction;
    private String claimId;
    private String ImgName;
    private String userName;
    private String insCompany;
    private String hospitalName;
    private String status;
}
