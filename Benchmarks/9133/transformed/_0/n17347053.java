class n17347053 {
	@Override
	public HttpResponse makeRequest() throws RequestCancelledException, IllegalStateException, IOException {
		checkState();
		OutputStream ZEAhmYWg = null;
		InputStream sbMXGKft = null;
		try {
			ZEAhmYWg = new BufferedOutputStream(new FileOutputStream(destFile));
			URLConnection bf43v1OQ = url.openConnection();
			sbMXGKft = bf43v1OQ.getInputStream();
			byte[] Z6Lzgwja = new byte[BUFFRE_SIZE];
			int lz0Qjff1;
			long KGYAfcze = bf43v1OQ.getContentLength();
			long dWTAjtn8 = 0;
			started(KGYAfcze);
			while (!checkAbortFlag() && (lz0Qjff1 = sbMXGKft.read(Z6Lzgwja)) != -1) {
				ZEAhmYWg.write(Z6Lzgwja, 0, lz0Qjff1);
				ZEAhmYWg.flush();
				dWTAjtn8 += lz0Qjff1;
				progress(dWTAjtn8);
			}
			if (checkAbortFlag()) {
				cancelled();
			} else {
				finished();
			}
			if (checkAbortFlag()) {
				throw new RequestCancelledException();
			}
		} finally {
			if (ZEAhmYWg != null) {
				ZEAhmYWg.close();
			}
			if (sbMXGKft != null) {
				sbMXGKft.close();
			}
		}
		return null;
	}

}