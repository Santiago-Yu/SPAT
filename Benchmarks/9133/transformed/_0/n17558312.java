class n17558312 {
	public void fillData() {
		try {
			URL ipX4fWUA = OpenerIF.class.getResource("Home.html");
			URLConnection Ajp2QUDe = ipX4fWUA.openConnection();
			InputStreamReader S6B5SOqd = new InputStreamReader(Ajp2QUDe.getInputStream());
			BufferedReader zdrmcD03 = new BufferedReader(S6B5SOqd);
			String xQJJ9Eea;
			String sjL2u0xo = "";
			while ((xQJJ9Eea = zdrmcD03.readLine()) != null) {
				sjL2u0xo += xQJJ9Eea;
			}
			zdrmcD03.close();
			String[] RGGlCrL0 = new String[9];
			RGGlCrL0[0] = getLibName();
			RGGlCrL0[1] = getLoginId();
			RGGlCrL0[2] = getLoginName();
			RGGlCrL0[3] = getVerusSubscriptionIdHTML();
			RGGlCrL0[4] = getPendingJobsHTMLCode();
			RGGlCrL0[5] = getFrequentlyUsedScreensHTMLCode();
			RGGlCrL0[6] = getOpenCatalogHTMLCode();
			RGGlCrL0[7] = getNewsHTML();
			RGGlCrL0[8] = getOnlineInformationHTML();
			MessageFormat R8ZyAanl = new MessageFormat(sjL2u0xo);
			String rm3JUlpb = R8ZyAanl.format(sjL2u0xo, RGGlCrL0);
			PrintWriter lKNl2oa4 = new PrintWriter(System.getProperty("user.home") + "/homeNGL.html");
			lKNl2oa4.println(rm3JUlpb);
			lKNl2oa4.flush();
			lKNl2oa4.close();
			new LocalHtmlRendererContext(panel, new SimpleUserAgentContext(), this)
					.navigate("file:" + System.getProperty("user.home") + "/homeNGL.html");
		} catch (Exception MOV22tUW) {
			MOV22tUW.printStackTrace();
		}
	}

}