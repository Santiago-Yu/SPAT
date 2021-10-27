class n15262412 {
	String fetch_m3u(String LzrqYGD9) {
		InputStream urSjqmlh = null;
		if (LzrqYGD9.startsWith("http://")) {
			try {
				URL NTYnLDwO = null;
				if (running_as_applet) {
					NTYnLDwO = new URL(getCodeBase(), LzrqYGD9);
				} else {
					NTYnLDwO = new URL(LzrqYGD9);
				}
				URLConnection HjYClapD = NTYnLDwO.openConnection();
				urSjqmlh = HjYClapD.getInputStream();
			} catch (Exception rvCH4V7x) {
				System.err.println(rvCH4V7x);
				return null;
			}
		}
		if (urSjqmlh == null && !running_as_applet) {
			try {
				urSjqmlh = new FileInputStream(
						System.getProperty("user.dir") + System.getProperty("file.separator") + LzrqYGD9);
			} catch (Exception fLwrf2xU) {
				System.err.println(fLwrf2xU);
				return null;
			}
		}
		String PE4TRVVN = null;
		while (true) {
			try {
				PE4TRVVN = readline(urSjqmlh);
			} catch (Exception mXq8p2LT) {
			}
			if (PE4TRVVN == null) {
				break;
			}
			return PE4TRVVN;
		}
		return null;
	}

}