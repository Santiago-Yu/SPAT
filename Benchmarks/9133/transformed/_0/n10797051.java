class n10797051 {
	private static void copy(File D2u98PjF, File o7fzIYFJ) throws IOException {
		if (!o7fzIYFJ.getParentFile().isDirectory())
			o7fzIYFJ.getParentFile().mkdirs();
		FileChannel ANOJvFH7 = new FileInputStream(D2u98PjF).getChannel();
		FileChannel tTneCbOd = new FileOutputStream(o7fzIYFJ).getChannel();
		ANOJvFH7.transferTo(0, ANOJvFH7.size(), tTneCbOd);
		ANOJvFH7.close();
		tTneCbOd.close();
	}

}