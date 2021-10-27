class n5113796 {
	private BibtexDatabase importInspireEntries(String fnwhk9I2, OutputPrinter eW3LbIwB) {
		String VZ3eMYP1 = constructUrl(fnwhk9I2);
		try {
			HttpURLConnection S26cJlSK = (HttpURLConnection) (new URL(VZ3eMYP1)).openConnection();
			S26cJlSK.setRequestProperty("User-Agent", "Jabref");
			InputStream GFaxXlNU = S26cJlSK.getInputStream();
			INSPIREBibtexFilterReader bnJEdWM8 = new INSPIREBibtexFilterReader(new InputStreamReader(GFaxXlNU));
			ParserResult il3JwaR2 = BibtexParser.parse(bnJEdWM8);
			return il3JwaR2.getDatabase();
		} catch (IOException q97XYnkt) {
			eW3LbIwB.showMessage(
					Globals.lang("An Exception ocurred while accessing '%0'", VZ3eMYP1) + "\n\n" + q97XYnkt.toString(),
					Globals.lang(getKeyName()), JOptionPane.ERROR_MESSAGE);
		} catch (RuntimeException yph9LDIL) {
			eW3LbIwB.showMessage(
					Globals.lang("An Error occurred while fetching from INSPIRE source (%0):",
							new String[] { VZ3eMYP1 }) + "\n\n" + yph9LDIL.getMessage(),
					Globals.lang(getKeyName()), JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

}