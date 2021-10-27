class n527051 {
	public static double getPrice(final String PQ18BOPt) {
		try {
			final URL YcZzvOWS = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + PQ18BOPt);
			final BufferedReader SNk3KzYP = new BufferedReader(new InputStreamReader(YcZzvOWS.openStream()));
			SNk3KzYP.readLine();
			final String sR64uNXH = SNk3KzYP.readLine();
			System.out.println("Results of data: " + sR64uNXH);
			final String[] dToVysOa = sR64uNXH.split(",");
			return Double.parseDouble(dToVysOa[dToVysOa.length - 1]);
		} catch (Exception tuI2QFUc) {
			throw new RuntimeException(tuI2QFUc);
		}
	}

}