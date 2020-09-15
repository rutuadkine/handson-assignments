class GradesCalc{

	public static void main(String[] args)
	{
		int marks= Integer.parseInt(args[0]);

		if(marks>=70)
		{
			System.out.println("Distinction");
		}
		else if(marks<70 && marks>=60)
		{
			System.out.println("First Class");
		}
		else if(marks<60 && marks>=50)
		{
			System.out.println("Second Class");
		}
		else if(marks<50 && marks>=35)
		{
			System.out.println("Pass");
		}
		else if(marks<35)
		{
			System.out.println("Fail");
		}

	}
}