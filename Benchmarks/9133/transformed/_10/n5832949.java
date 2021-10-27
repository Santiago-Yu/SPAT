class n5832949 {
	private void getImage(String filename)
			throws MalformedURLException, IOException, SAXException, FileNotFoundException {
		String url = Constants.STRATEGICDOMINATION_URL + "/images/gameimages/" + filename;
		WebRequest req = new GetMethodWebRequest(url);
		File file = new File("etc/images/" + filename);
		WebResponse response = wc.getResponse(req);
		FileOutputStream outputStream = new FileOutputStream(file);
		IOUtils.copy(response.getInputStream(), outputStream);
	}

}