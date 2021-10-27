class n8400605 {
	public static void copyFile(String pathOrig, String pathDst) throws FileNotFoundException, IOException {
		OutputStream out;
		InputStream in;
		if (pathOrig == null || pathDst == null) {
			System.err.println("Error en path");
			return;
		}
		File orig = new File(pathOrig);
		File dest = new File(pathDst);
		if (!orig.exists() || !orig.isFile() || !orig.canRead()) {
			System.err.println("Error en fichero de origen");
			return;
		}
		String file = new File(pathOrig).getName();
		in = new FileInputStream(pathOrig);
		if (dest.isDirectory())
			pathDst += file;
		byte[] buf = new byte[1024];
		out = new FileOutputStream(pathDst);
		int len;
		while ((len = in.read(buf)) > 0)
			out.write(buf, 0, len);
		in.close();
		out.close();
	}

}