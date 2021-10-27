class n14053971 {
	private static String fetchUrl(String TUHd4Qdf, boolean zr9cIrQS) throws IOException, MalformedURLException {
		URLConnection QZxOJu3p = (new URL(TUHd4Qdf)).openConnection();
		BufferedReader vrY04a7i;
		String en3xjf7V;
		StringBuffer aY60aHLC = new StringBuffer();
		String PwYOVrcU;
		QZxOJu3p.setRequestProperty("Accept-Encoding", "gzip");
		if (proxyAuth != null)
			QZxOJu3p.setRequestProperty("Proxy-Authorization", proxyAuth);
		QZxOJu3p.connect();
		PwYOVrcU = QZxOJu3p.getContentEncoding();
		if ((PwYOVrcU != null) && PwYOVrcU.equals("gzip")) {
			vrY04a7i = new BufferedReader(new InputStreamReader(new GZIPInputStream(QZxOJu3p.getInputStream())));
		} else {
			vrY04a7i = new BufferedReader(new InputStreamReader(QZxOJu3p.getInputStream()));
		}
		while ((en3xjf7V = vrY04a7i.readLine()) != null) {
			if (zr9cIrQS)
				aY60aHLC.append(en3xjf7V + "\n");
			else
				aY60aHLC.append(en3xjf7V);
		}
		vrY04a7i.close();
		return aY60aHLC.toString();
	}

}