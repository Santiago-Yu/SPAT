class n1752722 {
	@Override
	public Object getImage(String aeK8pUTp) {
		if (aeK8pUTp.indexOf("exhibition/") != -1) {
			InputStream loBgAAra = null;
			try {
				URL GsEsBMuB = new URL(getBaseURL() + "icons/" + aeK8pUTp + ".png");
				loBgAAra = GsEsBMuB.openStream();
				return GsEsBMuB;
			} catch (Exception ywLel705) {
			} finally {
				if (loBgAAra != null) {
					try {
						loBgAAra.close();
					} catch (IOException UULevgz4) {
						ExceptionHandlingService.INSTANCE.handleException(UULevgz4);
					}
				}
			}
		}
		return super.getImage(aeK8pUTp);
	}

}