package rubaMazzo;

public class PescaCarta {
	
	public static void pescacarta(Integer idpartita, String nomeutente){
		
		
		
		Integer ncarte=PartitaRubamazzo.Partite.get(idpartita).getMazzo().size()-1;
		
		Carta cartapescata=PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(ncarte);
		
		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(ncarte);
		
		inserisciinmano(cartapescata, idpartita, nomeutente);
		
	}
	
	public static void inserisciinmano(Carta carta, Integer idpartita, String nomeutente){
		
		if(nomeutente.equalsIgnoreCase(PartitaRubamazzo.Partite.get(idpartita).getUtente1())){
			PartitaRubamazzo.Partite.get(idpartita).getSituazione().Carteinmano1.add(carta);
		}
		if(nomeutente.equalsIgnoreCase(PartitaRubamazzo.Partite.get(idpartita).getUtente2())){
			PartitaRubamazzo.Partite.get(idpartita).getSituazione().Carteinmano2.add(carta);
		}
		if(nomeutente.equalsIgnoreCase(PartitaRubamazzo.Partite.get(idpartita).getUtente3())){
			PartitaRubamazzo.Partite.get(idpartita).getSituazione().Carteinmano3.add(carta);
		}
		if(nomeutente.equalsIgnoreCase(PartitaRubamazzo.Partite.get(idpartita).getUtente4())){
			PartitaRubamazzo.Partite.get(idpartita).getSituazione().Carteinmano4.add(carta);
		}
		
	}
	

}
