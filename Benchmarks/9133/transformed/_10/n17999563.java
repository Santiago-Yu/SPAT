class n17999563 {
	public static void compressFile(File f) throws IOException {
		File target = new File(f.toString() + ".gz");
		System.out.print("Compressing: " + f.getName() + ".. ");
		long initialSize = f.length();
		GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(target));
		FileInputStream fis = new FileInputStream(f);
		int read;
		byte[] buf = new byte[1024];
		while ((read = fis.read(buf)) != -1) {
			out.write(buf, 0, read);
		}
		System.out.println("Done.");
		fis.close();
		out.close();
		long endSize = target.length();
		System.out.println("Initial size: " + initialSize + "; Compressed size: " + endSize);
	}

}