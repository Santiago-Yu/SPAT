class n8561747 {
	public static boolean copyFile(File source, File dest) throws IOException {
		int answer = JOptionPane.YES_OPTION;
		answer = (dest.exists()) ? JOptionPane.showConfirmDialog(null,
				"File " + dest.getAbsolutePath() + "\n already exists.  Overwrite?", "Warning",
				JOptionPane.YES_NO_OPTION) : answer;
		if (answer == JOptionPane.NO_OPTION)
			return false;
		dest.createNewFile();
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int len;
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