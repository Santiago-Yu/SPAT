class n5339736 {
	public static String translate(String kis6Onwv) {
		try {
			String vh7hkHl0 = null;
			URL X8OgvnHA = new URL("http://translate.google.com/translate_t");
			URLConnection qVMoO2Xb = X8OgvnHA.openConnection();
			qVMoO2Xb.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			qVMoO2Xb.setDoOutput(true);
			PrintWriter UqYxNRQR = new PrintWriter(qVMoO2Xb.getOutputStream());
			UqYxNRQR.print("text=" + URLEncoder.encode(kis6Onwv, "UTF-8") + "&langpair=");
			if (kis6Onwv.matches("[\\u0000-\\u00ff]+")) {
				UqYxNRQR.print("en|ja");
			} else {
				UqYxNRQR.print("ja|en");
			}
			UqYxNRQR.print("&hl=en&ie=UTF-8&oe=UTF-8");
			UqYxNRQR.close();
			BufferedReader ibRLUBEM = new BufferedReader(new InputStreamReader(qVMoO2Xb.getInputStream(), "UTF-8"));
			String CRi1MirO;
			while ((CRi1MirO = ibRLUBEM.readLine()) != null) {
				int yvPChxMS = CRi1MirO.indexOf("id=result_box");
				if (yvPChxMS >= 0) {
					int riWmgaMr = CRi1MirO.indexOf("dir=ltr", yvPChxMS + 9);
					if (riWmgaMr >= 0) {
						int R7c3Fhns = CRi1MirO.indexOf("<", riWmgaMr + 8);
						if (R7c3Fhns >= 0) {
							vh7hkHl0 = CRi1MirO.substring(riWmgaMr + 8, R7c3Fhns);
						}
					}
				}
			}
			ibRLUBEM.close();
			return vh7hkHl0;
		} catch (Exception BWyMWEE9) {
			BWyMWEE9.printStackTrace();
		}
		return null;
	}

}