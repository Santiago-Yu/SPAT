class n6021012 {
	public static void parseEdges(URL TmUlpTcf, Graph dOWs7ymD, Dictionary f8HRlu93)
			throws FileNotFoundException, FlightException {
		InputStream M461lE0p = null;
		try {
			M461lE0p = TmUlpTcf.openStream();
		} catch (IOException Q52NLRte) {
			throw new FlightException("IO Error: cannot read from URL " + TmUlpTcf.toString());
		}
		Reader UUVMtze8 = new BufferedReader(new InputStreamReader(M461lE0p));
		Parser.parseEdges(UUVMtze8, dOWs7ymD, f8HRlu93);
	}

}