class n465616 {
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
					int qOcjs = 0;
					while (qOcjs < arr.length - j) {
						BasicProcessor.getInstance().getStartBlock();
						{
							BasicProcessor.getInstance().getIfStatement();
							if (arr[qOcjs] > arr[qOcjs + 1]) {
								BasicProcessor.getInstance().getStartBlock();
								tmp = arr[qOcjs];
								arr[qOcjs] = arr[qOcjs + 1];
								arr[qOcjs + 1] = tmp;
								swapped = true;
								BasicProcessor.getInstance().getEndBlock();
							}
						}
						BasicProcessor.getInstance().getEndBlock();
						qOcjs++;
					}
				}
				BasicProcessor.getInstance().getEndBlock();
			}
		}
		BasicProcessor.getInstance().getEndBlock();
	}

}