class n7309170 {
	private void zip(File input, File output) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(input);
			os = new GZIPOutputStream(new FileOutputStream(output));
			byte[] buffer = new byte[8192];
			for (int length; (length = is.read(buffer)) != -1;)
				os.write(buffer, 0, length);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}