import java.util.Scanner;
class HelloWorld {
    public static void main(String[] args) {
        int a,b,c;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 3 no to compare");
        a=scan.nextInt();
        b=scan.nextInt();
        c=scan.nextInt();
        if(a<c)
        {
            if(a<b)
            {
                System.out.println(a);
            
            }
            else
            {
                System.out.println(b);
            }
        }
        else
        {
            if(b<c)
            {
                System.out.println(b);
                
            }
            else
            {
                System.out.println(c);
            }
        }
        
        
        //System.out.println("Hello, World!"); 
    }
}
