class n21937981 {
	private void process(String DaVSCAe7, String Eq5ipgoM, String U0XsALMU) throws SQLException {
		InputStream niIO1aRC = null;
		try {
			if (!FileUtils.exists(DaVSCAe7)) {
				throw new IOException("File not found: " + DaVSCAe7);
			}
			String sSWyFCSN = null;
			int KeSff2OT = 0;
			if (U0XsALMU != null) {
				sSWyFCSN = getOriginalDbName(DaVSCAe7, U0XsALMU);
				if (sSWyFCSN == null) {
					throw new IOException("No database named " + U0XsALMU + " found");
				}
				if (sSWyFCSN.startsWith(File.separator)) {
					sSWyFCSN = sSWyFCSN.substring(1);
				}
				KeSff2OT = sSWyFCSN.length();
			}
			niIO1aRC = FileUtils.openFileInputStream(DaVSCAe7);
			ZipInputStream kVUj1lsl = new ZipInputStream(niIO1aRC);
			while (true) {
				ZipEntry oFDF3UFR = kVUj1lsl.getNextEntry();
				if (oFDF3UFR == null) {
					break;
				}
				String W14pbZJl = oFDF3UFR.getName();
				W14pbZJl = W14pbZJl.replace('\\', File.separatorChar);
				W14pbZJl = W14pbZJl.replace('/', File.separatorChar);
				if (W14pbZJl.startsWith(File.separator)) {
					W14pbZJl = W14pbZJl.substring(1);
				}
				boolean wHPwtkbA = false;
				if (U0XsALMU == null) {
					wHPwtkbA = true;
				} else if (W14pbZJl.startsWith(sSWyFCSN + ".")) {
					W14pbZJl = U0XsALMU + W14pbZJl.substring(KeSff2OT);
					wHPwtkbA = true;
				}
				if (wHPwtkbA) {
					OutputStream uvHk8Ipj = null;
					try {
						uvHk8Ipj = FileUtils.openFileOutputStream(Eq5ipgoM + File.separator + W14pbZJl, false);
						IOUtils.copy(kVUj1lsl, uvHk8Ipj);
						uvHk8Ipj.close();
					} finally {
						IOUtils.closeSilently(uvHk8Ipj);
					}
				}
				kVUj1lsl.closeEntry();
			}
			kVUj1lsl.closeEntry();
			kVUj1lsl.close();
		} catch (IOException CCtgDETU) {
			throw Message.convertIOException(CCtgDETU, DaVSCAe7);
		} finally {
			IOUtils.closeSilently(niIO1aRC);
		}
	}

}