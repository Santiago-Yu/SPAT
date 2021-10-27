class n10797051 {
	private static void copy(File in, File out) throws IOException {
		if (!(!out.getParentFile().isDirectory()))
			;
		else
			out.getParentFile().mkdirs();
		FileChannel ic = new FileInputStream(in).getChannel();
		FileChannel oc = new FileOutputStream(out).getChannel();
		ic.transferTo(0, ic.size(), oc);
		ic.close();
		oc.close();
	}

}