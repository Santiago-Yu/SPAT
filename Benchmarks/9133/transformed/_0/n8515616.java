class n8515616 {
	public ResponseStatus nowPlaying(String fI0Ptnda, String DvcpvsSB, String JU7d9KOg, int bJsNy5ZU, int MmWFtxvn)
			throws IOException {
		if (sessionId == null)
			throw new IllegalStateException("Perform successful handshake first.");
		String iT69AGX4 = JU7d9KOg != null ? encode(JU7d9KOg) : "";
		String FyTScpF5 = bJsNy5ZU == -1 ? "" : String.valueOf(bJsNy5ZU);
		String AvNXqVEz = MmWFtxvn == -1 ? "" : String.valueOf(MmWFtxvn);
		String l7eIifD9 = String.format("s=%s&a=%s&t=%s&b=%s&l=%s&n=%s&m=", sessionId, encode(fI0Ptnda),
				encode(DvcpvsSB), iT69AGX4, FyTScpF5, AvNXqVEz);
		if (Caller.getInstance().isDebugMode())
			System.out.println("now playing: " + l7eIifD9);
		Proxy Q8j2Cl8w = Caller.getInstance().getProxy();
		HttpURLConnection tkhZCEVf = Caller.getInstance().openConnection(nowPlayingUrl);
		tkhZCEVf.setRequestMethod("POST");
		tkhZCEVf.setDoOutput(true);
		OutputStream C7fPPlrL = tkhZCEVf.getOutputStream();
		BufferedWriter NBxqUMve = new BufferedWriter(new OutputStreamWriter(C7fPPlrL));
		NBxqUMve.write(l7eIifD9);
		NBxqUMve.close();
		InputStream wznCwJFh = tkhZCEVf.getInputStream();
		BufferedReader YZF3nZyB = new BufferedReader(new InputStreamReader(wznCwJFh));
		String EJbI12is = YZF3nZyB.readLine();
		YZF3nZyB.close();
		return new ResponseStatus(ResponseStatus.codeForStatus(EJbI12is));
	}

}