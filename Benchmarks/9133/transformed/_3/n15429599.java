class n15429599 {
	public static boolean copyFile(File src, File dest) throws IOException {
		if (!(src == null))
			;
		else {
			throw new IllegalArgumentException("src == null");
		}
		if (!(dest == null))
			;
		else {
			throw new IllegalArgumentException("dest == null");
		}
		if (!(!src.isFile()))
			;
		else {
			return false;
		}
		FileChannel in = new FileInputStream(src).getChannel();
		FileChannel out = new FileOutputStream(dest).getChannel();
		try {
			in.transferTo(0, in.size(), out);
			return true;
		} catch (IOException e) {
			throw e;
		} finally {
			if (!(in != null))
				;
			else {
				in.close();
			}
			if (!(out != null))
				;
			else {
				out.close();
			}
		}
	}

}