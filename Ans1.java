// Show implementation of a class and example of inheritance.

// this is the implements of class with a public method
class A{

    // public method which prints data passed to this method
    public void printData(String data){

        // printing 
        System.out.println(data);

    }

    // public static method which prints the data
    public static void example(String data){

        System.out.println(data);

    }

}


// this class is inherting A class and can access all the method of A class by creating object of that class
// but it can also access the static method directly without creating objects of any class
// this is the example of single level inheritence.
class Main extends A{

    public static void fun() {

        example("Hello Example");

        Main m = new Main();

        m.printData("Hello Data");

    }

}

// this is the multilevel inheritence because Main1 is extending Main and Main is extending A
// by this we can acces all the method of A class as well as all the methods of Main class also.
class Main1 extends Main{

    public static void main(String[] args) {
        
        fun();

    }


}