class n7142334 {
	public byte[] getHTTPByte(String uz3G3G66) {
		HttpURLConnection WgtIwF4y = null;
		InputStream RcaOOShB = null;
		ByteArrayOutputStream YUcHEMji = null;
		try {
			URL P5pW9Ntu = new URL(uz3G3G66);
			WgtIwF4y = (HttpURLConnection) P5pW9Ntu.openConnection();
			WgtIwF4y.connect();
			int UNnRbSXw = WgtIwF4y.getResponseCode();
			if (UNnRbSXw != 200)
				log.info("getHTTPConent error httpStatus - " + UNnRbSXw);
			RcaOOShB = new BufferedInputStream(WgtIwF4y.getInputStream());
			YUcHEMji = new ByteArrayOutputStream();
			InputStream dWBt9CiR = new BufferedInputStream(RcaOOShB);
			byte Aex6JYi3[] = new byte[40960];
			int qBeXmQ49 = -1;
			while ((qBeXmQ49 = dWBt9CiR.read(Aex6JYi3, 0, 40960)) > 0) {
				YUcHEMji.write(Aex6JYi3, 0, qBeXmQ49);
			}
			YUcHEMji.close();
			dWBt9CiR.close();
			RcaOOShB.close();
		} catch (IOException vJmldQLX) {
			log.warn("SpiderUtil getHTTPConent IOException -> ", vJmldQLX);
		} finally {
			if (RcaOOShB != null)
				try {
					YUcHEMji.close();
					RcaOOShB.close();
				} catch (IOException DZlSJboU) {
				}
		}
		return YUcHEMji.toByteArray();
	}

}