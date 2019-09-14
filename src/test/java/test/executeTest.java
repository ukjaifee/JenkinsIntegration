package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import commonClasses.baseClass;
import pages.DashBoard;
import pages.HomePage;
import pages.LoginPage;

public class executeTest extends baseClass {
	HomePage homepage;
	DashBoard dashboard;

	// @Test
	public void loginApp() {

		LoginPage l = new LoginPage(driver);
		homepage = l.login("", "");
		homepage.m1();
		dashboard = homepage.m1();
		dashboard.m2();

	}

	//@Test
	public void getExcelData() throws FilloException {

		Fillo fillo = new Fillo();
		Connection con = fillo.getConnection("D:/DLY.xlsx");

		String str = "Select * From Sheet4";
		Recordset rs = con.executeQuery(str);
	
		ArrayList<String> al=new ArrayList<String>();
		al=rs.getFieldNames();
		  while(rs.next()) {
		  
		 // System.out.println(rs.getField("Comp")+ ","+rs.getField("Round1")+","+rs.getField("Round2")); 
		  al.add(rs.getField("Comp")+ ","+rs.getField("Round1")+","+rs.getField("Round2"));
			
		  
		  /*
			 * for(int i=1; i<rs.getCount()-1; i++) {
			 * System.out.println(rs.getField("Comp")); }
			 */
		  
		  
		  }
		 // System.out.println(al);
		  
		 int colcount=rs.getFieldNames().size();
		// System.out.println(colcount);
		/*
		 * System.out.println(rs.getCount()); rs.moveLast();
		 * System.out.println(rs.getField("Comp")+
		 * "---"+rs.getField("Round1")+"----"+rs.getField("Round2"))
		 */;
		rs.close();
		con.close();

	}
	
	
	//@Test
	public void getExcelData_1() throws FilloException {

		Fillo fillo = new Fillo();
		Connection con = fillo.getConnection("D:/DLY.xlsx");

		TreeMap<String, String> hm=new TreeMap<String, String>();
		String str = "Select * From TestData";
		Recordset rs = con.executeQuery(str);
	
		ArrayList<String> al=new ArrayList<String>();
		al=rs.getFieldNames();
		ArrayList<String> al1=new ArrayList<String>();
		  while(rs.next()) {
		  for(int i=0; i<=al.size()-1; i++) {
			  String colName=al.get(i);
			  String colValue=rs.getField(colName);
			  //hm.put(colName, colValue);
				al1.add(colValue);
				
				
				/*
				 * for(int k=0; k<al1.size(); k++) { String strVal=al1.get(i);
				 * System.out.println(strVal);
				 * 
				 * }
				 */
			  
				/*
				 * Object[] objectArray = hm.entrySet().toArray(); for(int j=0;
				 * j<objectArray.length; j++)
				 * 
				 * System.out.println(Arrays.toString(objectArray));
				 */
		  }
	    
		// System.out.println(al1);
		  
		  }
		 
		
		rs.close();
		con.close();

	}
	//@Test
	public void getExcelData_2() throws FilloException {

		Fillo fillo = new Fillo();
		Connection con = fillo.getConnection("D:/DLY.xlsx");

		TreeMap<String, String> hm=new TreeMap<String, String>();
		String str = "Select * From Sheet4";
		Recordset rs = con.executeQuery(str);
	
		ArrayList<String> al=new ArrayList<String>();
		al=rs.getFieldNames();
		
		int rowCount=rs.getCount();
		int colCount=rs.getFieldNames().size();
		String str1 = null;
		Object[][] data=null;
		  while(rs.next()) {
		 // data[rowCount][colCount];
			for(int i=0; i<=al.size(); i++) {
				 str1=al.get(i);
				
				// System.out.println(str1);
				
			}  
			  
			
		  }
		 
		
		rs.close();
		con.close();

	}
	
	
	
	  @Test public static Object[] getExcelData_3() throws FilloException {
	  
	  Fillo fillo = new Fillo(); Connection con =
	  fillo.getConnection("D:/DLY.xlsx");
	  
	  TreeMap<String, String> hm=new TreeMap<String, String>(); 
	  String str ="Select * From TestData"; 
	  Recordset rs = con.executeQuery(str);
	  
	  ArrayList<String> al=new ArrayList<String>();
	  al=rs.getFieldNames();
	  ArrayList<String> al1=new ArrayList<String>();
	  while(rs.next()) {
		  for(int i=0; i<=al.size()-1; i++) { 
			  String colName=al.get(i); 
			  String colValue=rs.getField(colName); //hm.put(colName, colValue);
	        al1.add(colValue); }
	  
	  } // System.out.println(al1);
	  
	  rs.close(); con.close(); return al1.toArray();
	  
	  }
	  
	/*
	 * @DataProvider(name="headerDataProvider") public static Object[]
	 * headerDataProvider1() throws Exception{ System.out.
	 * println("In method headerDataProvider : Reading data from HeaderSheet");
	 * Object[] columns = executeTest.getExcelData_3(); return columns; }
	 * 
	 * @Test(dataProvider = "headerDataProvider") public void getData(String
	 * username, String password) { System.out.println("I am data from: ");
	 * 
	 * 
	 * }
	 */
	 
	
	
	
	@Test(dataProvider="dp")
	public void TestCaseA(String TestcasesA) throws Exception {
	    System.out.println(TestcasesA);
	}
	 
	@DataProvider(name="dp")
	public Object[] getdataproviderFillo() throws Exception{
	        System.out.println("Hello dp");
	        Object[] object = null;
	        Fillo fill = new Fillo();
	        Connection conn = fill.getConnection("D:/DLY.xlsx");
	        Recordset rs = conn .executeQuery("Select * from TestData");
	        System.out.println("rs.getCount()" + rs.getCount());
	        int count_num = rs.getCount();
	        int i=0;
	        object = new Object[count_num];
	        ArrayList<String> al=new ArrayList<String>();
	  	      al=rs.getFieldNames();
	        while (rs.next()) {
	            object[i++] = rs.getField("FirstName").toString();
	            System.out.println(object[i].toString());
	        }
	     return object;
	}
	
}
