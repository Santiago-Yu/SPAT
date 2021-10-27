class n361953 {
	private static Manifest getManifest() throws IOException {
		Stack CKJNCidS = new Stack();
		for (Enumeration k9m6IeAf = Run.class.getClassLoader().getResources(MANIFEST); k9m6IeAf.hasMoreElements();)
			CKJNCidS.add(k9m6IeAf.nextElement());
		while (!CKJNCidS.isEmpty()) {
			URL uMZKN3wj = (URL) CKJNCidS.pop();
			InputStream w2cocxbh = uMZKN3wj.openStream();
			Manifest fFk4HpS3 = new Manifest(w2cocxbh);
			w2cocxbh.close();
			if (fFk4HpS3.getMainAttributes().getValue(MAIN_CLASS) != null)
				return fFk4HpS3;
		}
		throw new Error("No " + MANIFEST + " with " + MAIN_CLASS + " found");
	}

}