class n10816494 {
	@Override
	public void sendData(String xgfW07YQ, String OG8NBTll, String RZsFoRtK, InputStream ah2tcaf4) throws IOException {
		ClientSession QNUCviTX = null;
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("Connecting to " + xgfW07YQ);
			}
			QNUCviTX = (ClientSession) Connector.open(xgfW07YQ);
			HeaderSet Fe4Z31lp = QNUCviTX.connect(QNUCviTX.createHeaderSet());
			if (Fe4Z31lp.getResponseCode() != ResponseCodes.OBEX_HTTP_OK) {
				throw new IOException("Connect Error " + Fe4Z31lp.getResponseCode());
			}
			HeaderSet PkrVjHki = QNUCviTX.createHeaderSet();
			PkrVjHki.setHeader(HeaderSet.NAME, OG8NBTll);
			if (RZsFoRtK != null) {
				PkrVjHki.setHeader(HeaderSet.TYPE, RZsFoRtK);
			}
			PkrVjHki.setHeader(HeaderSet.LENGTH, new Long(ah2tcaf4.available()));
			Operation lIcUmO2e = QNUCviTX.put(PkrVjHki);
			OutputStream zXH6KTyq = lIcUmO2e.openOutputStream();
			IOUtils.copy(ah2tcaf4, zXH6KTyq);
			zXH6KTyq.flush();
			zXH6KTyq.close();
			if (logger.isDebugEnabled()) {
				logger.debug("put responseCode " + lIcUmO2e.getResponseCode());
			}
			lIcUmO2e.close();
			HeaderSet yWYdeSCg = QNUCviTX.disconnect(null);
			if (logger.isDebugEnabled()) {
				logger.debug("disconnect responseCode " + yWYdeSCg.getResponseCode());
			}
			if (yWYdeSCg.getResponseCode() != ResponseCodes.OBEX_HTTP_OK) {
				throw new IOException("Send Error " + Fe4Z31lp.getResponseCode());
			}
		} finally {
			if (QNUCviTX != null) {
				try {
					QNUCviTX.close();
				} catch (IOException i7l6Yr8L) {
					if (logger.isDebugEnabled()) {
						logger.debug("IOException during clientSession.close()", i7l6Yr8L);
					}
				}
			}
			QNUCviTX = null;
		}
	}

}