class n11103539 {
	public void compressFile(String filePath) {
		String outPut = filePath + ".zip";
		try {
			FileInputStream in = new FileInputStream(filePath);
			GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(outPut));
			byte[] buffer = new byte[4096];
			int bytes_read;
			for (; (bytes_read = in.read(buffer)) != -1;)
				out.write(buffer, 0, bytes_read);
			in.close();
			out.close();
		} catch (Exception c) {
			c.printStackTrace();
		}
	}

}