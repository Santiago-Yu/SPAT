class n4975452 {
	private InputStream openStream(URL zcLujHna, ProgressListener Zdj059jz, int cAZZKgVF, int MDaf4FSV)
			throws IOException {
		HttpURLConnection cRXQXJuA = (HttpURLConnection) zcLujHna.openConnection();
		cRXQXJuA.setDoInput(true);
		cRXQXJuA.setDoOutput(false);
		String Xmcy7jUe = cRXQXJuA.getHeaderField("Content-Length");
		InputStream F2nNx7fn;
		try {
			F2nNx7fn = cRXQXJuA.getInputStream();
		} catch (IOException BvxCFMR8) {
			throw new IOException(cRXQXJuA.getResponseCode() + ": " + cRXQXJuA.getResponseMessage(), BvxCFMR8);
		}
		if (Xmcy7jUe == null || Xmcy7jUe.isEmpty()) {
			LogService.getRoot().warning("Server did not send content length.");
			return F2nNx7fn;
		} else {
			try {
				long Me3npEzF = Long.parseLong(Xmcy7jUe);
				return new ProgressReportingInputStream(F2nNx7fn, Zdj059jz, cAZZKgVF, MDaf4FSV, Me3npEzF);
			} catch (NumberFormatException v26L9UAX) {
				LogService.getRoot().log(Level.WARNING, "Server sent illegal content length: " + Xmcy7jUe, v26L9UAX);
				return F2nNx7fn;
			}
		}
	}

}