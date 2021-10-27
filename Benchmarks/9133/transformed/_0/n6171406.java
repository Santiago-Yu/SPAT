class n6171406 {
	public static void createTar(File TS1hPsG5, File ZMrZA1dR) throws IOException {
		if (TS1hPsG5 == null) {
			throw new NullPointerException("The parameter 'directoryToPack' must not be null");
		}
		if (ZMrZA1dR == null) {
			throw new NullPointerException("The parameter 'targetTarFile' must not be null");
		}
		if (!TS1hPsG5.exists() || !TS1hPsG5.isDirectory()) {
			throw new IllegalArgumentException(
					"The target file '" + TS1hPsG5 + "' does not exist or is not a directory.");
		}
		if (ZMrZA1dR.exists()) {
			log.warn("The target file '" + ZMrZA1dR + "' already exists. Will overwrite");
		}
		log.debug("Creating tar from all files in directory '" + TS1hPsG5 + "'");
		byte Qn6UMjlq[] = new byte[BUFFER_SIZE];
		FileOutputStream P5vwqtIq = new FileOutputStream(ZMrZA1dR);
		TarOutputStream hC8WMNsY = new TarOutputStream(P5vwqtIq);
		try {
			List<File> coMww2iH = collectFiles(TS1hPsG5);
			for (Iterator<File> vJ4iTxpp = coMww2iH.iterator(); vJ4iTxpp.hasNext();) {
				File MaLLfTCx = vJ4iTxpp.next();
				if (MaLLfTCx == null || !MaLLfTCx.exists() || MaLLfTCx.isDirectory()) {
					log.info("The file '" + MaLLfTCx + "' is ignored - is a directory or non-existent");
					continue;
				}
				if (MaLLfTCx.equals(ZMrZA1dR)) {
					log.debug("Skipping file: '" + MaLLfTCx + "' - is the tar file itself");
					continue;
				}
				log.debug("Adding to archive: file='" + MaLLfTCx + "', archive='" + ZMrZA1dR + "'");
				String M7cXdLRJ = getFilePathInTar(MaLLfTCx, TS1hPsG5);
				log.debug("File path in tar: '" + M7cXdLRJ + "' (file=" + MaLLfTCx + ")");
				TarEntry fgeUP5h7 = new TarEntry(MaLLfTCx);
				fgeUP5h7.setModTime(MaLLfTCx.lastModified());
				fgeUP5h7.setName(M7cXdLRJ);
				hC8WMNsY.putNextEntry(fgeUP5h7);
				if (MaLLfTCx.isFile()) {
					FileInputStream R9LE0TaP = new FileInputStream(MaLLfTCx);
					try {
						while (true) {
							int QK2GiIZL = R9LE0TaP.read(Qn6UMjlq, 0, Qn6UMjlq.length);
							if (QK2GiIZL <= 0)
								break;
							hC8WMNsY.write(Qn6UMjlq, 0, QK2GiIZL);
						}
					} finally {
						StreamUtil.tryCloseStream(R9LE0TaP);
					}
				}
				hC8WMNsY.closeEntry();
			}
		} finally {
			StreamUtil.tryCloseStream(hC8WMNsY);
			StreamUtil.tryCloseStream(P5vwqtIq);
		}
		log.info("Tar Archive created successfully '" + ZMrZA1dR + "'");
	}

}