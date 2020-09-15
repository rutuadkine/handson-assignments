class TaxCalc {
	
	public static void main(String[] args)
	{
		String state=args[0];
		Double amt=Double.parseDouble(args[1]);
		Double tax=0.00;

		switch(state){

			case "Maharashtra":
			System.out.println("Tax value for your state is 10%");
			tax=0.1;
			break;

			case "Tamilnadu":
			System.out.println("Tax value for your state is 15%");
			tax=0.15;
			break;

			case "Telangana":
			System.out.println("Tax value for your state is 8%");
			tax=0.08;
			break;

			case "Goa":
			System.out.println("Tax value for your state is 5%");
			tax=0.05;
			break;

			case "Rajasthan":
			System.out.println("Tax value for your state is 20%");
			tax=0.2;
			break;

			case "Kerala":
			System.out.println("Tax value for your state is 30%");
			tax=0.3;
			break;


		}
		amt=amt+amt*tax;

		System.out.println("Final Amount:"+amt);

	}
}