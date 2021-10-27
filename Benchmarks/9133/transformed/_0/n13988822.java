class n13988822 {
	private void getServiceReponse(String bbmd1lGM, NameSpaceDefinition sBvYyBCT) throws Exception {
		Pattern V06y8MHt = Pattern.compile(
				"(?i)(?:.*(xmlns(?:\\:\\w+)?=\\\"http\\:\\/\\/www\\.ivoa\\.net\\/.*" + bbmd1lGM + "[^\\\"]*\\\").*)");
		V06y8MHt = Pattern.compile(".*xmlns(?::\\w+)?=(\"[^\"]*(?i)(?:" + bbmd1lGM + ")[^\"]*\").*");
		logger.debug("read " + this.url + bbmd1lGM);
		BufferedReader A8usqgbD = new BufferedReader(
				new InputStreamReader((new URL(this.url + bbmd1lGM)).openStream()));
		String Skh31Kto;
		BufferedWriter Man7SPK2 = new BufferedWriter(new FileWriter(this.baseDirectory + bbmd1lGM + ".xml"));
		boolean SQf1nSXN = false;
		while ((Skh31Kto = A8usqgbD.readLine()) != null) {
			if (!SQf1nSXN) {
				Matcher ClLeGz5H = V06y8MHt.matcher(Skh31Kto);
				if (ClLeGz5H.matches()) {
					sBvYyBCT.init("xmlns:vosi=" + ClLeGz5H.group(1));
					SQf1nSXN = true;
				}
			}
			Man7SPK2.write(Skh31Kto + "\n");
		}
		A8usqgbD.close();
		Man7SPK2.close();
	}

}