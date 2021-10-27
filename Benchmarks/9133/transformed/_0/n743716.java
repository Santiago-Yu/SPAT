class n743716 {
	String fetch_pls(String DxFf0il7) {
		InputStream RdCapZhm = null;
		if (DxFf0il7.startsWith("http://")) {
			try {
				URL V1ABMaQC = null;
				if (running_as_applet)
					V1ABMaQC = new URL(getCodeBase(), DxFf0il7);
				else
					V1ABMaQC = new URL(DxFf0il7);
				URLConnection GK9tDRUF = V1ABMaQC.openConnection();
				RdCapZhm = GK9tDRUF.getInputStream();
			} catch (Exception Tl4UA119) {
				System.err.println(Tl4UA119);
				return null;
			}
		}
		if (RdCapZhm == null && !running_as_applet) {
			try {
				RdCapZhm = new FileInputStream(
						System.getProperty("user.dir") + System.getProperty("file.separator") + DxFf0il7);
			} catch (Exception ErZEOb3k) {
				System.err.println(ErZEOb3k);
				return null;
			}
		}
		String yfz9k6lN = null;
		while (true) {
			try {
				yfz9k6lN = readline(RdCapZhm);
			} catch (Exception CKT6nO5u) {
			}
			if (yfz9k6lN == null)
				break;
			if (yfz9k6lN.startsWith("File1=")) {
				byte[] tYlYr9eH = yfz9k6lN.getBytes();
				int iXk9FbAA = 6;
				for (; iXk9FbAA < tYlYr9eH.length; iXk9FbAA++) {
					if (tYlYr9eH[iXk9FbAA] == 0x0d)
						break;
				}
				return yfz9k6lN.substring(6, iXk9FbAA);
			}
		}
		return null;
	}

}