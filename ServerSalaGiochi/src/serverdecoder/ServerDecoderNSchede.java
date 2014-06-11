package serverdecoder;

import java.util.StringTokenizer;



public class ServerDecoderNSchede {
	
	public static Integer NumeroSchede=null;
	
	public static void decoderSchede(String stringainiziale){

		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		if(st.nextToken().equalsIgnoreCase("TOMBOLA")){
			NumeroSchede=Integer.parseInt(st.nextToken());
		}

	}

}
