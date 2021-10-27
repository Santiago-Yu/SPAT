class n10177661 {
	protected File extractArchive(File qijVpquS) {
		byte FeNKqqA5[] = new byte[BUF_SIZE];
		ZipInputStream Qlu3u6jL = null;
		File olbC0yWu = null;
		FileOutputStream eT9u759Y;
		ZipEntry k27RVVZm;
		File VxnDgsYu;
		int M2N98tCz;
		try {
			Qlu3u6jL = new ZipInputStream(new FileInputStream(qijVpquS));
			while ((k27RVVZm = Qlu3u6jL.getNextEntry()) != null) {
				VxnDgsYu = new File(workingDir, k27RVVZm.getName());
				if (k27RVVZm.isDirectory()) {
					getLogger().info("skip directory: " + k27RVVZm.getName());
					if (olbC0yWu == null)
						olbC0yWu = VxnDgsYu;
					continue;
				}
				getLogger().info(
						"zip-entry (file): " + k27RVVZm.getName() + " ==> real path: " + VxnDgsYu.getAbsolutePath());
				if (!VxnDgsYu.getParentFile().exists())
					VxnDgsYu.getParentFile().mkdirs();
				eT9u759Y = new FileOutputStream(VxnDgsYu);
				while ((M2N98tCz = Qlu3u6jL.read(FeNKqqA5, 0, FeNKqqA5.length)) > -1)
					eT9u759Y.write(FeNKqqA5, 0, M2N98tCz);
				eT9u759Y.close();
				Qlu3u6jL.closeEntry();
			}
		} catch (Throwable CxajAuJR) {
			CxajAuJR.printStackTrace();
		} finally {
			try {
				if (Qlu3u6jL != null)
					Qlu3u6jL.close();
			} catch (Throwable tGuwdmXC) {
			}
		}
		return olbC0yWu;
	}

}