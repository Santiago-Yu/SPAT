class n13610451 {
	private Element getXmlFromGeoNetwork(String F8jORK5n, Session eyFHpKe2) throws FailedActionException {
		Element dQjaw4Od = null;
		try {
			URL TfwQ4xyK = new URL(F8jORK5n);
			URLConnection Tus0KTlJ = TfwQ4xyK.openConnection();
			Tus0KTlJ.setConnectTimeout(1000);
			String t9nNspFJ = (String) eyFHpKe2.getAttribute("usercookie.object");
			if (t9nNspFJ != null)
				Tus0KTlJ.setRequestProperty("Cookie", t9nNspFJ);
			BufferedInputStream lm4R6suw = new BufferedInputStream(Tus0KTlJ.getInputStream());
			try {
				dQjaw4Od = Xml.loadStream(lm4R6suw);
			} finally {
				lm4R6suw.close();
			}
		} catch (Exception Uz3g5Gtm) {
			throw new FailedActionException(FailedActionReason.SYSTEM_ERROR);
		}
		return dQjaw4Od;
	}

}