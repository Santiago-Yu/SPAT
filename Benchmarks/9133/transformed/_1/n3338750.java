class n3338750 {
	public void sortPlayersTurn() {
		Token tempT = new Token();
		Player tempP = new Player("test name", tempT);
		int tempN = 0;
		boolean exchangeMade = true;
		int epKe2 = 0;
		while (epKe2 < playerNum - 1 && exchangeMade) {
			exchangeMade = false;
			for (int j = 0; j < playerNum - 1 - epKe2; j++) {
				if (diceSum[j] < diceSum[j + 1]) {
					tempP = players[j];
					tempN = diceSum[j];
					players[j] = players[j + 1];
					diceSum[j] = diceSum[j + 1];
					players[j + 1] = tempP;
					diceSum[j + 1] = tempN;
					exchangeMade = true;
				}
			}
			epKe2++;
		}
	}

}