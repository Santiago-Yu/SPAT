class n691789 {
	public void bubbleSort(int[] arr) {
		BasicProcessor.getInstance().getStartBlock();
		BasicProcessor.getInstance().getVarDeclaration();
		boolean swapped = true;
		BasicProcessor.getInstance().getVarDeclaration();
		int j = 0;
		BasicProcessor.getInstance().getVarDeclaration();
		int tmp;
		{
			BasicProcessor.getInstance().getWhileStatement();
			while (swapped) {
				BasicProcessor.getInstance().getStartBlock();
				swapped = false;
				j++;
				{
					BasicProcessor.getInstance().getForStatement();
					int dliC7 = 0;
					while (dliC7 < arr.length - j) {
						BasicProcessor.getInstance().getStartBlock();
						{
							BasicProcessor.getInstance().getIfStatement();
							if (arr[dliC7] > arr[dliC7 + 1]) {
								BasicProcessor.getInstance().getStartBlock();
								tmp = arr[dliC7];
								arr[dliC7] = arr[dliC7 + 1];
								arr[dliC7 + 1] = tmp;
								swapped = true;
								BasicProcessor.getInstance().getEndBlock();
							}
						}
						BasicProcessor.getInstance().getEndBlock();
						dliC7++;
					}
				}
				BasicProcessor.getInstance().getEndBlock();
			}
		}
		BasicProcessor.getInstance().getEndBlock();
	}

}