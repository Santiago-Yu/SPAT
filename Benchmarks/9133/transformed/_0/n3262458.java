class n3262458 {
	@Override
	public void run() {
		while (run) {
			try {
				URL h8EcfFpr = new URL("http://" + server.getIp() + "/" + tomcat.getName() + "/ui/pva/version.jsp?RT="
						+ System.currentTimeMillis());
				BufferedReader espVk4ch = new BufferedReader(
						new InputStreamReader(h8EcfFpr.openStream(), Charset.forName("UTF-8")));
				String y5jEaVLn;
				while ((y5jEaVLn = espVk4ch.readLine()) != null) {
					if (y5jEaVLn.contains("currentversion")) {
						String vipIT8b8 = y5jEaVLn.substring(y5jEaVLn.indexOf("=") + 1, y5jEaVLn.length());
						tomcat.setDetailInfo(vipIT8b8.trim());
					}
				}
				espVk4ch.close();
				tomcat.setIsAlive(true);
			} catch (Exception q3FHSaiI) {
				tomcat.setIsAlive(false);
			}
			try {
				Thread.sleep(60000);
			} catch (InterruptedException ZuvMCZHj) {
			}
		}
	}

}