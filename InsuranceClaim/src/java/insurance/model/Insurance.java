/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.model;

import insurance.dbutil.DBConnection;
import insurance.pojo.ClaimDetailsPojo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Insurance {
    
    public static ArrayList<ClaimDetailsPojo> getClaimByInsurance() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from treatmentdetails where status='y'");
        ArrayList<ClaimDetailsPojo> arr=new ArrayList<>();
        while(rs.next())
        {
            ClaimDetailsPojo cdp=new ClaimDetailsPojo();
            cdp.setClaimHeading(rs.getString(1));
            cdp.setTreatmentDesc(rs.getString(2));
            cdp.setClaimAmount(rs.getLong(3));
            cdp.setImgLoaction(rs.getString(4));
            cdp.setClaimId(rs.getString(5));
            cdp.setImgName(rs.getString(6));
            cdp.setUserName(rs.getString(7));
            cdp.setInsCompany(rs.getString(8));
            cdp.setHospitalName(rs.getString(9));
            cdp.setStatus(rs.getString(10));
            arr.add(cdp);
        }
        return arr;
    }
    
    public static ArrayList<ClaimDetailsPojo> getClaimUserByInsurance(String status) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from treatmentdetails where status='n'");
        ArrayList<ClaimDetailsPojo> arr=new ArrayList<>();
        while(rs.next())
        {
            ClaimDetailsPojo cdp=new ClaimDetailsPojo();
            cdp.setClaimHeading(rs.getString(1));
            cdp.setTreatmentDesc(rs.getString(2));
            cdp.setClaimAmount(rs.getLong(3));
            cdp.setImgLoaction(rs.getString(4));
            cdp.setClaimId(rs.getString(5));
            cdp.setImgName(rs.getString(6));
            cdp.setUserName(rs.getString(7));
            cdp.setInsCompany(rs.getString(8));
            cdp.setHospitalName(rs.getString(9));
            cdp.setStatus(rs.getString(10));
            arr.add(cdp);
        }
        return arr;
    }
    
}
