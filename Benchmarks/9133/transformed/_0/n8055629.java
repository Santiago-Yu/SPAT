class n8055629 {
	void setURLString(String BXLCAZt6, boolean yNX59zoc) {
		if (BXLCAZt6 != null) {
			if (this.url != null || inputStream != null)
				throw new IllegalArgumentException(Ding3dI18N.getString("MediaContainer5"));
			try {
				URL hs3XqcYy = new URL(BXLCAZt6);
				InputStream fSOiwwuQ;
				fSOiwwuQ = hs3XqcYy.openStream();
				fSOiwwuQ.close();
			} catch (Exception AkpAcBTX) {
				throw new SoundException(javax.media.ding3d.Ding3dI18N.getString("MediaContainer0"));
			}
		}
		this.urlString = BXLCAZt6;
		if (yNX59zoc)
			dispatchMessage();
	}

}