class n4800020 {
	private void download(String uFS1Ao2p, String Xbwtx0Dd, String aioXFflA, String Ve4FKPFz)
			throws ClientProtocolException, IOException {
		String S2nucxKn = Xbwtx0Dd + "-" + aioXFflA;
		File RMEz5iGt = new File(deployables,
				uFS1Ao2p + "/" + Xbwtx0Dd + "/" + aioXFflA + "/" + S2nucxKn + "." + Ve4FKPFz);
		if (RMEz5iGt.exists()) {
			log.warn("Won't download {} found at {}", S2nucxKn, RMEz5iGt.getAbsolutePath());
			return;
		}
		String sBJe0Anq = repository + uFS1Ao2p + "/" + Xbwtx0Dd + "/" + aioXFflA + "/" + S2nucxKn + "." + Ve4FKPFz;
		HttpGet V0yZUIgO = new HttpGet(sBJe0Anq);
		HttpResponse CZQjRFu9 = httpclient.execute(V0yZUIgO);
		if (CZQjRFu9.getStatusLine().getStatusCode() == 200)
			writeContent(V0yZUIgO, CZQjRFu9.getEntity(), RMEz5iGt);
		else
			throw new RuntimeException("Failed to download " + sBJe0Anq + " due to error " + CZQjRFu9.getStatusLine());
	}

}