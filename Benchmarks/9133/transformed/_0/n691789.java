class n691789 {
	public void bubbleSort(int[] JaEZ2BPc) {
		BasicProcessor.getInstance().getStartBlock();
		BasicProcessor.getInstance().getVarDeclaration();
		boolean w0NjNFQH = true;
		BasicProcessor.getInstance().getVarDeclaration();
		int kCiVBTfw = 0;
		BasicProcessor.getInstance().getVarDeclaration();
		int scNGvu1L;
		{
			BasicProcessor.getInstance().getWhileStatement();
			while (w0NjNFQH) {
				BasicProcessor.getInstance().getStartBlock();
				w0NjNFQH = false;
				kCiVBTfw++;
				{
					BasicProcessor.getInstance().getForStatement();
					for (int RuEBzl5N = 0; RuEBzl5N < JaEZ2BPc.length - kCiVBTfw; RuEBzl5N++) {
						BasicProcessor.getInstance().getStartBlock();
						{
							BasicProcessor.getInstance().getIfStatement();
							if (JaEZ2BPc[RuEBzl5N] > JaEZ2BPc[RuEBzl5N + 1]) {
								BasicProcessor.getInstance().getStartBlock();
								scNGvu1L = JaEZ2BPc[RuEBzl5N];
								JaEZ2BPc[RuEBzl5N] = JaEZ2BPc[RuEBzl5N + 1];
								JaEZ2BPc[RuEBzl5N + 1] = scNGvu1L;
								w0NjNFQH = true;
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