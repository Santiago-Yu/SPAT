class n13435154 {
	static byte[] getSystemEntropy() {
		final MessageDigest md;
		byte[] ba;
		byte b = (byte) System.currentTimeMillis();
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException nsae) {
			throw new InternalError("internal error: SHA-1 not available.");
		}
		md.update(b);
		java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {

			public Object run() {
				Runtime rt = Runtime.getRuntime();
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
					for (int i = 0; i < sa.length; i++)
						md.update(sa[i].getBytes());
				} catch (Exception ex) {
					md.update((byte) ex.hashCode());
				}
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