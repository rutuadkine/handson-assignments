class ArraysDemo{
    public static void main(String[] args)
    {
        String[] arr = {"RUTUJA","SIDDHI","SHARAYU","KEDU","SHAMBHU"};
        
        int n=arr.length;

        System.out.println("Array is of size"+n);

        for (String s: arr)
        {
            System.out.println(s);
        }
    }
}