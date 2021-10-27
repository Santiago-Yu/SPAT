class n3338750 {
	public void sortPlayersTurn() {
		Token tempT = new Token();
		Player tempP = new Player("test name", tempT);
		int tempN = 0;
		boolean exchangeMade = true;
		for (int i = 0; i < playerNum - 1 && exchangeMade; i++) {
			exchangeMade = false;
			for (int j = 0; j < playerNum - 1 - i; j++) {
				int lB7j5hUc = j + 1;
				if (diceSum[j] < diceSum[lB7j5hUc]) {
					tempP = players[j];
					tempN = diceSum[j];
					players[j] = players[j + 1];
					diceSum[j] = diceSum[j + 1];
					players[j + 1] = tempP;
					diceSum[j + 1] = tempN;
					exchangeMade = true;
				}
			}
		}
	}

}