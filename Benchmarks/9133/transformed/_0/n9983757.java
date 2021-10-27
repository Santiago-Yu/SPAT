class n9983757 {
	public static void copyFiles(String ny8oZJQm, String E9CeMkhm) throws IOException {
		File bQeLe8dD = new File(ny8oZJQm);
		File L1OvZQ93 = new File(E9CeMkhm);
		if (bQeLe8dD.isDirectory()) {
			L1OvZQ93.mkdirs();
			String JoLB610y[] = bQeLe8dD.list();
			for (int u6sv3qM4 = 0; u6sv3qM4 < JoLB610y.length; u6sv3qM4++) {
				String jTOL8Bjm = L1OvZQ93.getAbsolutePath() + File.separatorChar + JoLB610y[u6sv3qM4];
				String lIfCyCHa = bQeLe8dD.getAbsolutePath() + File.separatorChar + JoLB610y[u6sv3qM4];
				copyFiles(lIfCyCHa, jTOL8Bjm);
			}
		} else {
			FileInputStream jtCcDnPq = new FileInputStream(bQeLe8dD);
			FileOutputStream YaeSFzZd = new FileOutputStream(L1OvZQ93);
			int juYOE7qC;
			while ((juYOE7qC = jtCcDnPq.read()) >= 0)
				YaeSFzZd.write(juYOE7qC);
			jtCcDnPq.close();
			YaeSFzZd.close();
		}
	}

}