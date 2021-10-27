class n19752873 {
	public void reqservmodif(HttpServletRequest o9JCIDeE, HttpServletResponse w5yytex7, SessionCommand r47SQ5kN) {
		setHeader(w5yytex7);
		try {
			logger.debug("SeMo: Requesting server modification for session " + r47SQ5kN.getSession());
			File nNv1ZgkK = new File(getSyncWorkDirectory(o9JCIDeE), r47SQ5kN.getSession() + ".smodif");
			OutputStream UuWqCIMK = new FileOutputStream(nNv1ZgkK);
			syncServer.getServerModifications(r47SQ5kN.getSession(), UuWqCIMK);
			InputStream mKyVH9gY = new FileInputStream(nNv1ZgkK);
			w5yytex7.setContentLength(mKyVH9gY.available());
			while (mKyVH9gY.available() > 0) {
				w5yytex7.getOutputStream().write(mKyVH9gY.read());
			}
			w5yytex7.getOutputStream().flush();
			w5yytex7.flushBuffer();
		} catch (IOException GFGFMvks) {
			logger.error(GFGFMvks.getMessage());
		} catch (ImogSerializationException CUELKnEY) {
			logger.error(CUELKnEY.getMessage());
		}
	}

}