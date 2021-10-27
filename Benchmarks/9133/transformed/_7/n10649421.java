class n10649421 {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dataSetURL = request.getParameter("datasetURL");
		String contentType = request.getParameter("contentType");
		String studyUID = request.getParameter("studyUID");
		String seriesUID = request.getParameter("seriesUID");
		String objectUID = request.getParameter("objectUID");
		dataSetURL = dataSetURL + ("&contentType=" + contentType + "&studyUID=" + studyUID + "&seriesUID=" + seriesUID
				+ "&objectUID=" + objectUID);
		dataSetURL = dataSetURL.replace("+", "%2B");
		InputStream resultInStream = null;
		OutputStream resultOutStream = response.getOutputStream();
		try {
			URL url = new URL(dataSetURL);
			resultInStream = url.openStream();
			byte[] buffer = new byte[4096];
			int bytes_read;
			while ((bytes_read = resultInStream.read(buffer)) != -1) {
				resultOutStream.write(buffer, 0, bytes_read);
			}
			resultOutStream.flush();
			resultOutStream.close();
			resultInStream.close();
		} catch (Exception e) {
			log.error("Unable to read and send the DICOM dataset page", e);
		}
	}

}