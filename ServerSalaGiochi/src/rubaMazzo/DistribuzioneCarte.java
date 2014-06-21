package rubaMazzo;

public class DistribuzioneCarte {

	@SuppressWarnings("null")
	public static AggiornamentoCarte maziere(Integer idpartita){

		AggiornamentoCarte aggiornamento=null;

		aggiornamento.Carteinmano1.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(39));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(39);

		aggiornamento.Carteinmano1.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(38));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(38);

		aggiornamento.Carteinmano1.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(37));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(37);

		aggiornamento.Carteinmano2.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(36));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(36);

		aggiornamento.Carteinmano2.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(35));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(35);

		aggiornamento.Carteinmano2.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(34));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(34);

		aggiornamento.Carteinbanco.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(33));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(33);

		aggiornamento.Carteinbanco.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(32));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(32);

		aggiornamento.Carteinbanco.add(PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(31));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(31);

		aggiornamento.Carteinbanco.add(PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(30));

		PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(30);

		if(!PartitaRubamazzo.Partite.get(idpartita).getUtente3().equalsIgnoreCase(null)){

			aggiornamento.Carteinmano3.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(29));

			PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(29);

			aggiornamento.Carteinmano3.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(28));

			PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(28);

			aggiornamento.Carteinmano3.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(27));

			PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(27);

		}

		if(!PartitaRubamazzo.Partite.get(idpartita).getUtente4().equalsIgnoreCase(null)){

			aggiornamento.Carteinmano4.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(26));

			PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(26);

			aggiornamento.Carteinmano4.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(25));

			PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(25);

			aggiornamento.Carteinmano4.add( PartitaRubamazzo.Partite.get(idpartita).getMazzo().get(24));

			PartitaRubamazzo.Partite.get(idpartita).getMazzo().remove(24);

		}
		
		return aggiornamento;


	}


}
