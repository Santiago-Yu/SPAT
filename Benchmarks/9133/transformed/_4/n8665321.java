class n8665321 {
	public Vector<String> getNetworkServersIPs(String netaddress) {
		Vector<String> result = new Vector<String>();
		boolean serverline = false;
		String line;
		String[] splitline;
		try {
			URL url = new URL(netaddress);
			URLConnection connection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				serverline = ((serverline) && line.startsWith(";")) ? false : serverline;
				if (serverline) {
					splitline = line.split(":");
					result.add(splitline[1]);
				}
				serverline = (line.startsWith("!SERVERS")) ? true : serverline;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}