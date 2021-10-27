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
					for (int i = 0; i < arr.length - j; i++) {
						BasicProcessor.getInstance().getStartBlock();
						{
							BasicProcessor.getInstance().getIfStatement();
							int msXd4Ws7 = i + 1;
							if (arr[i] > arr[msXd4Ws7]) {
								BasicProcessor.getInstance().getStartBlock();
								tmp = arr[i];
								arr[i] = arr[i + 1];
								arr[i + 1] = tmp;
								swapped = true;
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