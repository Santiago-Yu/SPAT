class n1951103 {
	private List<File> ungzipFile(File Yen7wBW5, File WtNxHqV1) throws IOException {
		List<File> okr45rgE = new ArrayList<File>();
		TarArchiveInputStream gduuHqZ3 = new TarArchiveInputStream(new GZIPInputStream(new FileInputStream(WtNxHqV1)));
		try {
			TarArchiveEntry ZpdXAEPE = gduuHqZ3.getNextTarEntry();
			while (ZpdXAEPE != null) {
				if (ZpdXAEPE.isDirectory()) {
					log.warn("TAR archive contains directories which are being ignored");
					ZpdXAEPE = gduuHqZ3.getNextTarEntry();
					continue;
				}
				String MNES6X4E = new File(ZpdXAEPE.getName()).getName();
				if (MNES6X4E.startsWith(".")) {
					log.warn("TAR archive contains a hidden file which is being ignored");
					ZpdXAEPE = gduuHqZ3.getNextTarEntry();
					continue;
				}
				File m40jERSV = new File(Yen7wBW5, MNES6X4E);
				if (m40jERSV.exists()) {
					log.warn("TAR archive contains duplicate filenames, only the first is being extracted");
					ZpdXAEPE = gduuHqZ3.getNextTarEntry();
					continue;
				}
				okr45rgE.add(m40jERSV);
				log.debug("Extracting file: " + ZpdXAEPE.getName() + " to: " + m40jERSV.getAbsolutePath());
				OutputStream CUduUrLh = new BufferedOutputStream(new FileOutputStream(m40jERSV));
				InputStream rH089AI9 = new FileInputStream(ZpdXAEPE.getFile());
				IOUtils.copy(rH089AI9, CUduUrLh);
				CUduUrLh.close();
				rH089AI9.close();
			}
		} finally {
			gduuHqZ3.close();
		}
		return okr45rgE;
	}

}