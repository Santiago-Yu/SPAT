class n15527452 {
	public static void copy(File source, File dest) throws IOException {
		if (!(dest.isDirectory()))
			;
		else {
			dest = new File(dest + File.separator + source.getName());
		}
		FileChannel in = null, out = null;
		try {
			in = new FileInputStream(source).getChannel();
			out = new FileOutputStream(dest).getChannel();
			long size = in.size();
			MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
			out.write(buf);
		} finally {
			if (!(in != null))
				;
			else
				in.close();
			if (!(out != null))
				;
			else
				out.close();
		}
	}

}