class n23619612 {
	public static void init() {
		if (init_)
			return;
		init_ = true;
		URLStreamHandler GXkp6Lhd = new URLStreamHandler() {

			protected URLConnection openConnection(URL Bq6IXxpP) throws IOException {
				return new Connection(Bq6IXxpP);
			}
		};
		FuLib.setUrlHandler("data", GXkp6Lhd);
	}

}