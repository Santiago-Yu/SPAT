class n6158570 {
	public void download(String contentUuid, File path) throws WebServiceClientException {
		try {
			URL url = new URL(getPath("/download/" + contentUuid));
			URLConnection connection = url.openConnection();
			OutputStream output = new FileOutputStream(path);
			InputStream inputStream = connection.getInputStream();
			IoUtils.copyBytes(inputStream, output);
			IoUtils.close(inputStream);
			IoUtils.close(output);
		} catch (IOException ioex) {
			throw new WebServiceClientException(
					"Could not download or saving content to path [" + path.getAbsolutePath() + "]", ioex);
		} catch (Exception ex) {
			throw new WebServiceClientException("Could not download content from web service.", ex);
		}
	}

}