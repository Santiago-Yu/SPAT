class n10649421 {
	@Override
	public void doGet(HttpServletRequest y4so0Rty, HttpServletResponse C4H6I9Ei) throws ServletException, IOException {
		String JYv4Byal = y4so0Rty.getParameter("datasetURL");
		String ZoJgJ7Pf = y4so0Rty.getParameter("contentType");
		String USukXB2m = y4so0Rty.getParameter("studyUID");
		String lh2aGLvd = y4so0Rty.getParameter("seriesUID");
		String mg5gOy2D = y4so0Rty.getParameter("objectUID");
		JYv4Byal += "&contentType=" + ZoJgJ7Pf + "&studyUID=" + USukXB2m + "&seriesUID=" + lh2aGLvd + "&objectUID="
				+ mg5gOy2D;
		JYv4Byal = JYv4Byal.replace("+", "%2B");
		InputStream FyrvR1yi = null;
		OutputStream yBzeadCh = C4H6I9Ei.getOutputStream();
		try {
			URL aWhMyvyK = new URL(JYv4Byal);
			FyrvR1yi = aWhMyvyK.openStream();
			byte[] oHsvkZy9 = new byte[4096];
			int nFNYNseA;
			while ((nFNYNseA = FyrvR1yi.read(oHsvkZy9)) != -1) {
				yBzeadCh.write(oHsvkZy9, 0, nFNYNseA);
			}
			yBzeadCh.flush();
			yBzeadCh.close();
			FyrvR1yi.close();
		} catch (Exception vhD7ppwz) {
			log.error("Unable to read and send the DICOM dataset page", vhD7ppwz);
		}
	}

}