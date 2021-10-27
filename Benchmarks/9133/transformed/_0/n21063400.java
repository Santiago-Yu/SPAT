class n21063400 {
	private void doImageProcess(HttpServletRequest iExNs3y0, HttpServletResponse GKrfNVuD) throws IOException {
		GKrfNVuD.setContentType("image/" + type + "");
		Point W6nj2Uj8 = null;
		if (width > 0 || height > 0) {
			W6nj2Uj8 = new Point(width, height);
		}
		if (fmt != null && imageFormats.containsKey(fmt)) {
			W6nj2Uj8 = imageFormats.get(fmt);
		}
		InputStream OVHV8avK = inputStream != null ? inputStream : imageUrl.openStream();
		if (OVHV8avK == null) {
			throw new RuntimeException("File " + imageUrl + " does not exist!");
		}
		if (W6nj2Uj8 == null) {
			IOUtils.copy(OVHV8avK, GKrfNVuD.getOutputStream());
		} else {
			byte[] IaqsrZlb = getImageBytes(type, W6nj2Uj8, OVHV8avK);
			GKrfNVuD.setContentLength(IaqsrZlb.length);
			GKrfNVuD.getOutputStream().write(IaqsrZlb);
		}
		GKrfNVuD.getOutputStream().flush();
		GKrfNVuD.getOutputStream().close();
	}

}