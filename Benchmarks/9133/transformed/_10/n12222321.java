class n12222321 {
	public static long copyFile(File source, File target) throws IOException {
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		try {
			fileOutputStream = new FileOutputStream(target);
			fileInputStream = new FileInputStream(source);
			FileChannel in = fileInputStream.getChannel();
			FileChannel out = fileOutputStream.getChannel();
			return out.transferFrom(in, 0, source.length());
		} finally {
			if (fileInputStream != null)
				fileInputStream.close();
			if (fileOutputStream != null)
				fileOutputStream.close();
		}
	}

}