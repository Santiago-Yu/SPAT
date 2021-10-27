class n11467950 {
	public String getMediaURL(String KiMIXWe7) {
		try {
			String yM1jPsss = de.nomule.mediaproviders.KeepVid.getAnswer(KiMIXWe7, "aa");
			if (NoMuleRuntime.DEBUG)
				System.out.println(yM1jPsss);
			String p1jhuqQN = "http:\\/\\/[^\"]+\\/get_video[^\"]+";
			Pattern FUrxBX5m = Pattern.compile(p1jhuqQN);
			Matcher C9liji40 = FUrxBX5m.matcher(yM1jPsss);
			C9liji40.find();
			String KULZbPUl = yM1jPsss.substring(C9liji40.start(), C9liji40.end());
			KULZbPUl = URLDecoder.decode(KULZbPUl, "UTF-8");
			if (TRY_HIGH_QUALITY) {
				NoMuleRuntime.showDebug("HIGH_QUALITY");
				KULZbPUl += "&fmt=18";
				try {
					URL nldhoEud = new URL(KULZbPUl);
					URLConnection LLBWHjMF = nldhoEud.openConnection();
					InputStream RYKuCSif = LLBWHjMF.getInputStream();
					RYKuCSif.close();
				} catch (MalformedURLException kyZ6pHQ0) {
					kyZ6pHQ0.printStackTrace();
				} catch (IOException gpMqdsKK) {
					KULZbPUl = KULZbPUl.substring(0, KULZbPUl.length() - 7);
				}
			}
			if (NoMuleRuntime.DEBUG)
				System.out.println(KULZbPUl);
			return KULZbPUl;
		} catch (UnsupportedEncodingException fFnDPPnn) {
			System.out.println("Error in Youtube Media Provider. Encoding is not supported. (How would that happen?!)");
			fFnDPPnn.printStackTrace();
		}
		return "";
	}

}