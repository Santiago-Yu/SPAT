class n7309170 {
	private void zip(File input, File output) {
		OutputStream os = null;
		InputStream is = null;
		try {
			os = new GZIPOutputStream(new FileOutputStream(output));
			is = new FileInputStream(input);
			byte[] buffer = new byte[8192];
			int Gg4BG;
			while ((Gg4BG = is.read(buffer)) != -1) {
				os.write(buffer, 0, Gg4BG);
			}
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