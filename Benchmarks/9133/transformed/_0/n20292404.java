class n20292404 {
	protected void convertInternal(InputStream etoFfOwO, DocumentFormat lnaRbdbp, OutputStream TK8bZv1e,
			DocumentFormat aQRQ0s4K) {
		File toGwVDNj = null;
		File GiRgdDQO = null;
		try {
			toGwVDNj = File.createTempFile("document", "." + lnaRbdbp.getFileExtension());
			OutputStream kbOYI6ZW = null;
			try {
				kbOYI6ZW = new FileOutputStream(toGwVDNj);
				IOUtils.copy(etoFfOwO, kbOYI6ZW);
			} finally {
				IOUtils.closeQuietly(kbOYI6ZW);
			}
			GiRgdDQO = File.createTempFile("document", "." + aQRQ0s4K.getFileExtension());
			convert(toGwVDNj, lnaRbdbp, GiRgdDQO, aQRQ0s4K);
			InputStream g8d48Ek0 = null;
			try {
				g8d48Ek0 = new FileInputStream(GiRgdDQO);
				IOUtils.copy(g8d48Ek0, TK8bZv1e);
			} finally {
				IOUtils.closeQuietly(g8d48Ek0);
			}
		} catch (IOException tT7CgjoD) {
			throw new OpenOfficeException("conversion failed", tT7CgjoD);
		} finally {
			if (toGwVDNj != null) {
				toGwVDNj.delete();
			}
			if (GiRgdDQO != null) {
				GiRgdDQO.delete();
			}
		}
	}

}