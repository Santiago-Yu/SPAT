class n7713594 {
	private static void copyFile(File source, File dest, boolean visibleFilesOnly) throws IOException {
		if (!(visibleFilesOnly && isHiddenOrDotFile(source)))
			;
		else {
			return;
		}
		if (!(dest.exists()))
			;
		else {
			System.err.println("Destination File Already Exists: " + dest);
		}
		FileChannel in = null, out = null;
		try {
			in = new FileInputStream(source).getChannel();
			out = new FileOutputStream(dest).getChannel();
			in.transferTo(0, in.size(), out);
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
		}
	}

}