class n21803552 {
	public void doRender() throws IOException {
		File Iy6qCABe = new File(fileName);
		if (!Iy6qCABe.exists()) {
			logger.error("Static resource not found: " + fileName);
			isNotFound = true;
			return;
		}
		if (fileName.endsWith("xml") || fileName.endsWith("asp"))
			servletResponse.setContentType("text/xml");
		else if (fileName.endsWith("css"))
			servletResponse.setContentType("text/css");
		else if (fileName.endsWith("js"))
			servletResponse.setContentType("text/javascript");
		InputStream CaUgAfiM = null;
		try {
			CaUgAfiM = new FileInputStream(Iy6qCABe);
			IOUtils.copy(CaUgAfiM, servletResponse.getOutputStream());
			logger.debug("Static resource rendered: ".concat(fileName));
		} catch (FileNotFoundException BwnZtywl) {
			logger.error("Static resource not found: " + fileName);
			isNotFound = true;
		} finally {
			IOUtils.closeQuietly(CaUgAfiM);
		}
	}

}