class n3473669 {
	private BibtexDatabase importSpiresEntries(String HMD403MN, OutputPrinter yy5MswYj) {
		String GRytfKOF = constructUrl(HMD403MN);
		try {
			HttpURLConnection gg9hr3iK = (HttpURLConnection) (new URL(GRytfKOF)).openConnection();
			gg9hr3iK.setRequestProperty("User-Agent", "Jabref");
			InputStream I2HEfBFq = gg9hr3iK.getInputStream();
			SPIRESBibtexFilterReader WHus544K = new SPIRESBibtexFilterReader(new InputStreamReader(I2HEfBFq));
			ParserResult DM0kXd7O = BibtexParser.parse(WHus544K);
			return DM0kXd7O.getDatabase();
		} catch (IOException qnzfyvdA) {
			yy5MswYj.showMessage(
					Globals.lang("An Exception ocurred while accessing '%0'", GRytfKOF) + "\n\n" + qnzfyvdA.toString(),
					Globals.lang(getKeyName()), JOptionPane.ERROR_MESSAGE);
		} catch (RuntimeException y4LotcS6) {
			yy5MswYj.showMessage(
					Globals.lang("An Error occurred while fetching from SPIRES source (%0):", new String[] { GRytfKOF })
							+ "\n\n" + y4LotcS6.getMessage(),
					Globals.lang(getKeyName()), JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

}