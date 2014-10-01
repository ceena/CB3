package mycloud;

public class SetSysOut {
	public static void main(String[] args) {
		// Create a stream to hold the output
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.PrintStream ps = new java.io.PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
		java.io.PrintStream old = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);
	    // Print some output: goes to your special stream
	    System.out.println("Foofoofoo!");
	    // Put things back
	    System.out.flush();
	    System.setOut(old);
	    // Show what happened
	    System.out.println("Here: " + baos.toString());
	}
}
