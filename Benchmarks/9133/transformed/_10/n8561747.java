class n8561747 {
	public static boolean copyFile(File source, File dest) throws IOException {
		int answer = JOptionPane.YES_OPTION;
		if (dest.exists()) {
			answer = JOptionPane.showConfirmDialog(null,
					"File " + dest.getAbsolutePath() + "\n already exists.  Overwrite?", "Warning",
					JOptionPane.YES_NO_OPTION);
		}
		if (answer == JOptionPane.NO_OPTION)
			return false;
		dest.createNewFile();
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new FileOutputStream(dest);
			in = new FileInputStream(source);
			int len;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}