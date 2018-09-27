package tonyx.Tools.Utilities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DeepCopy {
	public static List<?> ListDeepCopy(List<?> src){
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();      
        ObjectOutputStream out;
        List<?> dest = null;
		try {
			out = new ObjectOutputStream(byteOut);
	        out.writeObject(src);      
	          
	        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());      
	        ObjectInputStream in =new ObjectInputStream(byteIn);      
	        dest = (List<?>)in.readObject();  
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}      
    
        return dest; 
	}
}
