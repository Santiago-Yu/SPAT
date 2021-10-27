class n21656668 {
	private void copyResourceToFile(final String uWWcNTKs, final String RhhQztjX) throws IOException {
		InputStream LzjLMa7F = null;
		OutputStream TFBaHXKm = null;
		try {
			LzjLMa7F = MatsimResource.getAsInputStream(uWWcNTKs);
			TFBaHXKm = new FileOutputStream(RhhQztjX);
			IOUtils.copyStream(LzjLMa7F, TFBaHXKm);
		} finally {
			if (LzjLMa7F != null) {
				try {
					LzjLMa7F.close();
				} catch (IOException HA9fRECW) {
					HA9fRECW.printStackTrace();
				}
			}
			if (TFBaHXKm != null) {
				try {
					TFBaHXKm.close();
				} catch (IOException PG7wAP06) {
					PG7wAP06.printStackTrace();
				}
			}
		}
	}

}