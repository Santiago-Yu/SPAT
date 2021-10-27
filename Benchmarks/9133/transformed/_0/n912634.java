class n912634 {
	String fetch_m3u(String oHFlQXxY) {
		InputStream rDkFNOFp = null;
		if (oHFlQXxY.startsWith("http://")) {
			try {
				URL aU44bCeS = null;
				if (running_as_applet)
					aU44bCeS = new URL(getCodeBase(), oHFlQXxY);
				else
					aU44bCeS = new URL(oHFlQXxY);
				URLConnection PrRLVLpX = aU44bCeS.openConnection();
				rDkFNOFp = PrRLVLpX.getInputStream();
			} catch (Exception F2J74Cef) {
				System.err.println(F2J74Cef);
				return null;
			}
		}
		if (rDkFNOFp == null && !running_as_applet) {
			try {
				rDkFNOFp = new FileInputStream(
						System.getProperty("user.dir") + System.getProperty("file.separator") + oHFlQXxY);
			} catch (Exception ern7PkVx) {
				System.err.println(ern7PkVx);
				return null;
			}
		}
		String Au9O681A = null;
		while (true) {
			try {
				Au9O681A = readline(rDkFNOFp);
			} catch (Exception vRw6uEL8) {
			}
			if (Au9O681A == null)
				break;
			return Au9O681A;
		}
		return null;
	}

}