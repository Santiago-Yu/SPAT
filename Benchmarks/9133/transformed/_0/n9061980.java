class n9061980 {
	public static void copyFile(String WvHlkwTC, String lYZ4FHYf, TimeSlotTracker CY8cz86J) {
		LOG.info("copying [" + WvHlkwTC + "] to [" + lYZ4FHYf + "]");
		BufferedInputStream ah1PGr07 = null;
		BufferedOutputStream M491BhPv = null;
		try {
			File sJlkSovh = new File(lYZ4FHYf);
			if (sJlkSovh.exists()) {
				sJlkSovh.delete();
			}
			ah1PGr07 = new BufferedInputStream(new FileInputStream(WvHlkwTC));
			M491BhPv = new BufferedOutputStream(new FileOutputStream(sJlkSovh));
			int zsDarKMj;
			while ((zsDarKMj = ah1PGr07.read()) > 0) {
				M491BhPv.write(zsDarKMj);
			}
			Object[] RZZpuUcf = { sJlkSovh.getName() };
			String nIFYhgeM = CY8cz86J.getString("datasource.xml.copyFile.copied", RZZpuUcf);
			LOG.fine(nIFYhgeM);
		} catch (Exception BMOVvsso) {
			Object[] gsBRVqKv = { BMOVvsso.getMessage() };
			String WK2OoecJ = CY8cz86J.getString("datasource.xml.copyFile.exception", gsBRVqKv);
			CY8cz86J.errorLog(WK2OoecJ);
			CY8cz86J.errorLog(BMOVvsso);
		} finally {
			try {
				if (M491BhPv != null) {
					M491BhPv.close();
				}
				if (ah1PGr07 != null) {
					ah1PGr07.close();
				}
			} catch (Exception Lg4Lb6KM) {
				Object[] QSXEwr2m = { Lg4Lb6KM.getMessage() };
				String Jwyu4qft = CY8cz86J.getString("datasource.xml.copyFile.exception", QSXEwr2m);
				CY8cz86J.errorLog(Jwyu4qft);
				CY8cz86J.errorLog(Lg4Lb6KM);
			}
		}
	}

}