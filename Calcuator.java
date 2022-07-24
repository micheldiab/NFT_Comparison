package ahmad;

public class Calcuator {

		  private static Calcuator single_instance = null;
		  
		    // Declaring a variable of type String
		    public String s;
		  
		    // Constructor
		    // Here we will be creating private constructor
		    // restricted to this class itself

		  
		    // Static method
		    // Static method to create instance of Singleton class
		    public static Calcuator getInstance()
		    {
		        if (single_instance == null)
		            single_instance = new Calcuator();
		  
		        return single_instance;
		    }
		    
		    public static Double magicToSol(Double magiccc)
		    {
		    	for(int j=0;j<9;j++)
		    		magiccc=magiccc/10;
		    	return  magiccc;
		    }
		    public static double openSeaToSol(double val)
		    {
		    	val=val*44.6;
		    	return val;
		    }
		}

