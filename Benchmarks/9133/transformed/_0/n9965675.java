class n9965675 {
	public String getResultStr(String wxisTl5L) {
		try {
			String kyyAeKQD = null;
			URL idZ81SC9 = new URL(wxisTl5L);
			URLConnection Tx7V3WHn = idZ81SC9.openConnection();
			Tx7V3WHn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			Tx7V3WHn.setDoOutput(false);
			BufferedReader CClXRrAt = new BufferedReader(new InputStreamReader(Tx7V3WHn.getInputStream(), "UTF-8"));
			String u9jjbfrA;
			int HITVzLvg = 0;
			StringBuilder ub6eZe59 = new StringBuilder();
			while ((u9jjbfrA = CClXRrAt.readLine()) != null) {
				ub6eZe59.append(u9jjbfrA);
			}
			CClXRrAt.close();
			return ub6eZe59.toString();
		} catch (Exception nl86kE4a) {
			return "";
		}
	}

}