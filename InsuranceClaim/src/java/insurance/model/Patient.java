
package insurance.model;

import insurance.dbutil.DBConnection;
import insurance.pojo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient {
    public static boolean patientVerified(String email, int password) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        System.out.println(email);
        PreparedStatement ps=conn.prepareStatement(" select * from patientdetails where userid=? and password=?");
        ps.setString(1,email);
        ps.setInt(2, password);
        ResultSet rs=ps.executeQuery();
        return rs.next()==true;
    }
    
    public static void getPatientDetailsById(String email)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from policydetails where emailid=?");
        ps.setString(1, email);
        ResultSet rs=ps.executeQuery();
        rs.next();
        UserProfile.setUniqueId(rs.getInt(1));
        UserProfile.setName(rs.getString(2));
        UserProfile.setAge(rs.getInt(3));
        UserProfile.setGender(rs.getString(4));
        UserProfile.setCurrentStatus(rs.getString(5));
        UserProfile.setMaxLimit(rs.getLong(6));
        UserProfile.setEmail(rs.getString(7));
        UserProfile.setCompName(rs.getString(8));
        UserProfile.setAadharNo(rs.getLong(9));
    }
}
