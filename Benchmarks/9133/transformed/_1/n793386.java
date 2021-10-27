class n793386 {
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
					int jRm8N = 0;
					while (jRm8N < arr.length - j) {
						BasicProcessor.getInstance().getStartBlock();
						{
							BasicProcessor.getInstance().getIfStatement();
							if (arr[jRm8N] > arr[jRm8N + 1]) {
								BasicProcessor.getInstance().getStartBlock();
								tmp = arr[jRm8N];
								arr[jRm8N] = arr[jRm8N + 1];
								arr[jRm8N + 1] = tmp;
								swapped = true;
								BasicProcessor.getInstance().getEndBlock();
							}
						}
						BasicProcessor.getInstance().getEndBlock();
						jRm8N++;
					}
				}
				BasicProcessor.getInstance().getEndBlock();
			}
		}
		BasicProcessor.getInstance().getEndBlock();
	}

}