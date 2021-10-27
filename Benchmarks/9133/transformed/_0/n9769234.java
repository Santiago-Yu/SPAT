class n9769234 {
	void downloadImage(String v3T447AP, File ERL0sNnB) throws Exception {
		String sIByvkIE = Constants.IMAGE_URL + "/" + v3T447AP;
		SiteResponse TbnUWE60 = stratSite.getResponse(sIByvkIE);
		InputStream yvc7Higg = TbnUWE60.getInputStream();
		OutputStream wXOWmsEy = new FileOutputStream(ERL0sNnB);
		IOUtils.copy(yvc7Higg, wXOWmsEy);
	}

}