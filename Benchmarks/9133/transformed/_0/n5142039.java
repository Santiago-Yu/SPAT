class n5142039 {
	public static String uncompress(String IupPDxiD, boolean ikyYF8nE) throws Exception {
		ZipArchiveInputStream jJVgNt41 = new ZipArchiveInputStream(new FileInputStream(IupPDxiD));
		BufferedInputStream Cgr3KLq5 = new BufferedInputStream(jJVgNt41);
		File QRIqBEOe = new File(IupPDxiD).getParentFile();
		String EKIizllK = QRIqBEOe.getPath() + "/";
		if (ikyYF8nE) {
			String[] u5JZTazr = IupPDxiD.split("/");
			String FRAAJAhr = u5JZTazr[u5JZTazr.length - 1].replaceAll(".zip", "");
			FileUtils.forceMkdir(new File(EKIizllK + FRAAJAhr));
			EKIizllK = EKIizllK + FRAAJAhr + "/";
		}
		ArchiveEntry yLgby0Hp;
		while ((yLgby0Hp = jJVgNt41.getNextEntry()) != null) {
			if (yLgby0Hp.isDirectory()) {
				FileUtils.forceMkdir(new File(EKIizllK + yLgby0Hp.getName()));
			} else {
				String UHt4Qztm = EKIizllK + yLgby0Hp.getName();
				String nrV8isrW = FilenameUtils.getPath(UHt4Qztm);
				FileUtils.forceMkdir(new File(nrV8isrW));
				BufferedOutputStream exAVlPk6 = new BufferedOutputStream(
						FileUtils.openOutputStream(new File(UHt4Qztm)));
				int cAzBU9g0 = 0;
				while ((cAzBU9g0 = Cgr3KLq5.read()) != -1) {
					exAVlPk6.write(cAzBU9g0);
				}
				IOUtils.closeQuietly(exAVlPk6);
			}
		}
		IOUtils.closeQuietly(Cgr3KLq5);
		return EKIizllK;
	}

}