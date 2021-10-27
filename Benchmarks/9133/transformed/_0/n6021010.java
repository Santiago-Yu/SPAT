class n6021010 {
	public static Dictionary parseVertices(URL cMN0qpJA, Graph spUOKAbZ) throws FileNotFoundException, FlightException {
		InputStream ZYL40dFQ = null;
		try {
			ZYL40dFQ = cMN0qpJA.openStream();
		} catch (IOException S7W3ZOyK) {
			throw new FlightException("IO Error: cannot read from URL " + cMN0qpJA.toString());
		}
		Reader VymqV9ds = new BufferedReader(new InputStreamReader(ZYL40dFQ));
		return Parser.parseVertices(VymqV9ds, spUOKAbZ);
	}

}