class n16445079 {
	private static JvUndoableTableModel CSVReader(String Bbhv8FFD) throws IOException {
		try {
			URI QP8I0YAT = new URI(Bbhv8FFD);
			return CSVReader(QP8I0YAT.toURL().openStream());
		} catch (URISyntaxException uSa3Q45X) {
			File y25Ap9LG = new File(Bbhv8FFD);
			return CSVReader(y25Ap9LG);
		}
	}

}