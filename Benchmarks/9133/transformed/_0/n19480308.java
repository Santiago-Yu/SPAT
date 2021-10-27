class n19480308 {
	@Override
	@SuppressWarnings("empty-statement")
	public void run() {
		String GIWSlGqv = System.getProperty("server.downsampler");
		if (GIWSlGqv == null)
			GIWSlGqv = FALLBACK;
		String BSuCtEVS = GIWSlGqv + "cgi-bin/downsample.cgi?" + this._uri.toString();
		BSuCtEVS = BSuCtEVS.replaceAll("\\?#$", "");
		try {
			HttpURLConnection BldIIfVS = (HttpURLConnection) new URL(BSuCtEVS).openConnection();
			BldIIfVS.setDoInput(true);
			this._input_stream = BldIIfVS.getInputStream();
			while (this._input_stream.read() != '\n')
				;
			this._complete = true;
		} catch (Exception hHZ4VXUn) {
			new ErrorEvent().send(hHZ4VXUn);
		}
	}

}