class n8515614 {
	private ResponseStatus performHandshake(String L6Rz6kus) throws IOException {
		HttpURLConnection u07Hav2C = Caller.getInstance().openConnection(L6Rz6kus);
		InputStream VoWiuuLs = u07Hav2C.getInputStream();
		BufferedReader EJsOrZuy = new BufferedReader(new InputStreamReader(VoWiuuLs));
		String qIXD2Qr4 = EJsOrZuy.readLine();
		int GdPG5S43 = ResponseStatus.codeForStatus(qIXD2Qr4);
		ResponseStatus Mj1o9qDs;
		if (GdPG5S43 == ResponseStatus.OK) {
			this.sessionId = EJsOrZuy.readLine();
			this.nowPlayingUrl = EJsOrZuy.readLine();
			this.submissionUrl = EJsOrZuy.readLine();
			Mj1o9qDs = new ResponseStatus(GdPG5S43);
		} else if (GdPG5S43 == ResponseStatus.FAILED) {
			Mj1o9qDs = new ResponseStatus(GdPG5S43, qIXD2Qr4.substring(qIXD2Qr4.indexOf(' ') + 1));
		} else {
			return new ResponseStatus(GdPG5S43);
		}
		EJsOrZuy.close();
		return Mj1o9qDs;
	}

}