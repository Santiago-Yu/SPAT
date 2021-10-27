class n8075981 {
	public char[] getDataAsCharArray(String url) {
		try {
			char[] dat = null;
			URLConnection urlc;
			urlc = (!url.toUpperCase().startsWith("HTTP://") && !url.toUpperCase().startsWith("HTTPS://"))
					? tryOpenConnection(url)
					: new URL(url).openConnection();
			urlc.setUseCaches(false);
			urlc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlc.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.9.1.9) Gecko/20100414 Iceweasel/3.5.9 (like Firefox/3.5.9)");
			urlc.setRequestProperty("Accept-Encoding", "gzip");
			InputStream is = urlc.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.defaultCharset()));
			int len = urlc.getContentLength();
			dat = new char[len];
			int i = 0;
			int c;
			while ((c = reader.read()) != -1) {
				char character = (char) c;
				dat[i] = character;
				i++;
			}
			is.close();
			return dat;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}