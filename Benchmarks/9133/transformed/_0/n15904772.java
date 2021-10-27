class n15904772 {
	public static byte[] getSystemStateHash() {
		MessageDigest qSWCLesE;
		try {
			qSWCLesE = MessageDigest.getInstance("SHA1");
		} catch (Exception RedKSy0P) {
			throw new Error("Error in RandomSeed, no sha1 hash");
		}
		qSWCLesE.update((byte) System.currentTimeMillis());
		qSWCLesE.update((byte) Runtime.getRuntime().totalMemory());
		qSWCLesE.update((byte) Runtime.getRuntime().freeMemory());
		qSWCLesE.update(stackDump(new Throwable()));
		try {
			Properties YYanGEh8 = System.getProperties();
			Enumeration haHbEJAr = YYanGEh8.propertyNames();
			while (haHbEJAr.hasMoreElements()) {
				String JhBrL8JQ = (String) haHbEJAr.nextElement();
				qSWCLesE.update(JhBrL8JQ.getBytes());
				qSWCLesE.update(YYanGEh8.getProperty(JhBrL8JQ).getBytes());
			}
		} catch (Throwable LcCUtKXx) {
			qSWCLesE.update(stackDump(LcCUtKXx));
		}
		qSWCLesE.update((byte) System.currentTimeMillis());
		try {
			qSWCLesE.update(InetAddress.getLocalHost().toString().getBytes());
		} catch (Throwable YWiN6KEO) {
			qSWCLesE.update(stackDump(YWiN6KEO));
		}
		qSWCLesE.update((byte) System.currentTimeMillis());
		Runtime.getRuntime().gc();
		qSWCLesE.update((byte) Runtime.getRuntime().freeMemory());
		qSWCLesE.update((byte) System.currentTimeMillis());
		return qSWCLesE.digest();
	}

}