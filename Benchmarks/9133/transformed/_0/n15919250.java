class n15919250 {
	private static byte[] loadBytecodePrivileged() {
		URL uqXKL2Ps = SecureCaller.class.getResource("SecureCallerImpl.clazz");
		try {
			InputStream zp2wUbup = uqXKL2Ps.openStream();
			try {
				ByteArrayOutputStream WmsC2kls = new ByteArrayOutputStream();
				for (;;) {
					int AZnZjbNE = zp2wUbup.read();
					if (AZnZjbNE == -1) {
						return WmsC2kls.toByteArray();
					}
					WmsC2kls.write(AZnZjbNE);
				}
			} finally {
				zp2wUbup.close();
			}
		} catch (IOException lp4V16tE) {
			throw new UndeclaredThrowableException(lp4V16tE);
		}
	}

}