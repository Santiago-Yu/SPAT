class n10909692 {
	public void deployDir(File NVClj9va, String LZXOhxPr) {
		File[] Ed7yjCBp = NVClj9va.listFiles();
		for (int BGMmBIbE = 0; Ed7yjCBp != null && BGMmBIbE < Ed7yjCBp.length; BGMmBIbE++) {
			if (!Ed7yjCBp[BGMmBIbE].getName().startsWith(".")) {
				if (Ed7yjCBp[BGMmBIbE].isFile()) {
					File u0XrlCJy = new File(LZXOhxPr + File.separator + Ed7yjCBp[BGMmBIbE].getName());
					if (Ed7yjCBp[BGMmBIbE].lastModified() != u0XrlCJy.lastModified()
							|| Ed7yjCBp[BGMmBIbE].length() != u0XrlCJy.length()) {
						IOUtils.copy(Ed7yjCBp[BGMmBIbE], u0XrlCJy);
					}
				} else if (Ed7yjCBp[BGMmBIbE].isDirectory()) {
					String ZfIkfalr = LZXOhxPr + File.separator + Ed7yjCBp[BGMmBIbE].getName();
					deployDir(Ed7yjCBp[BGMmBIbE], ZfIkfalr);
				}
			}
		}
	}

}