package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VendorDaoImpl {

	SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
    private Connection getConn() throws ClassNotFoundException, SQLException
    {
        ResourceBundle rb = ResourceBundle.getBundle("anything");
        String url, driver, username, password;
        driver=rb.getString("driver");
        url=rb.getString("url");
        username=rb.getString("username");
        password=rb.getString("password");
        Class.forName(driver);
        return DriverManager.getConnection(url,username,password);
    }
    public int create(Vendor vendor) throws ClassNotFoundException, SQLException
    {
        Connection con = getConn();
        PreparedStatement st = con.prepareStatement("INSERT INTO Vendor VALUES(?,?,?)");
        st.setString(1, vendor.getVid());
        st.setString(2, vendor.getVname());
        st.setString(3, sdf.format(vendor.getArrivalDate()));
        int no=st.executeUpdate();
        return no;
    }
    public List<Vendor> read() throws Exception
    {
        Connection con = getConn();
        PreparedStatement st = con.prepareStatement("SELECT * FROM vendor");
        ResultSet rs = st.executeQuery();
        List<Vendor> vendorList=new ArrayList<Vendor>();
        while(rs.next())
        {
            Vendor vendor=new Vendor(rs.getString(1), rs.getString(2), sdf.parse(rs.getString(3)));
            vendorList.add(vendor);
        }
        return vendorList;
    }
    public Vendor read(String vid) throws ClassNotFoundException, SQLException, ParseException
    {
        Connection con = getConn();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Vendor WHERE vid=?");
        st.setString(1, vid);
        ResultSet rs = st.executeQuery();
        Vendor vendor=null;
        if(rs.next())
            vendor=new Vendor(rs.getString(1), rs.getString(2), sdf.parse(rs.getString(3)));
        return vendor;
    }
    public int update(Vendor vendor) throws ClassNotFoundException, SQLException
    {
        Connection con = getConn();
        PreparedStatement st = con.prepareStatement("UPDATE Vendor SET vname=?, price=? WHERE vid=?");
        st.setString(1, vendor.getVname());
        st.setString(2, sdf.format(vendor.getArrivalDate()));
        st.setString(3, vendor.getVid());
        int no=st.executeUpdate();
        return no;
    }
}
