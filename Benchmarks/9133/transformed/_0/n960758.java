class n960758 {
	public byte[] getBytesMethod(String yaYC5CVb) {
		logger.info("Facebook: @executing facebookGetMethod():" + yaYC5CVb);
		byte[] DHunGKHY = null;
		try {
			HttpGet zEs1ER6Z = new HttpGet(yaYC5CVb);
			zEs1ER6Z.addHeader("Accept-Encoding", "gzip");
			HttpResponse OiJAK1rc = httpClient.execute(zEs1ER6Z);
			HttpEntity bVb2AeDm = OiJAK1rc.getEntity();
			logger.trace("Facebook: getBytesMethod: " + OiJAK1rc.getStatusLine());
			if (bVb2AeDm != null) {
				InputStream AFNL6qsW = OiJAK1rc.getEntity().getContent();
				if (OiJAK1rc.getEntity().getContentEncoding().getValue().equals("gzip")) {
					AFNL6qsW = new GZIPInputStream(AFNL6qsW);
				}
				ByteArrayOutputStream eIcK5Xx2 = new ByteArrayOutputStream();
				byte[] DY38rQFB = new byte[4096];
				int sGkqJumx;
				while ((sGkqJumx = AFNL6qsW.read(DY38rQFB)) != -1) {
					eIcK5Xx2.write(DY38rQFB, 0, sGkqJumx);
				}
				DHunGKHY = eIcK5Xx2.toByteArray();
				AFNL6qsW.close();
				bVb2AeDm.consumeContent();
			}
			int Y7Ierzh3 = OiJAK1rc.getStatusLine().getStatusCode();
			if (Y7Ierzh3 != 200) {
				logger.warn("Facebook: Error Occured! Status Code = " + Y7Ierzh3);
				DHunGKHY = null;
			}
			logger.info("Facebook: Get Bytes Method done(" + Y7Ierzh3 + "), response bytes length: "
					+ (DHunGKHY == null ? 0 : DHunGKHY.length));
		} catch (IOException o8kST3eZ) {
			logger.warn("Facebook: ", o8kST3eZ);
		}
		return DHunGKHY;
	}

}