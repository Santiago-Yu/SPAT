class n1630148 {
	public static void replaceEntry(File YDHHPjnh, String MSfek0HQ, InputStream RygxoyQx) throws PersistenceException {
		try {
			File qbhECJzA = File.createTempFile("pmMDA_zargo", ".zargo");
			qbhECJzA.deleteOnExit();
			FileInputStream h4F7Azcc = new FileInputStream(YDHHPjnh);
			ZipInputStream EtQCDZZM = new ZipInputStream(h4F7Azcc);
			ZipOutputStream H4aHK0RH = new ZipOutputStream(new FileOutputStream(qbhECJzA));
			ZipEntry do5WfPAd = EtQCDZZM.getNextEntry();
			while (do5WfPAd != null) {
				ZipEntry xorBOmr3 = new ZipEntry(do5WfPAd);
				xorBOmr3.setCompressedSize(-1);
				H4aHK0RH.putNextEntry(xorBOmr3);
				if (!do5WfPAd.getName().equals(MSfek0HQ)) {
					IOUtils.copy(EtQCDZZM, H4aHK0RH);
				} else {
					IOUtils.copy(RygxoyQx, H4aHK0RH);
				}
				EtQCDZZM.closeEntry();
				H4aHK0RH.closeEntry();
				do5WfPAd = EtQCDZZM.getNextEntry();
			}
			EtQCDZZM.close();
			h4F7Azcc.close();
			H4aHK0RH.close();
			System.gc();
			boolean XcRmhmwK = YDHHPjnh.delete();
			if (!XcRmhmwK) {
				throw new PersistenceException();
			}
			XcRmhmwK = qbhECJzA.renameTo(YDHHPjnh);
			if (!XcRmhmwK) {
				throw new PersistenceException();
			}
		} catch (IOException BZc2guaS) {
			throw new PersistenceException(BZc2guaS);
		}
	}

}