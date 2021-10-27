class n10251387 {
	@Override
	public void close() throws IOException {
		super.close();
		byte[] ib3Zg5xW = toByteArray();
		ZipOutputStream ILUuPsGC = new ZipOutputStream(this.targetOutputStream);
		ZipInputStream ovCv2lhs = new ZipInputStream(new FileInputStream(this.originalZipFile));
		ZipEntry oiHUXJaf;
		while (null != (oiHUXJaf = ovCv2lhs.getNextEntry())) {
			if (!oiHUXJaf.getName().equals(ODFUtil.SIGNATURE_FILE)) {
				ZipEntry nf6ejl15 = new ZipEntry(oiHUXJaf.getName());
				ILUuPsGC.putNextEntry(nf6ejl15);
				LOG.debug("copying " + oiHUXJaf.getName());
				IOUtils.copy(ovCv2lhs, ILUuPsGC);
			}
		}
		ovCv2lhs.close();
		oiHUXJaf = new ZipEntry(ODFUtil.SIGNATURE_FILE);
		LOG.debug("writing " + oiHUXJaf.getName());
		ILUuPsGC.putNextEntry(oiHUXJaf);
		IOUtils.write(ib3Zg5xW, ILUuPsGC);
		ILUuPsGC.close();
	}

}