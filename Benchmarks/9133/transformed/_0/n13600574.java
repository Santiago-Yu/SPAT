class n13600574 {
	public String getWeather(String HGAY4ptQ, String FZOEHisQ) {
		try {
			URL ClcyU72c = new URL("http://www.google.com/ig/api?hl=zh_cn&weather=" + HGAY4ptQ);
			InputStream nf3qAMJ3 = ClcyU72c.openStream();
			String KoYgoCA6, lrDmhBmG;
			BufferedReader Jod7TfPq = new BufferedReader(new InputStreamReader(nf3qAMJ3));
			StringBuffer c0OQ4IbM = new StringBuffer();
			Writer RX89I9XW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FZOEHisQ), "utf-8"));
			while ((KoYgoCA6 = Jod7TfPq.readLine()) != null) {
				c0OQ4IbM.append(KoYgoCA6);
			}
			lrDmhBmG = new String(c0OQ4IbM);
			RX89I9XW.write(lrDmhBmG);
			RX89I9XW.close();
			Jod7TfPq.close();
		} catch (IOException IlSiX4RW) {
			IlSiX4RW.printStackTrace();
		}
		File mJA751zC = new File(FZOEHisQ);
		DocumentBuilderFactory IzKoFNOa = DocumentBuilderFactory.newInstance();
		String o6FuoigW = null;
		try {
			DocumentBuilder ufKxQJ4C = IzKoFNOa.newDocumentBuilder();
			Document Y18Cnb3i = ufKxQJ4C.parse(mJA751zC);
			NodeList vPXrdeUq = (NodeList) Y18Cnb3i.getElementsByTagName("forecast_conditions");
			NodeList aCpLlnfs = vPXrdeUq.item(0).getChildNodes();
			o6FuoigW = aCpLlnfs.item(4).getAttributes().item(0).getNodeValue() + ",temperature:"
					+ aCpLlnfs.item(1).getAttributes().item(0).getNodeValue() + "¡æ-"
					+ aCpLlnfs.item(2).getAttributes().item(0).getNodeValue() + "¡æ";
		} catch (Exception w5smQoQd) {
			w5smQoQd.printStackTrace();
		}
		return o6FuoigW;
	}

}