class n2390396 {
	@Override
	protected void processImport() throws SudokuInvalidFormatException {
		importFolder(mUri.getLastPathSegment());
		try {
			URL url = new URL(mUri.toString());
			BufferedReader br = null;
			InputStreamReader isr = new InputStreamReader(url.openStream());
			try {
				String s;
				br = new BufferedReader(isr);
				while ((s = br.readLine()) != null) {
					if (!s.equals("")) {
						importGame(s);
					}
				}
			} finally {
				if (br != null)
					br.close();
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}