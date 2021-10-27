class n743717 {
	String fetch_m3u(String WHY4J9PP) {
		InputStream a5tPb0KH = null;
		if (WHY4J9PP.startsWith("http://")) {
			try {
				URL WNUQ91RB = null;
				if (running_as_applet)
					WNUQ91RB = new URL(getCodeBase(), WHY4J9PP);
				else
					WNUQ91RB = new URL(WHY4J9PP);
				URLConnection Vad0weIb = WNUQ91RB.openConnection();
				a5tPb0KH = Vad0weIb.getInputStream();
			} catch (Exception p7LeSWZS) {
				System.err.println(p7LeSWZS);
				return null;
			}
		}
		if (a5tPb0KH == null && !running_as_applet) {
			try {
				a5tPb0KH = new FileInputStream(
						System.getProperty("user.dir") + System.getProperty("file.separator") + WHY4J9PP);
			} catch (Exception Z5KPWhCY) {
				System.err.println(Z5KPWhCY);
				return null;
			}
		}
		String aUHqloQL = null;
		while (true) {
			try {
				aUHqloQL = readline(a5tPb0KH);
			} catch (Exception Qq4rVkK9) {
			}
			if (aUHqloQL == null)
				break;
			return aUHqloQL;
		}
		return null;
	}

}