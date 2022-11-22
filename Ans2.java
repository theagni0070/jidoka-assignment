// Throw an exception, catch and handle the outcomes
public class Ans2 {
    
    public static void main(String[] args) {

        B b = new B();
        
        try {
            
            // int this block we are accessing the method of B class
            b.example(null);

        } catch (Exception e) {
            
            // if method of B class throws any exception then we have handle that exception and we are handling all 
            // the exception here
            System.out.println(e.getMessage());

        }

    }

}

class B{

    // this method throws exception 
    public void example(String data) throws Exception{

        if(data==null) throw new NullPointerException();

        System.out.println(data);

    }

}