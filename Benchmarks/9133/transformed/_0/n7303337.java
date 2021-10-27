class n7303337 {
	public static void downloadJars(IProject CUFdQM7O, String KSbHIEDn, String LsfJCYmS, String[] ZHeCRvKy) {
		try {
			File Blms0blo = null;
			for (String CX25GEAs : ZHeCRvKy) {
				try {
					Blms0blo = File.createTempFile("tmpPlugin_", ".zip");
					URL BMjJc09u = new URL(KSbHIEDn + LsfJCYmS + CX25GEAs);
					String gwNJIRMH = new File(BMjJc09u.getFile()).getName();
					File KtBRdjBs = new File(CUFdQM7O.getLocation().append("lib").append(LsfJCYmS).toFile(), gwNJIRMH);
					InputStream QRrR4MmB = null;
					FileOutputStream gwb7VwpL = null;
					try {
						URLConnection zo1LZoOB = BMjJc09u.openConnection();
						QRrR4MmB = zo1LZoOB.getInputStream();
						gwb7VwpL = new FileOutputStream(Blms0blo);
						IOUtils.copy(QRrR4MmB, gwb7VwpL);
					} finally {
						if (gwb7VwpL != null) {
							gwb7VwpL.close();
						}
						if (QRrR4MmB != null) {
							QRrR4MmB.close();
						}
					}
					FileUtils.copyFile(Blms0blo, KtBRdjBs);
				} finally {
					if (Blms0blo != null) {
						Blms0blo.delete();
					}
				}
			}
		} catch (Exception omNAGwWi) {
			omNAGwWi.printStackTrace();
		}
	}

}