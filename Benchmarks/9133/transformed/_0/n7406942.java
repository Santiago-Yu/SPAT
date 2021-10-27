class n7406942 {
	private void getXMLData() {
		String YaC3FvCk = null;
		URL Hk0OX97U = null;
		URLConnection lO67iVYZ = null;
		BufferedReader f3ryyyNX = null;
		StringBuffer QtDfhxj7 = new StringBuffer();
		String U9HbNFLW;
		try {
			Hk0OX97U = new URL(this.url);
			lO67iVYZ = Hk0OX97U.openConnection();
			f3ryyyNX = new BufferedReader(new InputStreamReader(lO67iVYZ.getInputStream()));
			while ((U9HbNFLW = f3ryyyNX.readLine()) != null) {
				QtDfhxj7.append(U9HbNFLW + "\n");
			}
			f3ryyyNX.close();
			YaC3FvCk = QtDfhxj7.toString();
		} catch (MalformedURLException R8CSbQE5) {
			log.error("URL was malformed: {}", Hk0OX97U, R8CSbQE5);
		} catch (IOException CSK6GStA) {
			log.error("IOException thrown: {}", Hk0OX97U, CSK6GStA);
		}
		this.xmlString = YaC3FvCk;
	}

}