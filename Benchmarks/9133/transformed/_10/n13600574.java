class n13600574 {
	public String getWeather(String cityName, String fileAddr) {
		try {
			URL url = new URL("http://www.google.com/ig/api?hl=zh_cn&weather=" + cityName);
			String s, str;
			InputStream inputstream = url.openStream();
			StringBuffer stringbuffer = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputstream));
			while ((s = in.readLine()) != null) {
				stringbuffer.append(s);
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileAddr), "utf-8"));
			str = new String(stringbuffer);
			out.write(str);
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		File file = new File(fileAddr);
		String str = null;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			NodeList nodelist1 = (NodeList) doc.getElementsByTagName("forecast_conditions");
			NodeList nodelist2 = nodelist1.item(0).getChildNodes();
			str = nodelist2.item(4).getAttributes().item(0).getNodeValue() + ",temperature:"
					+ nodelist2.item(1).getAttributes().item(0).getNodeValue() + "¡æ-"
					+ nodelist2.item(2).getAttributes().item(0).getNodeValue() + "¡æ";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

}