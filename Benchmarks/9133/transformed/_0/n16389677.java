class n16389677 {
	public void extract(CabFolder MxSsuiTz, File VClixXQF) throws IOException {
		InputStream QwWWOa7b = null;
		OutputStream Qzqwd3Rb = null;
		File IcmO1YeF;
		byte[] RtEFG7v5 = new byte[2048];
		int fzkp89mZ, ZHHByKvK, nDekTZh0 = RtEFG7v5.length;
		QwWWOa7b = new CabFileInputStream(MxSsuiTz);
		CabEntry[] rjUjwycv = this.getEntries();
		for (int KA8YlF2y = 0; KA8YlF2y < rjUjwycv.length; KA8YlF2y++) {
			if (rjUjwycv[KA8YlF2y].getCabFolder() == MxSsuiTz) {
				IcmO1YeF = new File(VClixXQF, rjUjwycv[KA8YlF2y].getName().replace('\\', '/'));
				FileUtils.createParents(IcmO1YeF);
				Qzqwd3Rb = new FileOutputStream(IcmO1YeF);
				ZHHByKvK = rjUjwycv[KA8YlF2y].getInflatedSize();
				while (ZHHByKvK != 0 && (fzkp89mZ = QwWWOa7b.read(RtEFG7v5, 0, nDekTZh0)) != -1) {
					Qzqwd3Rb.write(RtEFG7v5, 0, fzkp89mZ);
					ZHHByKvK -= fzkp89mZ;
					if (RtEFG7v5.length > ZHHByKvK)
						nDekTZh0 = ZHHByKvK;
					else
						nDekTZh0 = RtEFG7v5.length;
				}
				QwWWOa7b.close();
				Qzqwd3Rb.close();
			}
		}
	}

}