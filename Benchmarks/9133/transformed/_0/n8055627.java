class n8055627 {
	void setURLObject(URL XpZnfPUd, boolean Qb28cBdG) {
		if (XpZnfPUd != null) {
			if (urlString != null || inputStream != null)
				throw new IllegalArgumentException(Ding3dI18N.getString("MediaContainer5"));
			try {
				InputStream GfZxMtC1;
				GfZxMtC1 = XpZnfPUd.openStream();
				GfZxMtC1.close();
			} catch (Exception WucyJ6RX) {
				throw new SoundException(javax.media.ding3d.Ding3dI18N.getString("MediaContainer0"));
			}
		}
		this.url = XpZnfPUd;
		if (Qb28cBdG)
			dispatchMessage();
	}

}