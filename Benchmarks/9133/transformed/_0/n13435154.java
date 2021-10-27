class n13435154 {
	static byte[] getSystemEntropy() {
		byte[] RjzUXw3M;
		final MessageDigest ZqQiVk7j;
		try {
			ZqQiVk7j = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException AAqBAeTW) {
			throw new InternalError("internal error: SHA-1 not available.");
		}
		byte tgDUJ306 = (byte) System.currentTimeMillis();
		ZqQiVk7j.update(tgDUJ306);
		java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {

			public Object run() {
				try {
					String eWgCcCSN;
					Properties ANw96UIv = System.getProperties();
					Enumeration itCz1SCB = ANw96UIv.propertyNames();
					while (itCz1SCB.hasMoreElements()) {
						eWgCcCSN = (String) itCz1SCB.nextElement();
						ZqQiVk7j.update(eWgCcCSN.getBytes());
						ZqQiVk7j.update(ANw96UIv.getProperty(eWgCcCSN).getBytes());
					}
					ZqQiVk7j.update(InetAddress.getLocalHost().toString().getBytes());
					File lTgYlInP = new File(ANw96UIv.getProperty("java.io.tmpdir"));
					String[] o4oNOKha = lTgYlInP.list();
					for (int ofGPIfV5 = 0; ofGPIfV5 < o4oNOKha.length; ofGPIfV5++)
						ZqQiVk7j.update(o4oNOKha[ofGPIfV5].getBytes());
				} catch (Exception tNi249yD) {
					ZqQiVk7j.update((byte) tNi249yD.hashCode());
				}
				Runtime Ro3Hau0X = Runtime.getRuntime();
				byte[] WonoKSLZ = longToByteArray(Ro3Hau0X.totalMemory());
				ZqQiVk7j.update(WonoKSLZ, 0, WonoKSLZ.length);
				WonoKSLZ = longToByteArray(Ro3Hau0X.freeMemory());
				ZqQiVk7j.update(WonoKSLZ, 0, WonoKSLZ.length);
				return null;
			}
		});
		return ZqQiVk7j.digest();
	}

}