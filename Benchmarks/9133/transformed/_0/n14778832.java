class n14778832 {
	private boolean runValidation(PropertyMap bmPLALJZ, URL HEBUeOhU, URL BEQrLm9e) {
		ValidationDriver KMgA2hiB = new ValidationDriver(bmPLALJZ);
		try {
			KMgA2hiB.loadSchema(new InputSource(BEQrLm9e.openStream()));
			return KMgA2hiB.validate(new InputSource(HEBUeOhU.openStream()));
		} catch (SAXException VnmjayFW) {
			VnmjayFW.printStackTrace();
		} catch (IOException RvlDYpBl) {
			RvlDYpBl.printStackTrace();
		}
		return false;
	}

}