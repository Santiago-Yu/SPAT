class n9756366 {
	public static void copyFile(File sGWrWZdj, File z0a8XnrJ) throws IOException {
		if (!(sGWrWZdj.exists() && sGWrWZdj.isFile()))
			throw new IllegalArgumentException("Source file doesn't exist: " + sGWrWZdj.getAbsolutePath());
		if (z0a8XnrJ.exists() && z0a8XnrJ.isDirectory())
			throw new IllegalArgumentException("Destination file is directory: " + z0a8XnrJ.getAbsolutePath());
		FileInputStream O1Qe5Dw8 = new FileInputStream(sGWrWZdj);
		FileOutputStream VKLSB628 = new FileOutputStream(z0a8XnrJ);
		byte[] LYUVprnR = new byte[4096];
		int xkO8Tg1U = 0;
		try {
			while ((xkO8Tg1U = O1Qe5Dw8.read(LYUVprnR)) != -1)
				VKLSB628.write(LYUVprnR, 0, xkO8Tg1U);
		} finally {
			O1Qe5Dw8.close();
			VKLSB628.close();
		}
	}

}