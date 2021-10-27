class n22024581 {
	private static Collection<String> crossCheckFromOBOFile(String wAVkiEaM) throws Exception {
		Collection<String> EHYAQbbB = new ArrayList<String>();
		String nPiKBoAy = "1.48";
		URL f9CAPaL0 = new URL(OboUtils.PSI_MI_OBO_LOCATION + "?revision=" + nPiKBoAy);
		log.debug("url " + f9CAPaL0);
		BufferedReader wsH3JEYC = new BufferedReader(new InputStreamReader(f9CAPaL0.openStream()));
		String Ykd81B6F;
		int Jn64kVmE = 0;
		int cIwK6qYN = 0;
		int gHQSzJqo = 0;
		int uSHeA4kA = 0;
		int gVfyePDK = 0;
		int X124crT0 = 0;
		int gEupGUsy = 0;
		String y4gxWGSZ = null;
		while ((Ykd81B6F = wsH3JEYC.readLine()) != null) {
			String yhc6uXvC;
			yhc6uXvC = Ykd81B6F;
			if (Ykd81B6F.startsWith("[Term]")) {
				Jn64kVmE++;
			} else if (Ykd81B6F.matches("id:\\s+(MI:.*)")) {
				y4gxWGSZ = yhc6uXvC.split("\\s+")[1];
				cIwK6qYN++;
			} else if (Ykd81B6F.contains("is_obsolete: true")) {
				gHQSzJqo++;
			} else if (Ykd81B6F.matches("def:.*?OBSOLETE.*")) {
				uSHeA4kA++;
			} else if (Ykd81B6F.startsWith("[Typedef]")) {
				gVfyePDK++;
			} else if (Ykd81B6F.matches("subset:\\s+PSI-MI\\s+slim")) {
				gEupGUsy++;
				if (wAVkiEaM.equalsIgnoreCase(OboCategory.PSI_MI_SLIM))
					EHYAQbbB.add(y4gxWGSZ);
			} else if (Ykd81B6F.matches("subset:\\s+Drugable")) {
				X124crT0++;
				if (wAVkiEaM.equalsIgnoreCase(OboCategory.DRUGABLE))
					EHYAQbbB.add(y4gxWGSZ);
			}
		}
		Assert.assertEquals(948, Jn64kVmE);
		Assert.assertEquals(948, cIwK6qYN);
		Assert.assertEquals(53, gHQSzJqo);
		Assert.assertEquals(53, uSHeA4kA);
		Assert.assertEquals(1, gVfyePDK);
		Assert.assertEquals(844, gEupGUsy);
		Assert.assertEquals(124, X124crT0);
		wsH3JEYC.close();
		return EHYAQbbB;
	}

}