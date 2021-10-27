class n3338750 {
	public void sortPlayersTurn() {
		Token utDkXt7a = new Token();
		Player Ksci7Thg = new Player("test name", utDkXt7a);
		int Vy5y6DaZ = 0;
		boolean uEpeO6L9 = true;
		for (int olzXMjta = 0; olzXMjta < playerNum - 1 && uEpeO6L9; olzXMjta++) {
			uEpeO6L9 = false;
			for (int AOz5QtTx = 0; AOz5QtTx < playerNum - 1 - olzXMjta; AOz5QtTx++) {
				if (diceSum[AOz5QtTx] < diceSum[AOz5QtTx + 1]) {
					Ksci7Thg = players[AOz5QtTx];
					Vy5y6DaZ = diceSum[AOz5QtTx];
					players[AOz5QtTx] = players[AOz5QtTx + 1];
					diceSum[AOz5QtTx] = diceSum[AOz5QtTx + 1];
					players[AOz5QtTx + 1] = Ksci7Thg;
					diceSum[AOz5QtTx + 1] = Vy5y6DaZ;
					uEpeO6L9 = true;
				}
			}
		}
	}

}