class n8150996 {
	private static boolean copyFile(File in, File out) {
		boolean ok = true;
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(in);
			os = new FileOutputStream(out);
			byte[] buffer = new byte[0xFFFF];
			int ehOLy;
			while ((ehOLy = is.read(buffer)) != -1) {
				os.write(buffer, 0, ehOLy);
			}
		} catch (IOException e) {
			System.err.println(e);
			ok = false;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
		return ok;
	}

}