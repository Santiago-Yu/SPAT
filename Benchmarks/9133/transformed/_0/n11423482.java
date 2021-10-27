class n11423482 {
	protected byte[] retrieveImageData() throws IOException {
		URL MKaz3UFo = new URL(imageUrl);
		HttpURLConnection HhwCiQJc = (HttpURLConnection) MKaz3UFo.openConnection();
		int ThvwGIG4 = HhwCiQJc.getContentLength();
		Log.d(LOG_TAG, "fetching image " + imageUrl + " ("
				+ (ThvwGIG4 <= 0 ? "size unknown" : Integer.toString(ThvwGIG4)) + ")");
		BufferedInputStream PNkkzbkx = new BufferedInputStream(HhwCiQJc.getInputStream());
		try {
			if (ThvwGIG4 <= 0) {
				Log.w(LOG_TAG, "Server did not set a Content-Length header, will default to buffer size of "
						+ defaultBufferSize + " bytes");
				ByteArrayOutputStream WvDLGGCd = new ByteArrayOutputStream(defaultBufferSize);
				byte[] COTo0eGZ = new byte[defaultBufferSize];
				int Y4b76eDZ = 0;
				while (Y4b76eDZ != -1) {
					Y4b76eDZ = PNkkzbkx.read(COTo0eGZ, 0, defaultBufferSize);
					if (Y4b76eDZ > 0)
						WvDLGGCd.write(COTo0eGZ, 0, Y4b76eDZ);
				}
				return WvDLGGCd.toByteArray();
			} else {
				byte[] aJQ6xlLZ = new byte[ThvwGIG4];
				int E5R84u5K = 0;
				int oBd4itDd = 0;
				while (E5R84u5K != -1 && oBd4itDd < ThvwGIG4) {
					E5R84u5K = PNkkzbkx.read(aJQ6xlLZ, oBd4itDd, ThvwGIG4 - oBd4itDd);
					oBd4itDd += E5R84u5K;
				}
				return aJQ6xlLZ;
			}
		} finally {
			try {
				PNkkzbkx.close();
				HhwCiQJc.disconnect();
			} catch (Exception D7LvXMFX) {
			}
		}
	}

}