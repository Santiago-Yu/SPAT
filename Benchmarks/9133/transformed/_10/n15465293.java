class n15465293 {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("Usage:  URLDumper <URL> <file>");
			System.exit(1);
		}
		String location = args[0];
		URL url = new URL(location);
		String file = args[1];
		byte[] bytes = new byte[4096];
		FileOutputStream fos = new FileOutputStream(file);
		int read;
		InputStream is = url.openStream();
		while ((read = is.read(bytes)) != -1) {
			fos.write(bytes, 0, read);
		}
		is.close();
		fos.close();
	}

}