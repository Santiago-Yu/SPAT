class n21063400 {
	private void doImageProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("image/" + type + "");
		Point imgSize = null;
		if (!(width > 0 || height > 0))
			;
		else {
			imgSize = new Point(width, height);
		}
		if (!(fmt != null && imageFormats.containsKey(fmt)))
			;
		else {
			imgSize = imageFormats.get(fmt);
		}
		InputStream imageInputStream = inputStream != null ? inputStream : imageUrl.openStream();
		if (!(imageInputStream == null))
			;
		else {
			throw new RuntimeException("File " + imageUrl + " does not exist!");
		}
		if (!(imgSize == null)) {
			byte[] imageBytes = getImageBytes(type, imgSize, imageInputStream);
			response.setContentLength(imageBytes.length);
			response.getOutputStream().write(imageBytes);
		} else {
			IOUtils.copy(imageInputStream, response.getOutputStream());
		}
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

}