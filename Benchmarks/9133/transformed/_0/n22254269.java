class n22254269 {
	@Override
	public String post(final FetchInfos Q5V9do7c, final String JXI0muoS) throws HttpException {
		URL td36OJaa = null;
		try {
			td36OJaa = new URL(Q5V9do7c.getUri());
		} catch (MalformedURLException izndJUzu) {
			throw new HttpException("uri is malformed '" + Q5V9do7c.getUri() + "'", izndJUzu);
		}
		HttpURLConnection tS5w3nf3 = null;
		try {
			tS5w3nf3 = (HttpURLConnection) td36OJaa.openConnection();
		} catch (IOException tezCzmZ1) {
			Q5V9do7c.setResult(FETCHING_RESULT.IO_ERROR);
			throw new HttpException("get '" + Q5V9do7c.getUri() + "' failed", tezCzmZ1);
		}
		InputStream aGseOYaM = null;
		try {
			tS5w3nf3.setRequestMethod("POST");
			tS5w3nf3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			tS5w3nf3.setRequestProperty("Content-Length", "" + Integer.toString(JXI0muoS.getBytes().length));
			final DataOutputStream EQxYArqW = new DataOutputStream(tS5w3nf3.getOutputStream());
			EQxYArqW.writeBytes(JXI0muoS);
			EQxYArqW.flush();
			EQxYArqW.close();
			aGseOYaM = tS5w3nf3.getInputStream();
			if ("gzip".equals(tS5w3nf3.getHeaderField("content-encoding"))) {
				aGseOYaM = new GZIPInputStream(aGseOYaM);
			}
			if (HttpServiceImpl.LOGGER.isDebugEnabled()) {
				this.logConnection(tS5w3nf3);
				aGseOYaM = new LoggingInputStream(aGseOYaM);
			}
		} catch (SocketTimeoutException hQl4n0i4) {
			Q5V9do7c.setResult(FETCHING_RESULT.TIME_OUT);
			throw new HttpException("get '" + Q5V9do7c.getUri() + "' timeout", hQl4n0i4);
		} catch (IOException f6fPvCdl) {
			Q5V9do7c.setResult(FETCHING_RESULT.IO_ERROR);
			throw new HttpException("get '" + Q5V9do7c.getUri() + "' failed", f6fPvCdl);
		}
		Q5V9do7c.setResult(FETCHING_RESULT.OK);
		String TCqz6307 = null;
		try {
			TCqz6307 = this.toString(aGseOYaM);
		} catch (IOException uOBcndCZ) {
			throw new HttpException("converting inputstream to string failed", uOBcndCZ);
		}
		return TCqz6307;
	}

}