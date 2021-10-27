class n8490297 {
	public static void copyFile(File src, File dst) throws IOException {
		try {
			OutputStream out = new FileOutputStream(dst);
			InputStream in = new FileInputStream(src);
			int len;
			byte[] buf = new byte[TEMP_FILE_BUFFER_SIZE];
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
			in.close();
			out.close();
		} catch (FileNotFoundException e1) {
			MLUtil.runtimeError(e1, src.toString());
		} catch (IOException e2) {
			MLUtil.runtimeError(e2, src.toString());
		}
	}

}