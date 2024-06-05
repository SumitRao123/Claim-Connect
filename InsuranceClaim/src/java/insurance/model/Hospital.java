/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.model;

import insurance.dbutil.DBConnection;
import insurance.pojo.ClaimDetailsPojo;
import insurance.pojo.PatientPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Hospital {
    public static PatientPojo getPatientDetailById(int id) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(" select * from POLICYDETAILS where uniqueid=?");
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        PatientPojo p=null;
        if(rs.next()==true)
        {
            p=new PatientPojo();
            p.setUniqueId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setAge(rs.getInt(3));
            p.setGender(rs.getString(4));
            p.setCurrentStatus(rs.getString(5));
            p.setMaxLimit(rs.getLong(6));
            p.setEmail(rs.getString(7));
            p.setCompName(rs.getString(8));
            p.setAadharNo(rs.getLong(9));
            p.setCurrentAmount(rs.getLong(10));
        }
        return p;
    }
    
    public static String nextClaimId() throws SQLException
    {
        return "C101";
    }
    
    public static boolean insertClaim(ClaimDetailsPojo c)throws SQLException
    {
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("insert into treatmentdetails values(?,?,?,?,?,?,?,?,?,?)");
         ps.setString(1, c.getClaimHeading());
         ps.setString(2, c.getTreatmentDesc());
         ps.setLong(3, c.getClaimAmount());
         ps.setString(4, c.getImgLoaction());
         ps.setString(5, c.getClaimId());
         ps.setString(6, c.getImgName());
         ps.setString(7, c.getUserName());
         ps.setString(8, c.getInsCompany());
         ps.setString(9, c.getHospitalName());
         ps.setString(10, c.getStatus());
         int row=ps.executeUpdate();
         return row==1;
    }
    
    public static ClaimDetailsPojo display( String id) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(" select * from treatmentdetails where claimid=?");
        ps.setString(1,id);
        ResultSet rs=ps.executeQuery();
        ClaimDetailsPojo c=null;
        if(rs.next()==true)
        {
            c=new ClaimDetailsPojo();
            c.setClaimHeading(rs.getString(1));
            c.setTreatmentDesc(rs.getString(2));
            c.setClaimAmount(rs.getLong(3));
            c.setImgLoaction(rs.getString(4));
            c.setClaimId(id);
            c.setImgName(rs.getString(6));
            c.setUserName(rs.getString(7));
            c.setInsCompany(rs.getString(8));
        }
        return c;
    }
    
    public static ArrayList<ClaimDetailsPojo> getClaimDetailsByUser(String userName) throws SQLException
    {
        System.out.println(userName);
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from treatmentdetails where username=? and status='y'");
        ps.setString(1, userName);
        ResultSet rs=ps.executeQuery();
        ArrayList<ClaimDetailsPojo> arr=new ArrayList<>();
        while(rs.next()==true)
        {
            ClaimDetailsPojo cdp=new ClaimDetailsPojo();
            cdp.setClaimHeading(rs.getString(1));
            cdp.setTreatmentDesc(rs.getString(2));
            cdp.setClaimAmount(rs.getLong(3));
            cdp.setImgLoaction(rs.getString(4));
            cdp.setClaimId(rs.getString(5));
            cdp.setImgName(rs.getString(6));
            cdp.setUserName(userName);
            cdp.setInsCompany(rs.getString(8));
            cdp.setHospitalName(rs.getString(9));
            cdp.setStatus(rs.getString(10));
            System.out.println(cdp);
            arr.add(cdp);
            
        }
        
        return arr;
    }
    
    public static ArrayList<ClaimDetailsPojo> getClaimDetailsByUserFault(String userName) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from treatmentdetails where username=? and status='n'");
        ps.setString(1, userName);
        ResultSet rs=ps.executeQuery();
        ArrayList<ClaimDetailsPojo> arr=new ArrayList<>();
        while(rs.next()==true)
        {
            ClaimDetailsPojo cdp=new ClaimDetailsPojo();
            cdp.setClaimHeading(rs.getString(1));
            cdp.setTreatmentDesc(rs.getString(2));
            cdp.setClaimAmount(rs.getLong(3));
            cdp.setImgLoaction(rs.getString(4));
            cdp.setClaimId(rs.getString(5));
            cdp.setImgName(rs.getString(6));
            cdp.setUserName(userName);
            cdp.setInsCompany(rs.getString(8));
            cdp.setHospitalName(rs.getString(9));
            cdp.setStatus(rs.getString(10));
            arr.add(cdp);
            
        }
        
        return arr;
    }
    
    
    public static boolean updateClaimStatus(String userName, String status) throws SQLException
    {
        if(status.equalsIgnoreCase("'successfull'"))
            return true;
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update treatmentdetails set status='n' where username=? ");
        ps.setString(1,userName);
        int row=ps.executeUpdate();
        return row!=0;
    }
    
    public static ArrayList<ClaimDetailsPojo> getPendingClaims()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from treatmentdetails where status='n'");
        ResultSet rs=ps.executeQuery();
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
