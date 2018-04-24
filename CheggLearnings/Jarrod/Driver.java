

public class Driver{
    
    private static int size = 10;
    private double arr[];
    private double sum = 0;
            
    
    public static void main(String [] args){
    
    //CREATE DRIVER OBJECT.
    Driver d1 = new Driver();
    
    //CREATE ARRAY
    d1.createArray();
    
    //CREATE THREADS AND RUN THEM.
    //can you read this?
    
    
    
    
    
    
    //here........................................................
    //we run the threads.
    
    new Runner(d1 , 0 ).run();
    new Runner(d1 , 1 ).run();
    
    //this will run the threads.
    //the first Runner calculates sum for 1st half of array
    //the second Runner for 2nd half.
    //and they both add it to the 'sum' variable
    //using addToSum(...);
    //the printSum() then displays the final value for 'sum'.
    
    //Let me know if you have any doubts
    
    
    
    //to be done.
    
    
    
    //DISPLAY FINAL SUM.
    d1.printSum();
    
    
    
    }
            
            
    public void createArray(){
    
        arr = new double[size];   
        //we fill the array now.
        //with values from 1 to 100 for simplicity.
        //using the Math.Random function
        
        for(int i=0 ; i<size ; i++)
            arr[i] = 1 + (int)(Math.random()*(99)+1);
                    // minvalue + (int)(Math.random()*(maxvalue-minvalue)+1)
            //any questions on this?
            
                
    }        
     
     
    public void addToSum(double fromThread){
    
        sum = sum + fromThread;
    }
     
    
    //to print the sum
    
    public void printSum(){
        System.out.println(sum);
    }
     
     
    public double[] getArray(){
    
        return arr;
    }
     
     
     
     
     
     
     
     
     
}     
