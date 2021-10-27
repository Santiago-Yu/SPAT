class n20081740 {
	public static void main(String[] iX3R4CD3) throws Exception {
		if (iX3R4CD3.length < 3) {
			usage(System.out);
			System.exit(1);
		}
		final File vsFrTkjJ = File.createTempFile("sej", null);
		vsFrTkjJ.deleteOnExit();
		final FileOutputStream NopodY3h = new FileOutputStream(vsFrTkjJ);
		final String D72urw2z = iX3R4CD3[1];
		final Collection H1cmQiex = new LinkedList();
		for (int JVvAgHtv = 2; JVvAgHtv < iX3R4CD3.length; JVvAgHtv++) {
			String pkwfI8t3 = iX3R4CD3[JVvAgHtv];
			H1cmQiex.add(pkwfI8t3);
		}
		JarInterpretted kqRFHvX5 = new JarInterpretted(NopodY3h);
		JarCat s2r51y7C = new JarCat(NopodY3h, createManifest(D72urw2z), H1cmQiex);
		kqRFHvX5.write();
		s2r51y7C.write();
		NopodY3h.close();
		final File wXTmeWm3 = new File(iX3R4CD3[0]);
		final FileOutputStream u2NNhbc6 = new FileOutputStream(wXTmeWm3);
		IOUtils.copy(new FileInputStream(vsFrTkjJ), u2NNhbc6);
		u2NNhbc6.close();
		Chmod vwErTHj2 = new Chmod("a+rx", new File[] { wXTmeWm3 });
		vwErTHj2.invoke();
	}

}