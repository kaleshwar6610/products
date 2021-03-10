package model;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductDaoImpl {
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
    public int create(Product product) throws ClassNotFoundException, SQLException
    {
        Connection con = getConn();
        PreparedStatement st = con.prepareStatement("INSERT INTO Product VALUES(?,?,?,?,?,?)");
        st.setString(1, product.getPid());
        st.setString(2, product.getPname());
        st.setInt(3, product.getPrice());
        
        st.setString(4, sdf.format(product.getMfd()));
        st.setBytes(5, product.getImage());
        st.setString(6, product.getVid());
        int no=st.executeUpdate();
        return no;
    }
    public List<Product> read() throws ClassNotFoundException, SQLException, ParseException
    {
        Connection con = getConn();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Product");
        ResultSet rs = st.executeQuery();
        List<Product> productList=new ArrayList<Product>();
        while(rs.next())
        {
            Product product=new Product(rs.getString(1), rs.getString(2), rs.getInt(3), sdf.parse(rs.getString(4)), rs.getBytes(5), rs.getString(6));
            productList.add(product);
        }
        return productList;
    }
   

    public Product read(String pid) throws ClassNotFoundException, SQLException, ParseException
    {
        Connection con = getConn();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Product WHERE pid=?");
        st.setString(1, pid);
        ResultSet rs = st.executeQuery();
        Product product=null;
        if(rs.next())
            product=new Product(rs.getString(1), rs.getString(2), rs.getInt(3), sdf.parse(rs.getString(4)), rs.getBytes(5), rs.getString(6));
        return product;
    }
	public int update(Product product) throws ClassNotFoundException, SQLException
        {
            Connection con = getConn();
            PreparedStatement st = con.prepareStatement("UPDATE Product SET pname=?, price=?, mfd=?, image=?, vid=? WHERE pid=?");
            st.setString(1, product.getPname());
            st.setInt(2, product.getPrice());
            st.setString(3, sdf.format(product.getMfd()));
            st.setBytes(4, product.getImage());
            st.setString(5, product.getVid());
            st.setString(6, product.getPid());
            int no=st.executeUpdate();
            return no;
        }

	public int delete(Integer pid) throws ClassNotFoundException, SQLException
	    {
	        Connection con = getConn();
	        PreparedStatement st = con.prepareStatement("DELETE FROM Product WHERE pid=?");
	                
	        st.setInt(1, pid);
	        int no=st.executeUpdate();
	        return no;
	    }
}
