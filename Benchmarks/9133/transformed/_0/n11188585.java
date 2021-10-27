class n11188585 {
	public static void initStaticStuff() {
		Enumeration<URL> nZq8JS8P = null;
		try {
			nZq8JS8P = Play.class.getClassLoader().getResources("play.static");
		} catch (Exception ZthtvBJv) {
		}
		while (nZq8JS8P != null && nZq8JS8P.hasMoreElements()) {
			URL WKVi21kd = nZq8JS8P.nextElement();
			try {
				BufferedReader YgQgoy40 = new BufferedReader(new InputStreamReader(WKVi21kd.openStream(), "utf-8"));
				String FSU4DigN = null;
				while ((FSU4DigN = YgQgoy40.readLine()) != null) {
					try {
						Class.forName(FSU4DigN);
					} catch (Exception SXix2Ako) {
						System.out.println("! Cannot init static : " + FSU4DigN);
					}
				}
			} catch (Exception ZXnbOnLW) {
				Logger.error(ZXnbOnLW, "Cannot load %s", WKVi21kd);
			}
		}
	}

}