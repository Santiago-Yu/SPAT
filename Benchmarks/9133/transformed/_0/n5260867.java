class n5260867 {
	public BufferedWriter createWriter(File lgPFv1lc, String cWpoq57s)
			throws UnsupportedEncodingException, IOException {
		int FaVW96Um = 1024;
		int W5HTM3ac;
		char[] npE8X43U = new char[FaVW96Um];
		ZipOutputStream etYhfq7J = new ZipOutputStream(new FileOutputStream(lgPFv1lc));
		etYhfq7J.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter F0QEdj7g = new OutputStreamWriter(etYhfq7J, "ISO-8859-1");
		BufferedWriter PHP7xd3e = new BufferedWriter(F0QEdj7g);
		ZipEntry YpsmygnA;
		ZipInputStream NaCcyL5b = new ZipInputStream(new FileInputStream(infile));
		InputStreamReader agFgYb1j = new InputStreamReader(NaCcyL5b, "ISO-8859-1");
		BufferedReader vBbh9jfb = new BufferedReader(agFgYb1j);
		ZipEntry Va3nX3jz;
		while ((Va3nX3jz = NaCcyL5b.getNextEntry()) != null) {
			if (Va3nX3jz.getName().equals("content.xml")) {
				continue;
			}
			YpsmygnA = new ZipEntry(Va3nX3jz.getName());
			etYhfq7J.putNextEntry(YpsmygnA);
			while ((W5HTM3ac = vBbh9jfb.read(npE8X43U, 0, FaVW96Um)) >= 0)
				PHP7xd3e.write(npE8X43U, 0, W5HTM3ac);
			PHP7xd3e.flush();
			etYhfq7J.closeEntry();
		}
		etYhfq7J.putNextEntry(new ZipEntry("content.xml"));
		PHP7xd3e.flush();
		return new BufferedWriter(new OutputStreamWriter(etYhfq7J, "UTF-8"));
	}

}