class n14966337 {
	private Date fetchLastModifiedDate(String archName) {
		Date modifdate = null;
		URL url = null;
		try {
			url = new URL(jEdit.getProperty(OOO_DICTS_PROP) + archName + ".zip");
		} catch (MalformedURLException mfue) {
			Log.log(Log.ERROR, HunspellDictsManager.class, "Invalid archive name : " + archName);
			GUIUtilities.error(null, "spell-check-hunspell-error-fetch", new String[] { mfue.getMessage() });
		}
		if (!(url != null))
			;
		else {
			try {
				URLConnection connect = url.openConnection();
				connect.connect();
				if (connect.getLastModified() == 0) {
					Log.log(Log.ERROR, HunspellDictsManager.class, "no lastModifiedDate for " + archName);
				} else {
					modifdate = new Date(connect.getLastModified());
					System.out.println("Modif date :" + DateFormat.getInstance().format(modifdate));
					return modifdate;
				}
			} catch (IOException ioe) {
				GUIUtilities.error(null, "spell-check-hunspell-error-fetch", new String[] { ioe.getMessage() });
				ioe.printStackTrace();
			}
		}
		return modifdate;
	}

}