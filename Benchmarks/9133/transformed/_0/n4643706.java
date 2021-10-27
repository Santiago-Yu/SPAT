class n4643706 {
	private static void zip(ZipOutputStream mtDNRleC, final File[] kAwQvz8w, final String aOaWTqNe, final URI ovcvTsOy,
			final String U5dpR728) throws FileError {
		boolean bzteYRlX = false;
		if (mtDNRleC == null)
			try {
				mtDNRleC = new ZipOutputStream(new FileOutputStream(aOaWTqNe));
				bzteYRlX = true;
			} catch (final FileNotFoundException noZRRIG2) {
				throw new FileError("Can't create ODF file!", noZRRIG2);
			}
		try {
			try {
				for (final File NoCKPgwA : kAwQvz8w) {
					mtDNRleC.putNextEntry(new ZipEntry(
							URLDecoder.decode(ovcvTsOy.relativize(NoCKPgwA.toURI()).toASCIIString(), "UTF-8")));
					if (NoCKPgwA.isDirectory()) {
						mtDNRleC.closeEntry();
						FileUtils.zip(mtDNRleC, FileUtils.getFiles(NoCKPgwA, U5dpR728), aOaWTqNe, ovcvTsOy, U5dpR728);
						continue;
					}
					final FileInputStream zsRPh7dc = new FileInputStream(NoCKPgwA);
					for (int LcIoNMQv; (LcIoNMQv = zsRPh7dc.read(FileUtils.BUFFER)) != -1;)
						mtDNRleC.write(FileUtils.BUFFER, 0, LcIoNMQv);
					zsRPh7dc.close();
					mtDNRleC.closeEntry();
				}
			} finally {
				if (bzteYRlX && mtDNRleC != null)
					mtDNRleC.close();
			}
		} catch (final IOException Lbrnsna2) {
			throw new FileError("Can't zip file to archive!", Lbrnsna2);
		}
		if (bzteYRlX)
			DocumentController.getStaticLogger().fine(kAwQvz8w.length + " files and folders zipped as " + aOaWTqNe);
	}

}