class n8122281 {
	public String get(String Lsnzguij, String bNDzM59l) throws Exception {
		if (!Lsnzguij.startsWith("http"))
			return "";
		StringBuilder wzkgBWAf = new StringBuilder();
		try {
			String TKPGoTR6 = null;
			URL b8O9fS8z = new URL(Lsnzguij);
			URLConnection vwgzglKS = b8O9fS8z.openConnection();
			vwgzglKS.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			vwgzglKS.setDoOutput(false);
			if (bNDzM59l == null)
				bNDzM59l = "UTF-8";
			BufferedReader Lff4q57U = new BufferedReader(new InputStreamReader(vwgzglKS.getInputStream(), bNDzM59l));
			String wHTtLjCd;
			String kOhe1Bb9 = vwgzglKS.getContentType();
			if (kOhe1Bb9.startsWith("text") || kOhe1Bb9.startsWith("application/xml")) {
				while ((wHTtLjCd = Lff4q57U.readLine()) != null) {
					wzkgBWAf.append(wHTtLjCd);
					wzkgBWAf.append("\n");
				}
			}
			Lff4q57U.close();
		} catch (Exception mYN1VoTm) {
			mYN1VoTm.printStackTrace();
			throw mYN1VoTm;
		}
		return wzkgBWAf.toString();
	}

}