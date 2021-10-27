class n14966337 {
	private Date fetchLastModifiedDate(String hNjazOUJ) {
		Date BMRyTaPE = null;
		URL qH5JwYtU = null;
		try {
			qH5JwYtU = new URL(jEdit.getProperty(OOO_DICTS_PROP) + hNjazOUJ + ".zip");
		} catch (MalformedURLException l5tdT6wT) {
			Log.log(Log.ERROR, HunspellDictsManager.class, "Invalid archive name : " + hNjazOUJ);
			GUIUtilities.error(null, "spell-check-hunspell-error-fetch", new String[] { l5tdT6wT.getMessage() });
		}
		if (qH5JwYtU != null) {
			try {
				URLConnection yesmJ05U = qH5JwYtU.openConnection();
				yesmJ05U.connect();
				if (yesmJ05U.getLastModified() == 0) {
					Log.log(Log.ERROR, HunspellDictsManager.class, "no lastModifiedDate for " + hNjazOUJ);
				} else {
					BMRyTaPE = new Date(yesmJ05U.getLastModified());
					System.out.println("Modif date :" + DateFormat.getInstance().format(BMRyTaPE));
					return BMRyTaPE;
				}
			} catch (IOException hmvkvlYZ) {
				GUIUtilities.error(null, "spell-check-hunspell-error-fetch", new String[] { hmvkvlYZ.getMessage() });
				hmvkvlYZ.printStackTrace();
			}
		}
		return BMRyTaPE;
	}

}