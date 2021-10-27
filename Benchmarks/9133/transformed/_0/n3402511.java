class n3402511 {
	private static FileEntry writeEntry(Zip64File zStxjOpO, FileEntry QUKm0xTq, File It85JHY4, boolean UUtrf88y) {
		InputStream COxYVeit = null;
		EntryOutputStream oCxxnM81 = null;
		processAndCreateFolderEntries(zStxjOpO, parseTargetPath(QUKm0xTq.getName(), It85JHY4), UUtrf88y);
		try {
			if (!UUtrf88y) {
				oCxxnM81 = zStxjOpO.openEntryOutputStream(QUKm0xTq.getName(), FileEntry.iMETHOD_STORED,
						getFileDate(It85JHY4));
			} else {
				oCxxnM81 = zStxjOpO.openEntryOutputStream(QUKm0xTq.getName(), FileEntry.iMETHOD_DEFLATED,
						getFileDate(It85JHY4));
			}
			if (!QUKm0xTq.isDirectory()) {
				COxYVeit = new FileInputStream(It85JHY4);
				IOUtils.copyLarge(COxYVeit, oCxxnM81);
				COxYVeit.close();
			}
			oCxxnM81.flush();
			oCxxnM81.close();
			if (QUKm0xTq.isDirectory()) {
				log.info("[createZip] Written folder entry to zip: " + QUKm0xTq.getName());
			} else {
				log.info("[createZip] Written file entry to zip: " + QUKm0xTq.getName());
			}
		} catch (FileNotFoundException fVmdPEVT) {
			fVmdPEVT.printStackTrace();
		} catch (ZipException EazStfsP) {
			EazStfsP.printStackTrace();
		} catch (IOException Nw2GY5Q7) {
			Nw2GY5Q7.printStackTrace();
		}
		return QUKm0xTq;
	}

}