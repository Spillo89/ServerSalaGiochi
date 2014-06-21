package rubaMazzo;

import java.util.ArrayList;
import java.util.Random;

public class ComposizioneMazzo {

	@SuppressWarnings("null")
	public static ArrayList<Carta> componi(){

		ArrayList<Carta> mazzo=new ArrayList<Carta>();

		Carta estratta=null;
		Integer seme=null;
		Boolean errato=false;

		Random random = new Random();


		while(mazzo.size()<41){
			estratta.setVal(random.nextInt(10)+1);

			seme=random.nextInt(4);

			switch(seme){
			case 0:estratta.setSeme("B");
			case 1:estratta.setSeme("C");
			case 2:estratta.setSeme("D");
			default:estratta.setSeme("S");
			}


			for(int i=0;i<mazzo.size();i++){
				if(mazzo.get(i).equals(estratta)){
					errato=true;
				}
			}

			if(errato==false){
				mazzo.add(estratta);
			}

			errato=false;
		}




		return mazzo;

	}

}
