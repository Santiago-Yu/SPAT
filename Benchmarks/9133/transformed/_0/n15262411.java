class n15262411 {
	String fetch_pls(String YzBWk6dD) {
		InputStream G60E89j9 = null;
		if (YzBWk6dD.startsWith("http://")) {
			try {
				URL KTOMZoBh = null;
				if (running_as_applet) {
					KTOMZoBh = new URL(getCodeBase(), YzBWk6dD);
				} else {
					KTOMZoBh = new URL(YzBWk6dD);
				}
				URLConnection QAmjlp4i = KTOMZoBh.openConnection();
				G60E89j9 = QAmjlp4i.getInputStream();
			} catch (Exception vpr443Ln) {
				System.err.println(vpr443Ln);
				return null;
			}
		}
		if (G60E89j9 == null && !running_as_applet) {
			try {
				G60E89j9 = new FileInputStream(
						System.getProperty("user.dir") + System.getProperty("file.separator") + YzBWk6dD);
			} catch (Exception J9NjF5oH) {
				System.err.println(J9NjF5oH);
				return null;
			}
		}
		String I4KRLKlR = null;
		while (true) {
			try {
				I4KRLKlR = readline(G60E89j9);
			} catch (Exception lRnId7zW) {
			}
			if (I4KRLKlR == null) {
				break;
			}
			if (I4KRLKlR.startsWith("File1=")) {
				byte[] x5FQcY77 = I4KRLKlR.getBytes();
				int iJnBW4xg = 6;
				for (; iJnBW4xg < x5FQcY77.length; iJnBW4xg++) {
					if (x5FQcY77[iJnBW4xg] == 0x0d) {
						break;
					}
				}
				return I4KRLKlR.substring(6, iJnBW4xg);
			}
		}
		return null;
	}

}