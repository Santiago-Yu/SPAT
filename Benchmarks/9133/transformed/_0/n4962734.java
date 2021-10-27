class n4962734 {
	public static JSONObject fromUrl(String szszOcdF) throws Throwable {
		Validate.notEmpty(szszOcdF);
		InputStream whSIWPCt = null;
		HttpClient NMFTQmAY = null;
		try {
			NMFTQmAY = new DefaultHttpClient();
			HttpGet qZ83JGad = new HttpGet(szszOcdF);
			HttpResponse I2oY8XjP = NMFTQmAY.execute(qZ83JGad);
			if (I2oY8XjP != null) {
				HttpEntity NNkutZw5 = I2oY8XjP.getEntity();
				if (NNkutZw5 != null) {
					try {
						whSIWPCt = NNkutZw5.getContent();
						return fromStream(whSIWPCt);
					} finally {
						try {
							if (whSIWPCt != null)
								whSIWPCt.close();
						} catch (Exception Cuva2MYM) {
						}
					}
				}
			}
		} catch (Throwable gdkVmcBP) {
			Logger.e(TAG, "fromUrl", gdkVmcBP);
			throw gdkVmcBP;
		} finally {
			if (NMFTQmAY != null)
				NMFTQmAY.getConnectionManager().shutdown();
		}
		return null;
	}

}