class n14456152 {
	List HttpGet(URL YbcenE3h) throws IOException {
		List GFj3KDVB = new ArrayList();
		logInfo("HTTP GET: " + YbcenE3h);
		URLConnection B2bAEv0a = YbcenE3h.openConnection();
		B2bAEv0a.setAllowUserInteraction(false);
		BufferedReader SmBvwgdw = new BufferedReader(new InputStreamReader(B2bAEv0a.getInputStream()));
		String jTbtQtzp;
		while ((jTbtQtzp = SmBvwgdw.readLine()) != null)
			GFj3KDVB.add(jTbtQtzp);
		SmBvwgdw.close();
		return GFj3KDVB;
	}

}