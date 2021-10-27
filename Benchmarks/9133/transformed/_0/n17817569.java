class n17817569 {
	public String getFeatureInfoHTML(Point3d wNjm1Aup, String[] M02BIc6J, int OMvlUIjp) {
		String oW3jLqBL = "";
		try {
			String EpK1Jskt = null;
			if (version == VERSION_030) {
				org.gdi3d.xnavi.services.w3ds.x030.GetFeatureInfo T5KvzIwW = new org.gdi3d.xnavi.services.w3ds.x030.GetFeatureInfo(
						this.serviceEndPoint);
				EpK1Jskt = T5KvzIwW.createRequest(wNjm1Aup, M02BIc6J, OMvlUIjp);
			} else if (version == VERSION_040) {
				org.gdi3d.xnavi.services.w3ds.x040.GetFeatureInfo cpcqqfw1 = new org.gdi3d.xnavi.services.w3ds.x040.GetFeatureInfo(
						this.serviceEndPoint);
				EpK1Jskt = cpcqqfw1.createRequest(wNjm1Aup, M02BIc6J, OMvlUIjp);
			} else if (version == VERSION_041) {
				org.gdi3d.xnavi.services.w3ds.x041.GetFeatureInfo bnIPSkQ5 = new org.gdi3d.xnavi.services.w3ds.x041.GetFeatureInfo(
						this.serviceEndPoint);
				EpK1Jskt = bnIPSkQ5.createRequest(wNjm1Aup, M02BIc6J, OMvlUIjp);
			}
			if (Navigator.isVerbose())
				System.out.println(EpK1Jskt);
			URL iojvzwFT = new URL(EpK1Jskt);
			int MyiVAzJE = -1;
			URLConnection fyJ1YC3Y;
			fyJ1YC3Y = iojvzwFT.openConnection();
			fyJ1YC3Y.setReadTimeout(Navigator.TIME_OUT);
			if (getEncoding() != null) {
				fyJ1YC3Y.setRequestProperty("Authorization", "Basic " + getEncoding());
			}
			fyJ1YC3Y.connect();
			String AfUTJ0aE = fyJ1YC3Y.getContentType();
			if (AfUTJ0aE.equalsIgnoreCase("text/html") || AfUTJ0aE.equalsIgnoreCase("text/html;charset=UTF-8")) {
				InputStream EK7yNaaH = fyJ1YC3Y.getInputStream();
				BufferedInputStream F97t6PYD = new BufferedInputStream(EK7yNaaH);
				StringBuffer s6qmHp6t = new StringBuffer();
				InputStreamReader JuiM8zBG = new InputStreamReader(F97t6PYD);
				char iTsEOxzx[] = new char[10240];
				int wZgIQWDv = 0;
				MyiVAzJE = 0;
				while ((wZgIQWDv = JuiM8zBG.read(iTsEOxzx, 0, iTsEOxzx.length)) >= 0) {
					s6qmHp6t.append(iTsEOxzx, 0, wZgIQWDv);
					MyiVAzJE += wZgIQWDv;
				}
				iTsEOxzx = null;
				JuiM8zBG.close();
				F97t6PYD.close();
				EK7yNaaH.close();
				oW3jLqBL = s6qmHp6t.toString();
			}
		} catch (Exception t5CBZBsf) {
			t5CBZBsf.printStackTrace();
		}
		return oW3jLqBL;
	}

}