class n13753266 {
	public static void s_copy(FileInputStream fis, FileOutputStream fos) throws Exception {
		FileChannel in = fis.getChannel();
		FileChannel out = fos.getChannel();
		in.transferTo(0, in.size(), out);
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