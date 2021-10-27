class n17558353 {
	@Override
	public void run() {
		try {
			URL cVLsPPgx = new URL("http://www.verussolutions.biz/NGLDashBoard.xml");
			URLConnection pHQQZzsH = cVLsPPgx.openConnection();
			InputStreamReader YBH4uBbD = new InputStreamReader(pHQQZzsH.getInputStream());
			BufferedReader hNs5Tjxm = new BufferedReader(YBH4uBbD);
			String MRAkOJKb;
			String j9fMVn5M = "";
			while ((MRAkOJKb = hNs5Tjxm.readLine()) != null) {
				j9fMVn5M += MRAkOJKb;
			}
			hNs5Tjxm.close();
			PrintWriter cezs72z7 = new PrintWriter(
					new FileWriter(System.getProperty("user.home") + "/NGLDashBoard.xml"));
			cezs72z7.println(j9fMVn5M);
			cezs72z7.flush();
			cezs72z7.close();
		} catch (Exception Fvv9S5KV) {
			Fvv9S5KV.printStackTrace();
		}
		try {
			Document oBDj6EAA = new SAXBuilder().build(new File(System.getProperty("user.home") + "/NGLDashBoard.xml"));
			String JZ57SlVm = oBDj6EAA.getRootElement().getChild("OnlineSupportInformation").getText();
			CDATA Yej8SHTb = new CDATA(JZ57SlVm);
			host.setOnlineInformationHTML(Yej8SHTb.getText());
			JZ57SlVm = oBDj6EAA.getRootElement().getChild("News").getText();
			Yej8SHTb = new CDATA(JZ57SlVm);
			host.setNewsHTML(Yej8SHTb.getText());
			host.fillData();
		} catch (Exception t2V2Tsch) {
			t2V2Tsch.printStackTrace();
		}
	}

}