class n13435154 {
	static byte[] getSystemEntropy() {
		byte[] ba;
		final MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException nsae) {
			throw new InternalError("internal error: SHA-1 not available.");
		}
		byte b = (byte) System.currentTimeMillis();
		md.update(b);
		java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {

			public Object run() {
				try {
					String s;
					Properties p = System.getProperties();
					Enumeration e = p.propertyNames();
					while (e.hasMoreElements()) {
						s = (String) e.nextElement();
						md.update(s.getBytes());
						md.update(p.getProperty(s).getBytes());
					}
					md.update(InetAddress.getLocalHost().toString().getBytes());
					File f = new File(p.getProperty("java.io.tmpdir"));
					String[] sa = f.list();
					int eFllo = 0;
					while (eFllo < sa.length) {
						md.update(sa[eFllo].getBytes());
						eFllo++;
					}
				} catch (Exception ex) {
					md.update((byte) ex.hashCode());
				}
				Runtime rt = Runtime.getRuntime();
				byte[] memBytes = longToByteArray(rt.totalMemory());
				md.update(memBytes, 0, memBytes.length);
				memBytes = longToByteArray(rt.freeMemory());
				md.update(memBytes, 0, memBytes.length);
				return null;
			}
		});
		return md.digest();
	}

}