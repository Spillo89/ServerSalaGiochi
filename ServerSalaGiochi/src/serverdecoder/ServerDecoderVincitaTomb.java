package serverdecoder;

import java.util.StringTokenizer;

public class ServerDecoderVincitaTomb {
	
	public static String VincitaTombola=null;
	
		public static void decodervincita(String stringainiziale){

			StringTokenizer st = new StringTokenizer(stringainiziale, "#");
			if(st.nextToken().equalsIgnoreCase("VINCITATOMBOLA")){
				VincitaTombola=st.nextToken();
			}

		}

}
