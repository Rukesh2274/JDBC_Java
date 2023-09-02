package Source;

public class Student {
	
	public String RollNo;
	public String SName;
	public int m1, m2, m3, m4, m5;
	public int Total;
	public double Average;
	
	Student()
	{
		
	}
	
	public Student(String rno, String name, int n1, int n2, int n3, int n4, int n5)
	{
		RollNo = rno;
		SName = name;
		m1 = n1; m2 = n2; m3 = n3; m4 = n4; m5 = n5;
		
	}
	public void Calculate()
	{
		Total = m1 + m2 + m3 + m4 + m5;
		Average = Total / 5;
	}

}
