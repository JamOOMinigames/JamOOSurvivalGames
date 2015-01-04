package com.jamoorev.kroostylGames;

public class GameState {

	private static int gameState;
	
	public static void initGameState() {
		gameState = 0;
	}
	
	public static int getGameState() {
		return gameState;
	}
	
	public static void triggerNextGameState() {
		switch (gameState) {
			case 0:
				// Start pre-game
				GameStates.startPreGame();
				break;
			case 1:
				// Start real-game
				GameStates.startGame();
				break;
			case 2:
				// End real-game
				GameStates.endGame();
				break;
			case 3:
				// Transport all players away and then shutdown
				GameStates.closeEverything();
				break;
			default:
				// Transport all players away and then shutdown
				GameStates.closeEverything();
				break;
		}
		gameState++;
	}
	
}
