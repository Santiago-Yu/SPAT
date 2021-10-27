class n1168512 {
	protected Resolver queryResolver(String yYl9xCIm, String v1k5f6vR, String EXhXFODB, String ZNJf5eXS) {
		InputStream LXU2qyg3 = null;
		String eEs4Yyvq = yYl9xCIm + "?command=" + v1k5f6vR + "&format=tr9401&uri=" + EXhXFODB + "&uri2=" + ZNJf5eXS;
		String ayjksvJv = null;
		try {
			URL mmfS5ZiR = new URL(eEs4Yyvq);
			URLConnection xs31FhrC = mmfS5ZiR.openConnection();
			xs31FhrC.setUseCaches(false);
			Resolver YSDUPRhU = (Resolver) newCatalog();
			String MGxRnSQP = xs31FhrC.getContentType();
			if (MGxRnSQP.indexOf(";") > 0) {
				MGxRnSQP = MGxRnSQP.substring(0, MGxRnSQP.indexOf(";"));
			}
			YSDUPRhU.parseCatalog(MGxRnSQP, xs31FhrC.getInputStream());
			return YSDUPRhU;
		} catch (CatalogException RNYsPxbT) {
			if (RNYsPxbT.getExceptionType() == CatalogException.UNPARSEABLE) {
				catalogManager.debug.message(1, "Unparseable catalog: " + eEs4Yyvq);
			} else if (RNYsPxbT.getExceptionType() == CatalogException.UNKNOWN_FORMAT) {
				catalogManager.debug.message(1, "Unknown catalog format: " + eEs4Yyvq);
			}
			return null;
		} catch (MalformedURLException qKTuORG0) {
			catalogManager.debug.message(1, "Malformed resolver URL: " + eEs4Yyvq);
			return null;
		} catch (IOException jpiZXG7r) {
			catalogManager.debug.message(1, "I/O Exception opening resolver: " + eEs4Yyvq);
			return null;
		}
	}

}