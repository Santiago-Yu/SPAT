class n11776522 {
	protected File getFile(NameCategory lumSDLZP) throws IOException {
		File anAd69pu = new File(System.getProperty("user.dir"));
		String NuvIyX8D = String.format("%s.txt", lumSDLZP);
		File ZOGDURAy = new File(anAd69pu, NuvIyX8D);
		if (ZOGDURAy.exists()) {
			return ZOGDURAy;
		} else {
			URL HAVEKCPp = DefaultNameGenerator.class.getResource("/sc/common/" + NuvIyX8D);
			if (HAVEKCPp == null) {
				throw new IllegalStateException(String.format("Cannot find resource at %s", NuvIyX8D));
			} else {
				InputStream TAIFtjJV = HAVEKCPp.openStream();
				try {
					BufferedOutputStream eoEq2rSq = new BufferedOutputStream(new FileOutputStream(ZOGDURAy));
					try {
						IOUtils.copy(TAIFtjJV, eoEq2rSq);
					} finally {
						eoEq2rSq.close();
					}
				} finally {
					TAIFtjJV.close();
				}
				return ZOGDURAy;
			}
		}
	}

}