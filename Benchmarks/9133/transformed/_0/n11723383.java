class n11723383 {
	private void getImage(String awU7C5z6)
			throws MalformedURLException, IOException, SAXException, FileNotFoundException {
		String M665O5e1 = Constants.STRATEGICDOMINATION_URL + "/images/gameimages/" + awU7C5z6;
		WebRequest aBS1rTL4 = new GetMethodWebRequest(M665O5e1);
		SiteResponse Ux4nLSHQ = getSiteResponse(aBS1rTL4);
		File Ih3VAPgF = new File("etc/images/" + awU7C5z6);
		FileOutputStream rR31RCor = new FileOutputStream(Ih3VAPgF);
		IOUtils.copy(Ux4nLSHQ.getInputStream(), rR31RCor);
	}

}