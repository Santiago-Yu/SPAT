class n18733556 {
	public static Map<String, File> extractFiles(String gpHJQoQ7, File NPGSqLJj) throws IOException {
		byte rJwTSBTB[] = new byte[BUFFER];
		BufferedOutputStream zGxaX89E = null;
		FileInputStream McZjQb3E = new FileInputStream(gpHJQoQ7);
		BufferedInputStream iCfPDIe8 = new BufferedInputStream(McZjQb3E);
		ZipInputStream H4mdXGEU = new ZipInputStream(iCfPDIe8);
		Map<String, File> aMk7uYyZ = new HashMap<String, File>();
		ZipEntry FCV23RaR;
		while ((FCV23RaR = H4mdXGEU.getNextEntry()) != null) {
			logger.info(TAG + ": entr?e " + FCV23RaR.getName() + " r?pertoire ? " + FCV23RaR.isDirectory());
			if (FCV23RaR.isDirectory()) {
				logger.info(TAG + ": Ajout de l'entr?e pour le r?pertoire: " + FCV23RaR.getName());
				aMk7uYyZ.put(FCV23RaR.getName(), extractDirectory(FCV23RaR.getName(), H4mdXGEU, NPGSqLJj));
				File DlyOBvaW = aMk7uYyZ.get(FCV23RaR.getName());
				if (DlyOBvaW == null)
					logger.info(TAG + ": NULLL: ");
				continue;
			}
			File Y5cdzMzW = new File(NPGSqLJj, FCV23RaR.getName());
			if (Y5cdzMzW.exists())
				Y5cdzMzW.delete();
			Y5cdzMzW.createNewFile();
			FileOutputStream QLP6D1Ex = new FileOutputStream(Y5cdzMzW);
			zGxaX89E = new BufferedOutputStream(QLP6D1Ex, BUFFER);
			int R2BkqLIK;
			for (int Li1FezQ0 = H4mdXGEU.read(); Li1FezQ0 != -1; Li1FezQ0 = H4mdXGEU.read())
				QLP6D1Ex.write(Li1FezQ0);
			logger.info(
					TAG + ": Ajout de l'entr?e: " + FCV23RaR.getName() + " du fichier: " + Y5cdzMzW.getAbsolutePath());
			aMk7uYyZ.put(FCV23RaR.getName(), Y5cdzMzW);
			zGxaX89E.close();
			QLP6D1Ex.close();
		}
		H4mdXGEU.close();
		iCfPDIe8.close();
		McZjQb3E.close();
		return aMk7uYyZ;
	}

}