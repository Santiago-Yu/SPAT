class n19307121 {
	public static byte[] sendSmsRequest(String GwZ6QB8O, String RUgYs5Ew) {
		byte[] LcndjXmI = null;
		try {
			URL ygG6Xj4j = new URL(GwZ6QB8O);
			HttpURLConnection uoEoCe52 = (HttpURLConnection) ygG6Xj4j.openConnection();
			uoEoCe52.setRequestProperty("Accept-Language", "zh-CN");
			uoEoCe52.setDoOutput(true);
			uoEoCe52.setDoInput(true);
			PrintWriter Bzp8CSGw = new PrintWriter(uoEoCe52.getOutputStream());
			Bzp8CSGw.print(RUgYs5Ew);
			Bzp8CSGw.flush();
			Bzp8CSGw.close();
			InputStream cGvb5nBt = uoEoCe52.getInputStream();
			LcndjXmI = new byte[uoEoCe52.getContentLength()];
			cGvb5nBt.read(LcndjXmI);
			cGvb5nBt.close();
			MsgPrint.showByteArray("result", LcndjXmI);
		} catch (Exception ntkbMnfl) {
			return new byte[] { 0, 0, 0, 0 };
		}
		return LcndjXmI;
	}

}