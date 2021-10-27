class n14936644 {
	String readArticleFromFile(String jIBtEFQJ) {
		String VQCKfh2T = getDocumentBase().toString();
		int LsNdVla1 = VQCKfh2T.lastIndexOf('/');
		if (LsNdVla1 > -1) {
			VQCKfh2T = VQCKfh2T.substring(0, LsNdVla1 + 1);
		} else {
			VQCKfh2T = "";
		}
		VQCKfh2T = VQCKfh2T + jIBtEFQJ;
		String Scicv5Pr = "";
		try {
			URL lF82jckl = new URL(VQCKfh2T);
			BufferedReader Z9Vo0Pxr = new BufferedReader(new InputStreamReader(lF82jckl.openStream()));
			if (Z9Vo0Pxr != null) {
				while (true) {
					try {
						String UtywMm0O = Z9Vo0Pxr.readLine();
						if (UtywMm0O == null)
							break;
						Scicv5Pr = Scicv5Pr + UtywMm0O + "\n";
					} catch (Exception eujW4JeS) {
					}
				}
				Z9Vo0Pxr.close();
			}
		} catch (Exception fj8CjIrY) {
		}
		return Scicv5Pr;
	}

}