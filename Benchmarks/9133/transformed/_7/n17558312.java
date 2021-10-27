class n17558312 {
	public void fillData() {
		try {
			URL urlhome = OpenerIF.class.getResource("Home.html");
			URLConnection uc = urlhome.openConnection();
			InputStreamReader input = new InputStreamReader(uc.getInputStream());
			BufferedReader in = new BufferedReader(input);
			String inputLine;
			String htmlData = "";
			while ((inputLine = in.readLine()) != null) {
				htmlData = htmlData + (inputLine);
			}
			in.close();
			String[] str = new String[9];
			str[0] = getLibName();
			str[1] = getLoginId();
			str[2] = getLoginName();
			str[3] = getVerusSubscriptionIdHTML();
			str[4] = getPendingJobsHTMLCode();
			str[5] = getFrequentlyUsedScreensHTMLCode();
			str[6] = getOpenCatalogHTMLCode();
			str[7] = getNewsHTML();
			str[8] = getOnlineInformationHTML();
			MessageFormat mf = new MessageFormat(htmlData);
			String htmlContent = mf.format(htmlData, str);
			PrintWriter fw = new PrintWriter(System.getProperty("user.home") + "/homeNGL.html");
			fw.println(htmlContent);
			fw.flush();
			fw.close();
			new LocalHtmlRendererContext(panel, new SimpleUserAgentContext(), this)
					.navigate("file:" + System.getProperty("user.home") + "/homeNGL.html");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}