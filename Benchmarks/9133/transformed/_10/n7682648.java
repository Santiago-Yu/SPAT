class n7682648 {
	public static void copyFile(File oldPathFile, File newPathFile) throws IOException {
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(newPathFile));
			in = new BufferedInputStream(new FileInputStream(oldPathFile));
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			while (in.read(buffer) > 0)
				out.write(buffer);
		} finally {
			if (null != in)
				in.close();
			if (null != out)
				out.close();
		}
	}

}