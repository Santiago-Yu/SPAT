class n465616 {
	public void bubbleSort(int[] GTgNolSB) {
		BasicProcessor.getInstance().getStartBlock();
		BasicProcessor.getInstance().getVarDeclaration();
		boolean Yu1dVyqp = true;
		BasicProcessor.getInstance().getVarDeclaration();
		int QS0E3Qax = 0;
		BasicProcessor.getInstance().getVarDeclaration();
		int PQdjrQnb;
		{
			BasicProcessor.getInstance().getWhileStatement();
			while (Yu1dVyqp) {
				BasicProcessor.getInstance().getStartBlock();
				Yu1dVyqp = false;
				QS0E3Qax++;
				{
					BasicProcessor.getInstance().getForStatement();
					for (int tnd4XsNE = 0; tnd4XsNE < GTgNolSB.length - QS0E3Qax; tnd4XsNE++) {
						BasicProcessor.getInstance().getStartBlock();
						{
							BasicProcessor.getInstance().getIfStatement();
							if (GTgNolSB[tnd4XsNE] > GTgNolSB[tnd4XsNE + 1]) {
								BasicProcessor.getInstance().getStartBlock();
								PQdjrQnb = GTgNolSB[tnd4XsNE];
								GTgNolSB[tnd4XsNE] = GTgNolSB[tnd4XsNE + 1];
								GTgNolSB[tnd4XsNE + 1] = PQdjrQnb;
								Yu1dVyqp = true;
								BasicProcessor.getInstance().getEndBlock();
							}
						}
						BasicProcessor.getInstance().getEndBlock();
					}
				}
				BasicProcessor.getInstance().getEndBlock();
			}
		}
		BasicProcessor.getInstance().getEndBlock();
	}

}