class n13237415 {
	public static List<ServerInfo> getStartedServers() {
		List<ServerInfo> infos = new ArrayList<ServerInfo>();
		try {
			StringBuilder request = new StringBuilder();
			request.append(url).append("/").append(displayServlet);
			request.append("?ingame=1");
			URL objUrl = new URL(request.toString());
			URLConnection urlConnect = objUrl.openConnection();
			InputStream in = urlConnect.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			while (reader.ready()) {
				String name = reader.readLine(), ip = reader.readLine();
				int port = Integer.valueOf(reader.readLine());
				ServerInfo server = new ServerInfo(name, ip, port);
				server.nbPlayers = Integer.valueOf(reader.readLine());
				infos.add(server);
			}
			in.close();
			return infos;
		} catch (Exception e) {
			return infos;
		}
	}

}