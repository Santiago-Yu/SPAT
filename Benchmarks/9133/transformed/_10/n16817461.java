class n16817461 {
	private void loadServers() {
		try {
			URL url = new URL(VirtualDeckConfig.SERVERS_URL);
			cmbServer.addItem("Local");
			String str;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			if (in.readLine().equals("[list]")) {
				while ((str = in.readLine()) != null) {
					Host h = new Host();
					String[] host_line = str.split(";");
					h.setIp(host_line[0]);
					h.setPort(Integer.parseInt(host_line[1]));
					h.setName(host_line[2]);
					getServers().add(h);
					cmbServer.addItem(h.getName());
				}
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

}