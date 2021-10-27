class n7713594 {
	private static void copyFile(File source, File dest, boolean visibleFilesOnly) throws IOException {
		if (visibleFilesOnly && isHiddenOrDotFile(source)) {
			return;
		}
		FileChannel in = null, out = null;
		if (dest.exists()) {
			System.err.println("Destination File Already Exists: " + dest);
		}
		try {
			in = new FileInputStream(source).getChannel();
			out = new FileOutputStream(dest).getChannel();
			in.transferTo(0, in.size(), out);
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