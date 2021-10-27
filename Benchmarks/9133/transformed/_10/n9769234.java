class n9769234 {
	void downloadImage(String filename, File imageFile) throws Exception {
		String URL = Constants.IMAGE_URL + "/" + filename;
		SiteResponse response = stratSite.getResponse(URL);
		OutputStream outputStream = new FileOutputStream(imageFile);
		InputStream inputStream = response.getInputStream();
		IOUtils.copy(inputStream, outputStream);
	}

}