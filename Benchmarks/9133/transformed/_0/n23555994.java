class n23555994 {
	public OperandToken evaluate(Token[] XqUpBeAu, GlobalValues Ra6vZPhK) {
		String pRciFZag = "";
		String aJfELMVQ = "";
		;
		if (getNArgIn(XqUpBeAu) != 1)
			throwMathLibException("urlread: number of arguments < 1");
		if (!(XqUpBeAu[0] instanceof CharToken))
			throwMathLibException("urlread: argument must be String");
		String RedYgqwE = ((CharToken) XqUpBeAu[0]).toString();
		URL yAGMwtV2 = null;
		try {
			yAGMwtV2 = new URL(RedYgqwE);
		} catch (Exception GAqPuTuJ) {
			throwMathLibException("urlread: malformed url");
		}
		try {
			BufferedReader Cqfxc1D1 = new BufferedReader(new InputStreamReader(yAGMwtV2.openStream()));
			while ((aJfELMVQ = Cqfxc1D1.readLine()) != null) {
				pRciFZag += aJfELMVQ + "\n";
			}
			Cqfxc1D1.close();
		} catch (Exception pyvA3QM6) {
			throwMathLibException("urlread: error input stream");
		}
		return new CharToken(pRciFZag);
	}

}