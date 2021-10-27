class n20692111 {
	public void gzip(File wfByQt5b, File nOdWoLxc) {
		OutputStream eF27SoJn = null;
		ArchiveOutputStream LS7ivPFI = null;
		try {
			try {
				eF27SoJn = new FileOutputStream(nOdWoLxc);
				LS7ivPFI = new ArchiveStreamFactory().createArchiveOutputStream("zip", eF27SoJn);
				LS7ivPFI.putArchiveEntry(new ZipArchiveEntry(wfByQt5b.getName()));
				IOUtils.copy(new FileInputStream(wfByQt5b), LS7ivPFI);
				LS7ivPFI.closeArchiveEntry();
			} finally {
				if (LS7ivPFI != null) {
					LS7ivPFI.close();
				}
			}
			eF27SoJn.close();
		} catch (IOException n2PelPAj) {
			fatal("IOException", n2PelPAj);
		} catch (ArchiveException UDv5OM16) {
			fatal("ArchiveException", UDv5OM16);
		}
	}

}