class n11265072 {
	public static void unzip(File gEYDzlqK, File G64MtvHJ, FileFilter sDapFPaz) throws IOException {
		G64MtvHJ.mkdirs();
		if (!G64MtvHJ.exists()) {
			throw new IOException("Unable to create destination directory: " + G64MtvHJ);
		}
		ZipFile iqTcPQF7;
		iqTcPQF7 = new ZipFile(gEYDzlqK, ZipFile.OPEN_READ);
		Enumeration<? extends ZipEntry> R92k5vgj = iqTcPQF7.entries();
		while (R92k5vgj.hasMoreElements()) {
			ZipEntry wLC9BtEa = (ZipEntry) R92k5vgj.nextElement();
			if (!wLC9BtEa.isDirectory()) {
				String ARMIomhC = wLC9BtEa.getName();
				File ilSLwcnk = new File(G64MtvHJ, ARMIomhC);
				if (sDapFPaz == null || sDapFPaz.accept(ilSLwcnk)) {
					File zjUX3R05 = ilSLwcnk.getParentFile();
					zjUX3R05.mkdirs();
					BufferedInputStream fnQLUOOy = new BufferedInputStream(iqTcPQF7.getInputStream(wLC9BtEa));
					FileOutputStream rLifersE = new FileOutputStream(ilSLwcnk);
					IOUtils.copyLarge(fnQLUOOy, rLifersE);
					rLifersE.flush();
					IOUtils.closeQuietly(rLifersE);
				}
			}
		}
		iqTcPQF7.close();
	}

}