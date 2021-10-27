class n13237415 {
	public static List<ServerInfo> getStartedServers() {
		List<ServerInfo> anXdR3er = new ArrayList<ServerInfo>();
		try {
			StringBuilder YCz2K6LY = new StringBuilder();
			YCz2K6LY.append(url).append("/").append(displayServlet);
			YCz2K6LY.append("?ingame=1");
			URL WYuPR2I7 = new URL(YCz2K6LY.toString());
			URLConnection kwX3RvVx = WYuPR2I7.openConnection();
			InputStream CY6QhK3T = kwX3RvVx.getInputStream();
			BufferedReader YjdE8wml = new BufferedReader(new InputStreamReader(CY6QhK3T));
			while (YjdE8wml.ready()) {
				String kFYkmckz = YjdE8wml.readLine();
				String v6biooKA = YjdE8wml.readLine();
				int FqtHSmd1 = Integer.valueOf(YjdE8wml.readLine());
				ServerInfo XgkNJRiA = new ServerInfo(kFYkmckz, v6biooKA, FqtHSmd1);
				XgkNJRiA.nbPlayers = Integer.valueOf(YjdE8wml.readLine());
				anXdR3er.add(XgkNJRiA);
			}
			CY6QhK3T.close();
			return anXdR3er;
		} catch (Exception O8xYkoSe) {
			return anXdR3er;
		}
	}

}