class n793386 {
	public void bubbleSort(int[] jNhvRA4a) {
		BasicProcessor.getInstance().getStartBlock();
		BasicProcessor.getInstance().getVarDeclaration();
		boolean gMPXbpiY = true;
		BasicProcessor.getInstance().getVarDeclaration();
		int JaapO6Pg = 0;
		BasicProcessor.getInstance().getVarDeclaration();
		int yVlVPKsJ;
		{
			BasicProcessor.getInstance().getWhileStatement();
			while (gMPXbpiY) {
				BasicProcessor.getInstance().getStartBlock();
				gMPXbpiY = false;
				JaapO6Pg++;
				{
					BasicProcessor.getInstance().getForStatement();
					for (int LJJePhyb = 0; LJJePhyb < jNhvRA4a.length - JaapO6Pg; LJJePhyb++) {
						BasicProcessor.getInstance().getStartBlock();
						{
							BasicProcessor.getInstance().getIfStatement();
							if (jNhvRA4a[LJJePhyb] > jNhvRA4a[LJJePhyb + 1]) {
								BasicProcessor.getInstance().getStartBlock();
								yVlVPKsJ = jNhvRA4a[LJJePhyb];
								jNhvRA4a[LJJePhyb] = jNhvRA4a[LJJePhyb + 1];
								jNhvRA4a[LJJePhyb + 1] = yVlVPKsJ;
								gMPXbpiY = true;
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