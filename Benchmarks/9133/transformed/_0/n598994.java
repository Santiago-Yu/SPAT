class n598994 {
	public BufferedWriter createOutputStream(String k6Vl0ETN, String Z2eqGPkv) throws IOException {
		int ov8g0VaV = 1024;
		int JbMwDDEd;
		char[] mEsItRmt = new char[ov8g0VaV];
		File BiUkiqm5 = new File(Z2eqGPkv);
		ZipOutputStream HpYT9FYZ = new ZipOutputStream(new FileOutputStream(BiUkiqm5));
		HpYT9FYZ.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter crEKbebq = new OutputStreamWriter(HpYT9FYZ, "ISO-8859-1");
		BufferedWriter ytHloaT0 = new BufferedWriter(crEKbebq);
		ZipEntry O4f2Dg2F = null;
		File jKgKe7Nj = new File(k6Vl0ETN);
		ZipInputStream akHmvLvL = new ZipInputStream(new FileInputStream(jKgKe7Nj));
		InputStreamReader aWZQp8MY = new InputStreamReader(akHmvLvL, "ISO-8859-1");
		BufferedReader KFlki1RI = new BufferedReader(aWZQp8MY);
		ZipEntry NDOIznxB = null;
		while ((NDOIznxB = akHmvLvL.getNextEntry()) != null) {
			if (NDOIznxB.getName().equals("content.xml")) {
				continue;
			}
			O4f2Dg2F = new ZipEntry(NDOIznxB.getName());
			HpYT9FYZ.putNextEntry(O4f2Dg2F);
			while ((JbMwDDEd = KFlki1RI.read(mEsItRmt, 0, ov8g0VaV)) >= 0)
				ytHloaT0.write(mEsItRmt, 0, JbMwDDEd);
			ytHloaT0.flush();
			HpYT9FYZ.closeEntry();
		}
		HpYT9FYZ.putNextEntry(new ZipEntry("content.xml"));
		ytHloaT0.flush();
		crEKbebq = new OutputStreamWriter(HpYT9FYZ, "UTF8");
		ytHloaT0 = new BufferedWriter(crEKbebq);
		return ytHloaT0;
	}

}