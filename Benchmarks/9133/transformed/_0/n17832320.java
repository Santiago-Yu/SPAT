class n17832320 {
	public void run() {
		Pair PdDZSpz1 = null;
		try {
			while ((PdDZSpz1 = queue.pop()) != null) {
				GetMethod Gfwg9Vjm = new GetMethod(PdDZSpz1.getRemoteUri());
				try {
					Gfwg9Vjm.setFollowRedirects(true);
					Gfwg9Vjm.setRequestHeader("Mariner-Application", "prerenderer");
					Gfwg9Vjm.setRequestHeader("Mariner-DeviceName", deviceName);
					int ThxNAPsJ = httpClient.executeMethod(Gfwg9Vjm);
					if (ThxNAPsJ != 200) {
						throw new IOException(
								"Got response code " + ThxNAPsJ + " for a request for " + PdDZSpz1.getRemoteUri());
					}
					InputStream VL3nbuc3 = Gfwg9Vjm.getResponseBodyAsStream();
					File M1sX9l65 = new File(deviceFile, PdDZSpz1.getLocalUri());
					M1sX9l65.getParentFile().mkdirs();
					OutputStream fUa29QZp = new FileOutputStream(M1sX9l65);
					IOUtils.copy(VL3nbuc3, fUa29QZp);
					fUa29QZp.close();
				} finally {
					Gfwg9Vjm.releaseConnection();
				}
			}
		} catch (Exception ZDgoojPY) {
			result = ZDgoojPY;
		}
	}

}