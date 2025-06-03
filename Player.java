
import java.util.List;
public class Player 
{
	static String username = "none";
	static String password = "none";
	static int currentPhase = 1;
	static int currentScore = 0;


	static String getTopPlayers(){
		String a = "";
		int i = 1;
		List<String> topPlayers = SQL.runGetResultAll("SELECT current_score, username FROM players ORDER BY current_score DESC LIMIT 5");
		
		if(topPlayers.isEmpty()){
			a = "no players yet.";
		}
		
		for(String player : topPlayers){
			player = player.replace("::", "    ").trim();
			if(i == 1) a += "TOP PLAYERS:";
			a += "\n " + i + " " + player;
			i++;
		}
		return a;
	}

	static boolean isUsernameExists(String username){
		return !SQL.runGetResult("SELECT username FROM players WHERE username = '" + username + "';").isEmpty();
	}

	static void register(String username, String password){
		SQL.run("INSERT INTO players (username, password) VALUES ('" + username + "', '" + password + "');");
	}

	static boolean canLogin(String username, String password){
		List<String> player = SQL.runGetResultAll("SELECT username, password, current_phase, current_score FROM players WHERE username = '" + username + "';");
		
		if(player.isEmpty()){
			System.out.println("username not found.");
			return false;
		}
		
		String[] playerData = player.get(0).split("::");
		
		if(!playerData[1].equals(password)){
			System.out.println("password do not match.");
			return false;
		}

		Player.username = username;
		Player.password = password;
		Player.currentPhase = Integer.parseInt(playerData[2]);
		Player.currentScore = Integer.parseInt(playerData[3]);
		return true;
	}

	static void updateScore(){
		SQL.run("UPDATE players SET current_score = '" + currentScore + "' WHERE username = '" + username + "';");
	}
	static void updatePhase(int phase){
		SQL.run("UPDATE players SET current_phase = '" + phase + "' WHERE username = '" + username + "';");
		currentPhase = phase;
	}
}
