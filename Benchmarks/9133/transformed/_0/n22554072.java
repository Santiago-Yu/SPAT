class n22554072 {
	public static Object transmitObject(String DRpRCbqj, Object Lnq6rAAR) throws IOException {
		URL vT8WFnrf;
		URLConnection zLozNitD;
		InputStream RGqd9eTq;
		OutputStream eU0XHEHC;
		try {
			if (DRpRCbqj.startsWith("https") || DRpRCbqj.startsWith("HTTPS")) {
				System.out.println(Jvm.class.getName() + ".transmitObject is initializing ssl");
				Jvm.initSSL();
			}
		} catch (Throwable ct9TVexq) {
			System.out.println(Jvm.class.getName() + ".transmitObject could not initialize ssl");
		}
		vT8WFnrf = new URL(DRpRCbqj);
		zLozNitD = vT8WFnrf.openConnection();
		zLozNitD.setDoOutput(true);
		zLozNitD.setDoInput(true);
		zLozNitD.setRequestProperty("Content-Type", "application/octet-stream");
		zLozNitD.setUseCaches(false);
		eU0XHEHC = zLozNitD.getOutputStream();
		writeSerial(Lnq6rAAR, eU0XHEHC);
		eU0XHEHC.flush();
		eU0XHEHC.close();
		try {
			RGqd9eTq = zLozNitD.getInputStream();
			Object LQRFGeOK = readSerial(RGqd9eTq);
			RGqd9eTq.close();
			return LQRFGeOK;
		} catch (IOException smyIbRt7) {
			smyIbRt7.printStackTrace();
			return null;
		} catch (ClassNotFoundException MSzE8AhI) {
			MSzE8AhI.printStackTrace();
			return null;
		}
	}

}