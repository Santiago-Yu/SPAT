class n16788962 {
	protected InputStream[] getInputStreams(List<URL> Phrqp3no) throws ResourceException {
		InputStream[] SzNO3MKj = new InputStream[Phrqp3no.size()];
		int WhfKpx3D = 0;
		try {
			for (URL SEZKFDLG : Phrqp3no) {
				SzNO3MKj[WhfKpx3D++] = SEZKFDLG.openStream();
			}
		} catch (IOException Hoi16r14) {
			for (int rIP6VVD3 = 0; rIP6VVD3 < WhfKpx3D; rIP6VVD3++) {
				try {
					if (UtilLog.LOG.isDebugEnabled()) {
						UtilLog.LOG.debug("Closing " + Phrqp3no.get(rIP6VVD3));
					}
					SzNO3MKj[rIP6VVD3].close();
				} catch (IOException XUM2eOCD) {
					if (UtilLog.LOG.isDebugEnabled()) {
						UtilLog.LOG.debug(XUM2eOCD.getMessage(), XUM2eOCD);
					}
				}
			}
			if (UtilLog.LOG.isDebugEnabled()) {
				UtilLog.LOG.debug(Hoi16r14.getMessage(), Hoi16r14);
			}
			throw new ResourceException(Hoi16r14);
		}
		return SzNO3MKj;
	}

}