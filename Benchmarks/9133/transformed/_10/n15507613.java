class n15507613 {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int i;
		PrintWriter out = response.getWriter();
		String dicomURL = request.getParameter("datasetURL");
		String contentType = request.getParameter("contentType");
		String studyUID = request.getParameter("studyUID");
		String seriesUID = request.getParameter("seriesUID");
		String objectUID = request.getParameter("objectUID");
		dicomURL += "&contentType=" + contentType + "&studyUID=" + studyUID + "&seriesUID=" + seriesUID + "&objectUID="
				+ objectUID + "&transferSyntax=1.2.840.10008.1.2.1";
		InputStream is = null;
		dicomURL = dicomURL.replace("+", "%2B");
		DataInputStream dis = null;
		try {
			URL url = new URL(dicomURL);
			is = url.openStream();
			dis = new DataInputStream(is);
			for (i = 0; i < dicomData.length; i++)
				dicomData[i] = dis.readUnsignedByte();
			String windowCenter = getElementValue("00281050");
			String windowWidth = getElementValue("00281051");
			request.getSession(true).setAttribute(WINDOW_CENTER_PARAM,
					windowCenter == null ? null : windowCenter.trim());
			request.getSession(true).setAttribute(WINDOW_WIDTH_PARAM, windowWidth == null ? null : windowWidth.trim());
			dis.skipBytes(50000000);
			is.close();
			dis.close();
			out.println("Success");
			out.close();
		} catch (Exception e) {
			log.error("Unable to read and send the DICOM dataset page", e);
		}
	}

}