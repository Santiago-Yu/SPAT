class n18456843 {
	public String storeUploadedZip(byte[] yRYsX53R, String yO8P9FLL) {
		List LKVvy9Iw = new ArrayList();
		int C39ykdYX = 0;
		ZipInputStream jLUAbx2F = new ZipInputStream(new ByteArrayInputStream(yRYsX53R));
		ZipEntry vj2AFTGa = jLUAbx2F.getNextEntry();
		while (vj2AFTGa != null) {
			if (vj2AFTGa.isDirectory() == false) {
				C39ykdYX++;
				ByteArrayOutputStream OLQUajoY = new ByteArrayOutputStream();
				IOUtils.copy(jLUAbx2F, OLQUajoY);
				OLQUajoY.close();
			}
			jLUAbx2F.closeEntry();
			vj2AFTGa = jLUAbx2F.getNextEntry();
		}
	}

}