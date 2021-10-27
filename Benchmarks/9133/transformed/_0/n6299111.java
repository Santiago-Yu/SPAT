class n6299111 {
	public static String retrieveQ(String J8Z2MpMl) throws MalformedURLException, IOException {
		URL rZaphlVE = new URL(J8Z2MpMl);
		URLConnection pe0zzlLk = rZaphlVE.openConnection();
		InputStream nZ3yA7P3 = pe0zzlLk.getInputStream();
		BufferedReader pstCW9Hm = new BufferedReader(new InputStreamReader(nZ3yA7P3));
		StringBuilder NddK5QUZ = new StringBuilder(16384);
		String PBHUVnlk;
		boolean fQdjl2FN = true;
		while ((PBHUVnlk = pstCW9Hm.readLine()) != null) {
			if (!fQdjl2FN)
				NddK5QUZ.append("\n");
			fQdjl2FN = false;
			NddK5QUZ.append(PBHUVnlk);
		}
		pstCW9Hm.close();
		System.err.println(((HttpURLConnection) pe0zzlLk).getResponseMessage());
		return NddK5QUZ.toString();
	}

}