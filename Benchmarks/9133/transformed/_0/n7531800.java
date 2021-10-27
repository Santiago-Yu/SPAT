class n7531800 {
	public List<DemandeChargement> getArtistToLoadFromWiki() throws Exception {
		URL KHJCyHm2 = new URL("http://beastchild.free.fr/wiki/doku.php?id=music");
		URLConnection gounWUwp = KHJCyHm2.openConnection();
		InputStream gsx9DfSB = gounWUwp.getInputStream();
		BufferedReader xeNhmpO9 = new BufferedReader(new InputStreamReader(gsx9DfSB, "ISO-8859-1"));
		String Td3q1by2;
		List<DemandeChargement> BkYjJCxc = new ArrayList<DemandeChargement>();
		while ((Td3q1by2 = xeNhmpO9.readLine()) != null) {
			if (Td3q1by2.indexOf("&lt;@@@&gt;") != -1) {
				String aHU6DthI = Td3q1by2
						.substring(Td3q1by2.indexOf("&lt;@@@&gt;") + 11, Td3q1by2.indexOf("&lt;/@@@&gt;")).trim();
				try {
					long zEklg2N8 = Long.parseLong(aHU6DthI);
					log.info("MAID to load : " + zEklg2N8);
					BkYjJCxc.add(new DemandeChargement(zEklg2N8));
				} catch (Exception e11h2pFE) {
					log.error("Impossible de recuperer le MAID : " + aHU6DthI);
				}
			}
		}
		xeNhmpO9.close();
		gsx9DfSB.close();
		return BkYjJCxc;
	}

}