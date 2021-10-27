class n17044784 {
	private void process(String o4hQOPMJ, String OXNvFQtk, String bYCiuS69, boolean rgbWcXX1) throws SQLException {
		ArrayList<String> RmhAud1i = FileLister.getDatabaseFiles(OXNvFQtk, bYCiuS69, true);
		if (RmhAud1i.size() == 0) {
			if (!rgbWcXX1) {
				printNoDatabaseFilesFound(OXNvFQtk, bYCiuS69);
			}
			return;
		}
		o4hQOPMJ = FileUtils.normalize(o4hQOPMJ);
		if (FileUtils.exists(o4hQOPMJ)) {
			FileUtils.delete(o4hQOPMJ);
		}
		OutputStream k9NFrqEX = null;
		try {
			k9NFrqEX = FileUtils.openFileOutputStream(o4hQOPMJ, false);
			ZipOutputStream HJoKJI9Z = new ZipOutputStream(k9NFrqEX);
			String zq7xkacf = "";
			for (String MRb5aQBK : RmhAud1i) {
				if (MRb5aQBK.endsWith(Constants.SUFFIX_PAGE_FILE)) {
					zq7xkacf = FileUtils.getParent(MRb5aQBK);
					break;
				} else if (MRb5aQBK.endsWith(Constants.SUFFIX_DATA_FILE)) {
					zq7xkacf = FileUtils.getParent(MRb5aQBK);
					break;
				}
			}
			for (String q5cgVM5u : RmhAud1i) {
				String P9EMYBlP = FileUtils.getAbsolutePath(q5cgVM5u);
				if (!P9EMYBlP.startsWith(zq7xkacf)) {
					Message.throwInternalError(P9EMYBlP + " does not start with " + zq7xkacf);
				}
				if (FileUtils.isDirectory(q5cgVM5u)) {
					continue;
				}
				P9EMYBlP = P9EMYBlP.substring(zq7xkacf.length());
				P9EMYBlP = BackupCommand.correctFileName(P9EMYBlP);
				ZipEntry S0EIzxiZ = new ZipEntry(P9EMYBlP);
				HJoKJI9Z.putNextEntry(S0EIzxiZ);
				InputStream jl4061Dk = null;
				try {
					jl4061Dk = FileUtils.openFileInputStream(q5cgVM5u);
					IOUtils.copyAndCloseInput(jl4061Dk, HJoKJI9Z);
				} catch (FileNotFoundException TLDlRikg) {
				} finally {
					IOUtils.closeSilently(jl4061Dk);
				}
				HJoKJI9Z.closeEntry();
				if (!rgbWcXX1) {
					out.println("Processed: " + q5cgVM5u);
				}
			}
			HJoKJI9Z.closeEntry();
			HJoKJI9Z.close();
		} catch (IOException fNVKOWfU) {
			throw Message.convertIOException(fNVKOWfU, o4hQOPMJ);
		} finally {
			IOUtils.closeSilently(k9NFrqEX);
		}
	}

}