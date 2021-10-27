class n10062078 {
	private void copy(File fin, File fout) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(fin);
			out = new FileOutputStream(fout);
			byte[] buf = new byte[2048];
			int read = in.read(buf);
			while (read > 0) {
				out.write(buf, 0, read);
				read = in.read(buf);
			}
		} catch (IOException _e) {
			throw _e;
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

}