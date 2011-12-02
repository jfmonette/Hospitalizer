package ca.uqam.mgl7460.a2011.hospitalizer.aspects.tracing;

import java.io.*;

public aspect Tracing {
	pointcut traceMethods() : (execution(* *(..))&& !cflow(within(Tracing)));
	    before(): traceMethods() {
	        StringBuilder str = new StringBuilder();
	        str.append("Call from ");
	        str.append(thisJoinPointStaticPart.getSourceLocation().getWithinType().getCanonicalName());
	        str.append(" line ");
	        str.append(thisJoinPointStaticPart.getSourceLocation().getLine());
	        str.append(" to ");
	        str.append(thisJoinPointStaticPart.getSignature());
	        str.append("\n");
	        writeToFile(str.toString());
	    }
	    
	    private void writeToFile(String message) {
	    	try {
	    		FileWriter fileStream = new FileWriter("./data/tracing/trace.txt", true);
				BufferedWriter out = new BufferedWriter(fileStream);
				out.write(message);
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

}
