class CommandLineArg {

	public static void main(String[] args)
	{

		int n=args.length;

		for(int i=0;i<n;i++)
		{
			System.out.println(args[i]);
		}

		int sum=0;
		int max=-9999,min=9999;
		for(int i=0;i<n;i++)
		{
			sum=sum+Integer.parseInt(args[i]);
			int a=Integer.parseInt(args[i]);
			if(a>max)
			{
				max=a;
			}
			if(a<min)
			{
				min=a;
			}
		}

		System.out.println("Sum:"+sum);
		System.out.println("Max:"+max);
		System.out.println("Min:"+min);


	}
	
}