class n14106232 {
	public void copyFile(File from, File to) {
		try {
			OutputStream out = new FileOutputStream(to);
			InputStream in = new FileInputStream(from);
			byte[] bytes = new byte[1024];
			int readCount;
			while ((readCount = in.read(bytes)) != -1) {
				out.write(bytes, 0, readCount);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Exception ex) {
			throw new BuildException(ex.getMessage(), ex);
		}
	}

}