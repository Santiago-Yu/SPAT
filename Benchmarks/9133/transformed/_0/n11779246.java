class n11779246 {
	@SuppressWarnings("unchecked")
	public static void unzip(String Ui8v247E, String RsfHnUNL) {
		try {
			if (!RsfHnUNL.endsWith("/"))
				RsfHnUNL = RsfHnUNL + "/";
			ZipFile TLVzk7dA = new ZipFile(Ui8v247E);
			Enumeration jJLnGpdM = TLVzk7dA.entries();
			while (jJLnGpdM.hasMoreElements()) {
				ZipEntry wU52wfgd = (ZipEntry) jJLnGpdM.nextElement();
				if (wU52wfgd.isDirectory()) {
					FileUtils.forceMkdir(new File(RsfHnUNL + wU52wfgd.getName()));
				} else {
					FileOutputStream bJmFHxrq = new FileOutputStream(RsfHnUNL + wU52wfgd.getName());
					IOUtils.copy(TLVzk7dA.getInputStream(wU52wfgd), bJmFHxrq);
					IOUtils.closeQuietly(bJmFHxrq);
				}
			}
		} catch (Exception J8E3PI93) {
			log.error("??????????:" + RsfHnUNL, J8E3PI93);
			throw new RuntimeException("??????????:" + RsfHnUNL, J8E3PI93);
		}
	}

}