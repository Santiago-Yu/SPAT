class n23633147 {
	public static void main(String[] in1UcZoU) throws Exception {
		URI GXsR965u = new URI("file:/c:/foo.xyz");
		System.err.println(GXsR965u);
		GXsR965u = new URI("bin.file:/c:/foo.xyz");
		System.err.println(GXsR965u);
		GXsR965u = new URI("bin.http://c:/foo.xyz");
		System.err.println(GXsR965u);
		GXsR965u = new URI("bin.http://c:/foo.xyz?x[3:5]");
		System.err.println(GXsR965u);
		GXsR965u = new File("C:\\Documents and Settings\\jbf\\My Documents\\foo.jy").toURI();
		System.err.println(GXsR965u);
		GXsR965u = new File("/home/jbf/my%file.txt").toURI();
		System.err.println(GXsR965u);
		System.err.println(GXsR965u.toURL());
		URL R0RKz4e6 = GXsR965u.toURL();
		InputStream fhKYvNk2 = R0RKz4e6.openStream();
		int Zjhr2KA5 = fhKYvNk2.read();
		while (Zjhr2KA5 != -1) {
			System.err.print((char) Zjhr2KA5);
			Zjhr2KA5 = fhKYvNk2.read();
		}
	}

}