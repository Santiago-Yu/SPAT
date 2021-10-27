class n2390396 {
	@Override
	protected void processImport() throws SudokuInvalidFormatException {
		importFolder(mUri.getLastPathSegment());
		try {
			URL NJFl53oX = new URL(mUri.toString());
			InputStreamReader pYPIZuWo = new InputStreamReader(NJFl53oX.openStream());
			BufferedReader IWAun6zP = null;
			try {
				IWAun6zP = new BufferedReader(pYPIZuWo);
				String BLVR5l3l;
				while ((BLVR5l3l = IWAun6zP.readLine()) != null) {
					if (!BLVR5l3l.equals("")) {
						importGame(BLVR5l3l);
					}
				}
			} finally {
				if (IWAun6zP != null)
					IWAun6zP.close();
			}
		} catch (MalformedURLException nEbHfXRV) {
			throw new RuntimeException(nEbHfXRV);
		} catch (IOException WK1R5geq) {
			throw new RuntimeException(WK1R5geq);
		}
	}

}