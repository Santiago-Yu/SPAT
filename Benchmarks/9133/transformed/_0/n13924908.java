class n13924908 {
	public boolean backupFile(File OWar01gn, File IQQVHE1U) {
		boolean loJzfOeU = false;
		FileChannel PKBNRTvA = null;
		FileChannel jz0QzeMM = null;
		try {
			PKBNRTvA = new FileInputStream(OWar01gn).getChannel();
			jz0QzeMM = new FileOutputStream(IQQVHE1U).getChannel();
			jz0QzeMM.transferFrom(PKBNRTvA, 0, PKBNRTvA.size());
		} catch (IOException GuIgwMqx) {
			logger.log(Level.SEVERE, "IO exception occurred while copying file", GuIgwMqx);
		} finally {
			if ((IQQVHE1U != null) && (IQQVHE1U.exists()) && (IQQVHE1U.length() > 0)) {
				loJzfOeU = true;
			}
			try {
				if (PKBNRTvA != null) {
					PKBNRTvA.close();
				}
				if (jz0QzeMM != null) {
					jz0QzeMM.close();
				}
			} catch (IOException O337sx7i) {
				logger.info("closing channels failed");
			}
		}
		return loJzfOeU;
	}

}