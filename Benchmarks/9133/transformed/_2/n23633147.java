class n23633147 {
	public static void main(String[] args) throws Exception {
		URI uri = new URI("file:/c:/foo.xyz");
		System.err.println(uri);
		uri = new URI("bin.file:/c:/foo.xyz");
		System.err.println(uri);
		uri = new URI("bin.http://c:/foo.xyz");
		System.err.println(uri);
		uri = new URI("bin.http://c:/foo.xyz?x[3:5]");
		System.err.println(uri);
		uri = new File("C:\\Documents and Settings\\jbf\\My Documents\\foo.jy").toURI();
		System.err.println(uri);
		uri = new File("/home/jbf/my%file.txt").toURI();
		System.err.println(uri);
		System.err.println(uri.toURL());
		URL url = uri.toURL();
		InputStream in = url.openStream();
		int ch = in.read();
		for (; ch != -1;) {
			System.err.print((char) ch);
			ch = in.read();
		}
	}

}