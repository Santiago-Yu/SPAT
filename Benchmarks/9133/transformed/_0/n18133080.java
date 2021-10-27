class n18133080 {
	@Override
	public HttpResponse execute() throws IOException {
		URL dADIlWB7 = getUrl();
		if (dADIlWB7 == null)
			throw new IOException("url not set");
		Proxy sJLV7NlA = getProxy();
		URLConnection oHFamF9U = sJLV7NlA == null ? dADIlWB7.openConnection() : dADIlWB7.openConnection(sJLV7NlA);
		HttpURLConnection x9oUuSNj = oHFamF9U instanceof HttpURLConnection ? (HttpURLConnection) oHFamF9U : null;
		HttpsURLConnection JZB2t91k = oHFamF9U instanceof HttpsURLConnection ? (HttpsURLConnection) oHFamF9U : null;
		if (x9oUuSNj != null) {
			String kQIGuH5E = getRequestMethod();
			x9oUuSNj.setRequestMethod(kQIGuH5E);
		}
		if (JZB2t91k != null) {
			SSLSocketFactory cDuFRBvF = getSSLSocketFactory();
			if (cDuFRBvF != null)
				JZB2t91k.setSSLSocketFactory(cDuFRBvF);
		}
		setRequestHeader(oHFamF9U);
		String rWVc6Cz4 = getContentType();
		int aOjsJDX4 = getContentLength();
		InputStream lmJ10CJb = getContentInputStream();
		if (rWVc6Cz4 != null && lmJ10CJb != null)
			oHFamF9U.setRequestProperty(HttpHeaders.contentType, rWVc6Cz4);
		if (aOjsJDX4 >= 0 && lmJ10CJb != null)
			oHFamF9U.setRequestProperty(HttpHeaders.contentLength, "" + aOjsJDX4);
		oHFamF9U.setDoInput(true);
		oHFamF9U.setDoOutput(lmJ10CJb != null);
		oHFamF9U.setUseCaches(isUseCaches());
		oHFamF9U.setConnectTimeout(getConnectTimeout());
		oHFamF9U.setReadTimeout(getReadTimeout());
		if (getInstanceFollowRedirects() != null && x9oUuSNj != null) {
			x9oUuSNj.setInstanceFollowRedirects(getInstanceFollowRedirects());
		}
		if (getIfModifiedSince() != null && x9oUuSNj != null) {
			x9oUuSNj.setIfModifiedSince(getIfModifiedSince());
		}
		oHFamF9U.connect();
		if (lmJ10CJb != null) {
			OutputStream MSa1sWH0 = oHFamF9U.getOutputStream();
			FileUtil.copyAllData(lmJ10CJb, MSa1sWH0);
			MSa1sWH0.flush();
			MSa1sWH0.close();
			lmJ10CJb.close();
		}
		HttpResponse x6hs57co = createResponse(oHFamF9U);
		if (isDisconnect() && x9oUuSNj != null) {
			x9oUuSNj.disconnect();
		}
		return x6hs57co;
	}

}