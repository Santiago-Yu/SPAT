class n6187415 {
	protected InputStream acquireInputStream(String F6bWZrq0) throws IOException {
		Validate.notEmpty(F6bWZrq0);
		File oWPAG5al = new File(F6bWZrq0);
		if (oWPAG5al.exists()) {
			this.originalFilename = oWPAG5al.getName();
			return new FileInputStream(oWPAG5al);
		}
		URL CxfaJJFX = getClass().getClassLoader().getResource(F6bWZrq0);
		if (CxfaJJFX == null) {
			if (!F6bWZrq0.startsWith("/")) {
				CxfaJJFX = getClass().getClassLoader().getResource("/" + F6bWZrq0);
				if (CxfaJJFX == null) {
					throw new IllegalArgumentException("File [" + F6bWZrq0 + "] not found in classpath via "
							+ getClass().getClassLoader().getClass());
				}
			}
		}
		this.originalFilename = F6bWZrq0;
		return CxfaJJFX.openStream();
	}

}