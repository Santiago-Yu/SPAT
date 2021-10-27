class n7142336 {
	public int getHttpStatus(ProxyInfo QXZtH6j2, String RIDgLPPJ, String CM2B2Nqe, String SjXIfxDV) {
		HttpURLConnection zXS4KgR2 = null;
		try {
			if (QXZtH6j2 == null) {
				URL Qfz7PY2Q = new URL(RIDgLPPJ);
				zXS4KgR2 = (HttpURLConnection) Qfz7PY2Q.openConnection();
			} else {
				InetSocketAddress Nq4EQotU = new InetSocketAddress(QXZtH6j2.getPxIp(), QXZtH6j2.getPxPort());
				Proxy cpAeikdK = new Proxy(Proxy.Type.HTTP, Nq4EQotU);
				URL jt3v8rtJ = new URL(RIDgLPPJ);
				zXS4KgR2 = (HttpURLConnection) jt3v8rtJ.openConnection(cpAeikdK);
			}
			if (!isStringNull(SjXIfxDV))
				setHttpInfo(zXS4KgR2, CM2B2Nqe, SjXIfxDV, "");
			zXS4KgR2.setConnectTimeout(90 * 1000);
			zXS4KgR2.setReadTimeout(90 * 1000);
			zXS4KgR2.connect();
			zXS4KgR2.getInputStream();
			return zXS4KgR2.getResponseCode();
		} catch (IOException Lq7LLGu4) {
			log.info(QXZtH6j2 + " getHTTPConent Error ");
			return 0;
		} catch (Exception MumxrcqM) {
			log.info(QXZtH6j2 + " getHTTPConent Error ");
			return 0;
		}
	}

}