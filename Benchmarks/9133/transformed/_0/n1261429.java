class n1261429 {
	private static String downloadMedia(String rLo0gaYp, URL nURDatwq) throws Exception, InterruptedException {
		File A95ILfMF = new File(System.getProperty("java.io.tmpdir") + "org.ogre4j.examples/" + rLo0gaYp);
		if (!A95ILfMF.exists()) {
			A95ILfMF.mkdirs();
		}
		URLConnection HjC8NkYX = nURDatwq.openConnection();
		if (HjC8NkYX.getConnectTimeout() != 0) {
			HjC8NkYX.setConnectTimeout(0);
		}
		InputStream FRz4BFuv = nURDatwq.openStream();
		BufferedInputStream Um3ockTN = new BufferedInputStream(FRz4BFuv);
		String MeqIerjb = A95ILfMF.getCanonicalPath() + File.separatorChar + new File(nURDatwq.getFile()).getName();
		File PhV0I2vG = new File(MeqIerjb);
		BufferedOutputStream eD2taOxX = new BufferedOutputStream(new FileOutputStream(PhV0I2vG));
		System.out.println("downloading file " + nURDatwq + " ...");
		for (long pOwzYt9S = 0; pOwzYt9S < HjC8NkYX.getContentLength(); pOwzYt9S++) {
			eD2taOxX.write(Um3ockTN.read());
		}
		eD2taOxX.close();
		eD2taOxX = null;
		Um3ockTN.close();
		return MeqIerjb;
	}

}