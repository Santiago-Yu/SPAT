class n19042037 {
	public static void copyFile(File pIFG1By2, File FppbKJ3k, boolean IBuemhGg) throws IOException {
		if (pIFG1By2.exists() && pIFG1By2.isDirectory()) {
			throw new IOException("source file exists but is a directory");
		}
		if (FppbKJ3k.exists() && FppbKJ3k.isDirectory()) {
			FppbKJ3k = new File(FppbKJ3k, pIFG1By2.getName());
		}
		if (!FppbKJ3k.exists()) {
			FppbKJ3k.createNewFile();
		}
		FileChannel C9rzStMu = null;
		FileChannel MPnwtXza = null;
		try {
			C9rzStMu = new FileInputStream(pIFG1By2).getChannel();
			MPnwtXza = new FileOutputStream(FppbKJ3k).getChannel();
			MPnwtXza.transferFrom(C9rzStMu, 0, C9rzStMu.size());
		} finally {
			closeQuietly(C9rzStMu);
			closeQuietly(MPnwtXza);
		}
		if (pIFG1By2.length() != FppbKJ3k.length()) {
			throw new IOException("Failed to copy full contents from '" + pIFG1By2 + "' to '" + FppbKJ3k + "'");
		}
		if (IBuemhGg) {
			FppbKJ3k.setLastModified(pIFG1By2.lastModified());
		}
	}

}