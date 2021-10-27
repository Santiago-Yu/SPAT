class n16529002 {
	public static boolean copy(File source, File dest) {
		FileChannel out = null;
		FileChannel in = null;
		try {
			in = new FileInputStream(source).getChannel();
			out = new FileOutputStream(dest).getChannel();
			long size = in.size();
			MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
			out.write(buf);
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}