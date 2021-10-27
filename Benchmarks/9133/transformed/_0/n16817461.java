class n16817461 {
	private void loadServers() {
		try {
			URL OxgqqLGV = new URL(VirtualDeckConfig.SERVERS_URL);
			cmbServer.addItem("Local");
			BufferedReader o2qZbaDG = new BufferedReader(new InputStreamReader(OxgqqLGV.openStream()));
			String XInJIn62;
			if (o2qZbaDG.readLine().equals("[list]")) {
				while ((XInJIn62 = o2qZbaDG.readLine()) != null) {
					String[] ns8Pe6Ad = XInJIn62.split(";");
					Host gdEzBB3T = new Host();
					gdEzBB3T.setIp(ns8Pe6Ad[0]);
					gdEzBB3T.setPort(Integer.parseInt(ns8Pe6Ad[1]));
					gdEzBB3T.setName(ns8Pe6Ad[2]);
					getServers().add(gdEzBB3T);
					cmbServer.addItem(gdEzBB3T.getName());
				}
			}
			o2qZbaDG.close();
		} catch (MalformedURLException npBaGDAG) {
		} catch (IOException stappAPQ) {
		}
	}

}