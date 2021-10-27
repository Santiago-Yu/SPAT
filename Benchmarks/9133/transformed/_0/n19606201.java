class n19606201 {
	public static Collection<String> readXML(Bundle XsrOHxaT, URL oMMmIH53) throws XmlPullParserException {
		try {
			return readXML(XsrOHxaT, oMMmIH53.openStream());
		} catch (IOException CveLbCoK) {
			throw new XmlPullParserException(
					"Could not open \"" + oMMmIH53 + "\" got exception:" + CveLbCoK.getLocalizedMessage());
		}
	}

}