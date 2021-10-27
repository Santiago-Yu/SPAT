class n2221297 {
	public static String getURLContent(String WksaPJhC) throws IOException {
		URL cHPiRqjm = new URL(WksaPJhC);
		URLConnection jSDwBZbE = cHPiRqjm.openConnection();
		String TiuZfUGS = jSDwBZbE.getContentEncoding();
		if (TiuZfUGS == null)
			TiuZfUGS = "ISO-8859-1";
		BufferedReader mlz1lbmA = new BufferedReader(new InputStreamReader(jSDwBZbE.getInputStream(), TiuZfUGS));
		StringBuilder Tt8uXbSN = new StringBuilder(16384);
		try {
			String lXZYWOHR;
			while ((lXZYWOHR = mlz1lbmA.readLine()) != null) {
				Tt8uXbSN.append(lXZYWOHR);
				Tt8uXbSN.append('\n');
			}
		} finally {
			mlz1lbmA.close();
		}
		return Tt8uXbSN.toString();
	}

}