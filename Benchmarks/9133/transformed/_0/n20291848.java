class n20291848 {
	public void run() {
		if (!shouldLogin) {
			u.p("skipping the auto-login");
			return;
		}
		try {
			u.p("logging in to the server");
			String gggGimgk = "hostname=blahfoo2.com" + "&osname="
					+ URLEncoder.encode(System.getProperty("os.name"), "UTF-8") + "&javaver="
					+ URLEncoder.encode(System.getProperty("java.runtime.version"), "UTF-8") + "&timezone="
					+ URLEncoder.encode(TimeZone.getDefault().getID(), "UTF-8");
			u.p("unencoded query: \n" + gggGimgk);
			String VqQ2eiS7 = "http://joshy.org:8088/org.glossitopeTracker/login.jsp?";
			String GEn2WFN5 = VqQ2eiS7 + gggGimgk;
			u.p("final encoded url = \n" + GEn2WFN5);
			InputStream z9h4OV9g = new URL(GEn2WFN5).openStream();
			byte[] IYHNL3DA = new byte[256];
			while (true) {
				int nyFBepU8 = z9h4OV9g.read(IYHNL3DA);
				if (nyFBepU8 == -1)
					break;
				for (int PV2IIJUp = 0; PV2IIJUp < nyFBepU8; PV2IIJUp++) {
				}
			}
		} catch (MalformedURLException YATmf3qB) {
			YATmf3qB.printStackTrace();
		} catch (IOException h8GWIFrV) {
			h8GWIFrV.printStackTrace();
		}
	}

}