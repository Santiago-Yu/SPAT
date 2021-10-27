class n10478671 {
	private void copyFile(File sourcefile, File targetfile) {
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(targetfile));
			in = new BufferedInputStream(new FileInputStream(sourcefile));
			int bytesread = 0;
			byte[] buffer = new byte[4096];
			while ((bytesread = in.read(buffer)) >= 0) {
				out.write(buffer, 0, bytesread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}