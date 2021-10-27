class n21933390 {
	public static List<String> getServers() throws Exception {
		URL url = new URL("http://tfast.org/en/servers.php");
		List<String> servers = new ArrayList<String>();
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		while ((line = in.readLine()) != null) {
			if (line.contains("serv=")) {
				int i = line.indexOf("serv=");
				servers.add(line.substring(i + 5, line.indexOf("\"", i)));
			}
		}
		in.close();
		return servers;
	}

}