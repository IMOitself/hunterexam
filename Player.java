
import java.util.List;public class Player 
{
	static String getTopPlayers(){
		String a = "";
		int i = 1;
		List<String> topPlayers = SQL.runGetResultAll("SELECT current_score, username FROM players ORDER BY current_score DESC LIMIT 5");
		
		if(topPlayers.isEmpty()){
			a = "no players yet.";
		}
		
		for(String player : topPlayers){
			player = player.replace("::", "    ").trim();
			if(i == 1){
				a += "TOP PLAYERS:";
				a += "\n🥇 " + player;
			}else
			
			if(i == 2){
				a += "\n🥈 " + player;
			}else
			
			if(i == 3){
				a += "\n🥉 " + player;
			}
			else{
				a += "\n " + i + " " + player;
			}
			i++;
		}
		return a;
	}
}
