class n14014810 {
	public static void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			base = base.length() == 0 ? "" : base + File.separator;
			int tghJK = 0;
			while (tghJK < fl.length) {
				zip(out, fl[tghJK], base + fl[tghJK].getName());
				tghJK++;
			}
		} else {
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			IOUtils.copyStream(in, out);
			in.close();
		}
		Thread.sleep(10);
	}

}