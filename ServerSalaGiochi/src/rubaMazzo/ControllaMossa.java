package rubaMazzo;

public class ControllaMossa {
	
	public static AggiornamentoCarte controlla(AggiornamentoCarte aggiornamentocarte, Carta cartagiocata, String utentecorrente, Integer idpartita){
		
		Boolean fatto=false;
		
		int i=0;
		if(utentecorrente.equalsIgnoreCase(PartitaRubamazzo.Partite.get(idpartita).getUtente1())){
			i=0;
		}
		if(utentecorrente.equalsIgnoreCase(PartitaRubamazzo.Partite.get(idpartita).getUtente2())){
			i=1;
		}
		if(utentecorrente.equalsIgnoreCase(PartitaRubamazzo.Partite.get(idpartita).getUtente3())){
			i=2;
		}
		if(utentecorrente.equalsIgnoreCase(PartitaRubamazzo.Partite.get(idpartita).getUtente4())){
			i=3;
		}
		
		if(i==0){
			if(cartagiocata.equals(aggiornamentocarte.Cartaincima2)){
				aggiornamentocarte.Numerocarte1=aggiornamentocarte.Numerocarte1+aggiornamentocarte.Numerocarte2;
				aggiornamentocarte.Cartaincima1=cartagiocata;
				aggiornamentocarte.Numerocarte2=0;
				aggiornamentocarte.Cartaincima2=null;
				fatto=true;
				
			}else{
				if(cartagiocata.equals(aggiornamentocarte.Cartaincima3)){
					aggiornamentocarte.Numerocarte1=aggiornamentocarte.Numerocarte1+aggiornamentocarte.Numerocarte3;
					aggiornamentocarte.Cartaincima1=cartagiocata;
					aggiornamentocarte.Numerocarte3=0;
					aggiornamentocarte.Cartaincima3=null;
					fatto=true;
					
				}else{
					if(cartagiocata.equals(aggiornamentocarte.Cartaincima4)){
						aggiornamentocarte.Numerocarte1=aggiornamentocarte.Numerocarte1+aggiornamentocarte.Numerocarte4;
						aggiornamentocarte.Cartaincima1=cartagiocata;
						aggiornamentocarte.Numerocarte3=0;
						aggiornamentocarte.Cartaincima4=null;
						fatto=true;
						
						
					}
				}
			}
			
			for(int j=0; j<aggiornamentocarte.Carteinbanco.size()||fatto==true;j++){
				if(cartagiocata.equals(aggiornamentocarte.Carteinbanco.get(j))){
					aggiornamentocarte.Cartaincima1=cartagiocata;
					aggiornamentocarte.Numerocarte1=aggiornamentocarte.Numerocarte1+2;
					aggiornamentocarte.Carteinbanco.remove(j);
					fatto=true;
					
				}
			}
			
			for(int j=0;j<aggiornamentocarte.Carteinbanco.size()||fatto==true;j++){
				for(int k=1;k<aggiornamentocarte.Carteinbanco.size();k++){
					if(cartagiocata.getVal()==aggiornamentocarte.Carteinbanco.get(j).getVal()+aggiornamentocarte.Carteinbanco.get(k).getVal()){
						aggiornamentocarte.Cartaincima1=cartagiocata;
						aggiornamentocarte.Numerocarte1=aggiornamentocarte.Numerocarte1+3;
						aggiornamentocarte.Carteinbanco.remove(j);
						aggiornamentocarte.Carteinbanco.remove(k);
						fatto=true;
					}
				}
				
			}
			if(fatto==false){
				aggiornamentocarte.Carteinbanco.add(cartagiocata);
			}
			
			for(int j=0; j<aggiornamentocarte.Carteinmano1.size();j++){
				if(cartagiocata.equals(aggiornamentocarte.Carteinmano1.get(j))){
					aggiornamentocarte.Carteinmano1.remove(j);
				}
			}
			
		}
		
		if(i==1){
			if(cartagiocata.equals(aggiornamentocarte.Cartaincima1)){
				aggiornamentocarte.Numerocarte2=aggiornamentocarte.Numerocarte2+aggiornamentocarte.Numerocarte1;
				aggiornamentocarte.Cartaincima2=cartagiocata;
				aggiornamentocarte.Numerocarte1=0;
				aggiornamentocarte.Cartaincima1=null;
				fatto=true;
				
			}else{
				if(cartagiocata.equals(aggiornamentocarte.Cartaincima3)){
					aggiornamentocarte.Numerocarte2=aggiornamentocarte.Numerocarte2+aggiornamentocarte.Numerocarte3;
					aggiornamentocarte.Cartaincima2=cartagiocata;
					aggiornamentocarte.Numerocarte3=0;
					aggiornamentocarte.Cartaincima3=null;
					fatto=true;
					
				}else{
					if(cartagiocata.equals(aggiornamentocarte.Cartaincima4)){
						aggiornamentocarte.Numerocarte2=aggiornamentocarte.Numerocarte2+aggiornamentocarte.Numerocarte4;
						aggiornamentocarte.Cartaincima2=cartagiocata;
						aggiornamentocarte.Numerocarte4=0;
						aggiornamentocarte.Cartaincima4=null;
						fatto=true;
						
						
					}
				}
			}
			
			for(int j=0; j<aggiornamentocarte.Carteinbanco.size()||fatto==true;j++){
				if(cartagiocata.equals(aggiornamentocarte.Carteinbanco.get(j))){
					aggiornamentocarte.Cartaincima2=cartagiocata;
					aggiornamentocarte.Numerocarte2=aggiornamentocarte.Numerocarte2+2;
					aggiornamentocarte.Carteinbanco.remove(j);
					fatto=true;
					
				}
			}
			
			for(int j=0;j<aggiornamentocarte.Carteinbanco.size()||fatto==true;j++){
				for(int k=1;k<aggiornamentocarte.Carteinbanco.size();k++){
					if(cartagiocata.getVal()==aggiornamentocarte.Carteinbanco.get(j).getVal()+aggiornamentocarte.Carteinbanco.get(k).getVal()){
						aggiornamentocarte.Cartaincima2=cartagiocata;
						aggiornamentocarte.Numerocarte2=aggiornamentocarte.Numerocarte2+3;
						aggiornamentocarte.Carteinbanco.remove(j);
						aggiornamentocarte.Carteinbanco.remove(k);
						fatto=true;
					}
				}
				
			}
			if(fatto==false){
				aggiornamentocarte.Carteinbanco.add(cartagiocata);
			}
			
			for(int j=0; j<aggiornamentocarte.Carteinmano2.size();j++){
				if(cartagiocata.equals(aggiornamentocarte.Carteinmano2.get(j))){
					aggiornamentocarte.Carteinmano2.remove(j);
				}
			}
			
		}
		
		if(i==2){
			if(cartagiocata.equals(aggiornamentocarte.Cartaincima1)){
				aggiornamentocarte.Numerocarte3=aggiornamentocarte.Numerocarte3+aggiornamentocarte.Numerocarte1;
				aggiornamentocarte.Cartaincima3=cartagiocata;
				aggiornamentocarte.Numerocarte1=0;
				aggiornamentocarte.Cartaincima1=null;
				fatto=true;
				
			}else{
				if(cartagiocata.equals(aggiornamentocarte.Cartaincima2)){
					aggiornamentocarte.Numerocarte3=aggiornamentocarte.Numerocarte3+aggiornamentocarte.Numerocarte2;
					aggiornamentocarte.Cartaincima3=cartagiocata;
					aggiornamentocarte.Numerocarte2=0;
					aggiornamentocarte.Cartaincima2=null;
					fatto=true;
					
				}else{
					if(cartagiocata.equals(aggiornamentocarte.Cartaincima4)){
						aggiornamentocarte.Numerocarte3=aggiornamentocarte.Numerocarte3+aggiornamentocarte.Numerocarte4;
						aggiornamentocarte.Cartaincima3=cartagiocata;
						aggiornamentocarte.Numerocarte4=0;
						aggiornamentocarte.Cartaincima4=null;
						fatto=true;
						
						
					}
				}
			}
			
			for(int j=0; j<aggiornamentocarte.Carteinbanco.size()||fatto==true;j++){
				if(cartagiocata.equals(aggiornamentocarte.Carteinbanco.get(j))){
					aggiornamentocarte.Cartaincima3=cartagiocata;
					aggiornamentocarte.Numerocarte3=aggiornamentocarte.Numerocarte3+2;
					aggiornamentocarte.Carteinbanco.remove(j);
					fatto=true;
					
				}
			}
			
			for(int j=0;j<aggiornamentocarte.Carteinbanco.size()||fatto==true;j++){
				for(int k=1;k<aggiornamentocarte.Carteinbanco.size();k++){
					if(cartagiocata.getVal()==aggiornamentocarte.Carteinbanco.get(j).getVal()+aggiornamentocarte.Carteinbanco.get(k).getVal()){
						aggiornamentocarte.Cartaincima3=cartagiocata;
						aggiornamentocarte.Numerocarte3=aggiornamentocarte.Numerocarte3+3;
						aggiornamentocarte.Carteinbanco.remove(j);
						aggiornamentocarte.Carteinbanco.remove(k);
						fatto=true;
					}
				}
				
			}
			if(fatto==false){
				aggiornamentocarte.Carteinbanco.add(cartagiocata);
			}
			
			for(int j=0; j<aggiornamentocarte.Carteinmano3.size();j++){
				if(cartagiocata.equals(aggiornamentocarte.Carteinmano3.get(j))){
					aggiornamentocarte.Carteinmano3.remove(j);
				}
			}
			
		}
		
		if(i==3){
			if(cartagiocata.equals(aggiornamentocarte.Cartaincima1)){
				aggiornamentocarte.Numerocarte4=aggiornamentocarte.Numerocarte4+aggiornamentocarte.Numerocarte1;
				aggiornamentocarte.Cartaincima4=cartagiocata;
				aggiornamentocarte.Numerocarte1=0;
				aggiornamentocarte.Cartaincima1=null;
				fatto=true;
				
			}else{
				if(cartagiocata.equals(aggiornamentocarte.Cartaincima2)){
					aggiornamentocarte.Numerocarte4=aggiornamentocarte.Numerocarte4+aggiornamentocarte.Numerocarte2;
					aggiornamentocarte.Cartaincima4=cartagiocata;
					aggiornamentocarte.Numerocarte2=0;
					aggiornamentocarte.Cartaincima2=null;
					fatto=true;
					
				}else{
					if(cartagiocata.equals(aggiornamentocarte.Cartaincima3)){
						aggiornamentocarte.Numerocarte4=aggiornamentocarte.Numerocarte4+aggiornamentocarte.Numerocarte3;
						aggiornamentocarte.Cartaincima4=cartagiocata;
						aggiornamentocarte.Numerocarte3=0;
						aggiornamentocarte.Cartaincima3=null;
						fatto=true;
						
						
					}
				}
			}
			
			for(int j=0; j<aggiornamentocarte.Carteinbanco.size()||fatto==true;j++){
				if(cartagiocata.equals(aggiornamentocarte.Carteinbanco.get(j))){
					aggiornamentocarte.Cartaincima4=cartagiocata;
					aggiornamentocarte.Numerocarte4=aggiornamentocarte.Numerocarte4+2;
					aggiornamentocarte.Carteinbanco.remove(j);
					fatto=true;
					
				}
			}
			
			for(int j=0;j<aggiornamentocarte.Carteinbanco.size()||fatto==true;j++){
				for(int k=1;k<aggiornamentocarte.Carteinbanco.size();k++){
					if(cartagiocata.getVal()==aggiornamentocarte.Carteinbanco.get(j).getVal()+aggiornamentocarte.Carteinbanco.get(k).getVal()){
						aggiornamentocarte.Cartaincima4=cartagiocata;
						aggiornamentocarte.Numerocarte4=aggiornamentocarte.Numerocarte4+3;
						aggiornamentocarte.Carteinbanco.remove(j);
						aggiornamentocarte.Carteinbanco.remove(k);
						fatto=true;
					}
				}
				
			}
			if(fatto==false){
				aggiornamentocarte.Carteinbanco.add(cartagiocata);
			}
			
			for(int j=0; j<aggiornamentocarte.Carteinmano4.size();j++){
				if(cartagiocata.equals(aggiornamentocarte.Carteinmano4.get(j))){
					aggiornamentocarte.Carteinmano4.remove(j);
				}
			}
			
		}
		
		return aggiornamentocarte;
	}

}
