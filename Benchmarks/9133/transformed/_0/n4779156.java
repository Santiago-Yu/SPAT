class n4779156 {
	@Override
	protected void doGet(HttpServletRequest iBJez1BL, HttpServletResponse hpTx8L3D)
			throws ServletException, IOException {
		String EKYFts8P = iBJez1BL.getRequestURI().split("/")[3];
		if (log.isDebugEnabled())
			log.debug("request: " + EKYFts8P + " from: " + iBJez1BL.getRemoteHost());
		Song cas9WBi3 = manager.find(EKYFts8P);
		if (cas9WBi3 != null) {
			File PksXZt6I = new File(cas9WBi3.getFile());
			if (PksXZt6I.exists()) {
				hpTx8L3D.setStatus(HttpServletResponse.SC_OK);
				hpTx8L3D.setContentType("audio/" + cas9WBi3.getType());
				hpTx8L3D.setContentLength((int) PksXZt6I.length());
				FileInputStream ypQTZW84 = new FileInputStream(PksXZt6I);
				try {
					IOUtils.copy(ypQTZW84, hpTx8L3D.getOutputStream());
				} finally {
					IOUtils.closeQuietly(ypQTZW84);
				}
			} else {
				log.warn("file not found: " + PksXZt6I);
				hpTx8L3D.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			log.info("song not found: " + EKYFts8P);
			hpTx8L3D.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}