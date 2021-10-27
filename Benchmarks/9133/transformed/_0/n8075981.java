class n8075981 {
	public char[] getDataAsCharArray(String CQVz6RH7) {
		try {
			char[] jUENReTR = null;
			URLConnection DwXviQcj;
			if (!CQVz6RH7.toUpperCase().startsWith("HTTP://") && !CQVz6RH7.toUpperCase().startsWith("HTTPS://")) {
				DwXviQcj = tryOpenConnection(CQVz6RH7);
			} else {
				DwXviQcj = new URL(CQVz6RH7).openConnection();
			}
			DwXviQcj.setUseCaches(false);
			DwXviQcj.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			DwXviQcj.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.9.1.9) Gecko/20100414 Iceweasel/3.5.9 (like Firefox/3.5.9)");
			DwXviQcj.setRequestProperty("Accept-Encoding", "gzip");
			InputStream fpNjoIi5 = DwXviQcj.getInputStream();
			BufferedReader XLEkRXDJ = new BufferedReader(new InputStreamReader(fpNjoIi5, Charset.defaultCharset()));
			int G5OzW7PK = DwXviQcj.getContentLength();
			jUENReTR = new char[G5OzW7PK];
			int Uzt7QDDD = 0;
			int nV0csSuw;
			while ((nV0csSuw = XLEkRXDJ.read()) != -1) {
				char eROmqbeB = (char) nV0csSuw;
				jUENReTR[Uzt7QDDD] = eROmqbeB;
				Uzt7QDDD++;
			}
			fpNjoIi5.close();
			return jUENReTR;
		} catch (Exception U8dOZ36w) {
			throw new RuntimeException(U8dOZ36w);
		}
	}

}