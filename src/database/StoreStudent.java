package database;
import java.sql.*;
import Source.*;

import Source.Student;

public class StoreStudent {

	public static void main(String[] args) {
		
		Connection con;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Training","root","Rukesh2274");
			
			// Query
			
			Statement stm;
			stm = con.createStatement();
			
			//execeuteQuery() - Select ResultSet (Set of Record)
			//executeUpdate() - DML - Insert / Delete / update - int
			///execute() - DML(1/0) - DDL(Create/0) - boolean
			
			stm.execute("insert into student(RollNo, SName) Values('20113119', 'Rukesh')");
			
			// variables ?
			//setXXX(index, value)  // data type setInt, setString
			PreparedStatement ps = con.prepareStatement("INSERT INTO student values(?,?,?,?,?,?,?,?,?)");
			
			Student s = new Student("20113118", "Rohith", 10, 20, 30 ,440, 50);
			s.Calculate();
			ps.setString(1, s.RollNo);
			ps.setString(2, s.SName);
			ps.setInt(3, s.m1);
			ps.setInt(4, s.m2);
			ps.setInt(5, s.m3);
			ps.setInt(6, s.m4);
			ps.setInt(7, s.m5);
			ps.setInt(8,s.Total);
			ps.setDouble(9, s.Average);
			ps.execute();
			
			
			ResultSet rs = ps.executeQuery("select * from student");
			
			while(rs.next())
			{
				System.out.println(rs.getString("RollNo"));
			}
		}
		
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.out.println("hello");
		}
		
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}


import java.util.HashSet;

public class FirstRepeatedElement {

    public static int findFirstRepeatedElement(int[] arr, int n) {
        // Create a hash set to store the elements of the array.
        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array from the last index.
        for (int i = n - 1; i >= 0; i--) {
            // If the element is present in the hash set, then it is a repeated element.
            if (set.contains(arr[i])) {
                return arr[i];
            } else {
                // Add the element to the hash set.
                set.add(arr[i]);
            }
        }

        // If no repeated element is found, then return the last element of the array.
        return arr[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 2, 8};
        int n = arr.length;

        int firstRepeatedElement = findFirstRepeatedElement(arr, n);

        System.out.println("The first repeated element in the array from the tail is: " + firstRepeatedElement);
    }
}
