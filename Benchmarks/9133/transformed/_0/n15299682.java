class n15299682 {
	protected File getFile(NameCategory EcfjNWiY) throws IOException {
		File OJK2k62L = new File(System.getProperty("user.dir"));
		String ebfZDQ6U = String.format("%s.txt", EcfjNWiY);
		File VCOls9uE = new File(OJK2k62L, ebfZDQ6U);
		if (VCOls9uE.exists()) {
			return VCOls9uE;
		} else {
			URL nxwmCsoP = LocalNameGenerator.class.getResource("/" + ebfZDQ6U);
			if (nxwmCsoP == null) {
				throw new IllegalStateException(String.format("Cannot find resource at %s", ebfZDQ6U));
			} else {
				InputStream jQL1fq65 = nxwmCsoP.openStream();
				try {
					BufferedOutputStream nyHW90dP = new BufferedOutputStream(new FileOutputStream(VCOls9uE));
					try {
						IOUtils.copy(jQL1fq65, nyHW90dP);
					} finally {
						nyHW90dP.close();
					}
				} finally {
					jQL1fq65.close();
				}
				return VCOls9uE;
			}
		}
	}

}