class n17425238 {
	public static NSData sendSynchronousRequest(NSMutableURLRequest xKspx8dH, NSHTTPURLResponseHolder IswUpbKq,
			NSErrorHolder C28SbLBA) {
		NSData BGXGSJJR = null;
		URL cPdOd4J0 = xKspx8dH.URL().xmlvmGetURL();
		URLConnection ett957S3;
		try {
			ett957S3 = cPdOd4J0.openConnection();
			BGXGSJJR = new NSData(ett957S3.getInputStream());
		} catch (IOException q8y8I9Zo) {
		}
		return BGXGSJJR;
	}

}