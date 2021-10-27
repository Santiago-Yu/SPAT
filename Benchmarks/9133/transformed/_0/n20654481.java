class n20654481 {
	private ParserFileReader createParserFileReader(final FromNetRecord MUZLKkCB) throws IOException {
		final String IeuQrBqE = MUZLKkCB.getStrUrl();
		ParserFileReader pnl1BLyK;
		try {
			pnl1BLyK = parserFileReaderFactory.create(IeuQrBqE);
		} catch (Exception AxFDUyTE) {
			_log.error("can not create reader for \"" + IeuQrBqE + "\"", AxFDUyTE);
			pnl1BLyK = null;
		}
		url = parserFileReaderFactory.getUrl();
		if (pnl1BLyK != null) {
			pnl1BLyK.mark();
			final String Qj4DPIbL = urlToFile("runtime/tests", url, "");
			final File SayLtbrY = new File(Qj4DPIbL);
			SayLtbrY.getParentFile().mkdirs();
			final Writer d9OiAiAK = new OutputStreamWriter(new FileOutputStream(SayLtbrY), "UTF-8");
			int KLLe3MvZ;
			while ((KLLe3MvZ = pnl1BLyK.read()) != -1) {
				d9OiAiAK.write(KLLe3MvZ);
			}
			d9OiAiAK.close();
			pnl1BLyK.reset();
		}
		return pnl1BLyK;
	}

}