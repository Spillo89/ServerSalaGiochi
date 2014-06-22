package rubaMazzo;

import java.util.ArrayList;

public class CalcolaVincitore {

	public static ArrayList<String> calcola(Integer idpartita){

		ArrayList<String> classifica = new ArrayList<String>();

		if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2){

			classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());
			classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());

			// 21

			if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3){

				classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());
				classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente2());
				classifica.set(0, PartitaRubamazzo.Partite.get(idpartita).getUtente3());

				// 321

				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4){

					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente2());
					classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente3());
					classifica.set(0, PartitaRubamazzo.Partite.get(idpartita).getUtente4());

					//4321

				}else{
					if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4){

						classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());
						classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente2());
						classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente4());

						// 3421

					}else{
						if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1){

							classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());
							classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente4());

							//3241

						}else{
							classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente4());

							//3214

						}
					}
				}

			}else{
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3&&PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1){

					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());
					classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente3());	

					//231

					if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2){

						classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());
						classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente2());
						classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente3());
						classifica.set(0, PartitaRubamazzo.Partite.get(idpartita).getUtente4());

						// 4231

					}else{
						if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3){

							classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());
							classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente3());
							classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente4());

							//2431

						}else{
							if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1){

								classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());
								classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente4());

								//2341

							}
							else{

								classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente4());

								//2314

							}
						}
					}

				}else{
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente3());

					//213

					if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4){

						classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente3());
						classifica.set(0, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
						classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente2());
						classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente1());

						//4213
					}
					else{
						if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4){

							classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente3());
							classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
							classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente1());

							//2413

						}else{
							if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3){

								classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente3());
								classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente4());

								//2143

							}else{
								if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4){

									classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente4());

									//2134

								}
							}
						}
					}

				}

			}


		}else{
			classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente1());
			classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());

			//12
			if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1){

				classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());
				classifica.set(0, PartitaRubamazzo.Partite.get(idpartita).getUtente3());
				classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente1());

				//312
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());
					classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente3());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente1());
					classifica.set(0, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					
					//4312
					
				}
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());
					classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente1());
					
					//3412
					
				}
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					
					//3142
				}
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					
					//3124
					
				}
			}
			
			if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2){
				
				classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());
				classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente3());
				
				//132
				
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente3());
					classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente1());
					classifica.set(0, PartitaRubamazzo.Partite.get(idpartita).getUtente4());

					//4132
					
				}
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente3());
					classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					
					//1432
					
				}
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente2());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					
					//1342
					
				}
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					
					//1324
					
				}
				
				
			}
			
			if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2){
				
				classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente3());
				
				//123
				
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente3());
					classifica.set(0, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente1());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente2());
					
					//4123
					
				}
				
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte1 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente3());
					classifica.set(1, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente1());
					
					//1423
					
				}
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte2 && PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4>PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente3());
					classifica.set(2, PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					
					//1243
					
				}
				if(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte4<PartitaRubamazzo.Partite.get(idpartita).getSituazione().Numerocarte3){
					
					classifica.add(PartitaRubamazzo.Partite.get(idpartita).getUtente4());
					
					//1234
					
				}
				
			}
			
			
		}
		
		return classifica;

	}


}
