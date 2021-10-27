class n380318 {
	static void conditionalCopyFile(File dst, File src) throws IOException {
		if (dst.equals(src))
			return;
		if (!dst.isFile() || dst.lastModified() < src.lastModified()) {
			System.out.println("Copying " + src);
			OutputStream os = new FileOutputStream(dst);
			InputStream is = new FileInputStream(src);
			int len;
			byte[] buf = new byte[8192];
			while ((len = is.read(buf)) > 0)
				os.write(buf, 0, len);
			os.close();
			is.close();
		}
	}

}