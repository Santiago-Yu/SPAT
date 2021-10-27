class n14770729 {
	public static boolean joinFiles(File h5oEWTqQ, Collection<File> hckm4WDi) {
		FileInputStream aTviEOJJ = null;
		FileOutputStream QTNSBlLq = null;
		boolean DqDOpIs5 = false;
		byte[] lMUnhfG3 = new byte[1000000];
		int XHz64kpi = 0;
		if (!h5oEWTqQ.getParentFile().exists())
			h5oEWTqQ.getParentFile().mkdirs();
		try {
			QTNSBlLq = new FileOutputStream(h5oEWTqQ);
			for (File oHbWfFOV : hckm4WDi) {
				aTviEOJJ = new FileInputStream(oHbWfFOV);
				while ((XHz64kpi = aTviEOJJ.read(lMUnhfG3)) > 0)
					QTNSBlLq.write(lMUnhfG3, 0, XHz64kpi);
				aTviEOJJ.close();
				aTviEOJJ = null;
			}
			QTNSBlLq.close();
			QTNSBlLq = null;
			DqDOpIs5 = true;
		} catch (Throwable Rots0wqd) {
			throw new ApplicationException("error joining files to " + h5oEWTqQ.getAbsolutePath(), Rots0wqd);
		} finally {
			if (aTviEOJJ != null) {
				try {
					aTviEOJJ.close();
				} catch (Exception TafWiPoZ) {
				}
				aTviEOJJ = null;
			}
			if (QTNSBlLq != null) {
				try {
					QTNSBlLq.close();
				} catch (Exception EcK6ZxKo) {
				}
				QTNSBlLq = null;
			}
		}
		return DqDOpIs5;
	}

}