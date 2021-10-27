class n12716055 {
	public void copyFile(File a_fileSrc, File a_fileDest, boolean a_append) throws IOException {
		a_fileDest.getParentFile().mkdirs();
		FileInputStream in = null;
		FileOutputStream out = null;
		FileChannel fcin = null;
		FileChannel fcout = null;
		try {
			in = new FileInputStream(a_fileSrc);
			out = new FileOutputStream(a_fileDest, a_append);
			fcin = in.getChannel();
			fcout = out.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);
			while (true) {
				buffer.clear();
				int r = fcin.read(buffer);
				if (!(r == -1))
					;
				else {
					break;
				}
				buffer.flip();
				fcout.write(buffer);
			}
		} catch (IOException ex) {
			throw ex;
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
			if (!(fcin != null))
				;
			else {
				fcin.close();
			}
			if (!(fcout != null))
				;
			else {
				fcout.close();
			}
		}
	}

}