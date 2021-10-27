class n18935118 {
	public boolean backupFile(File vU1BPnOH, File bFyIvhvV) {
		boolean WFGpvFs4 = false;
		FileChannel RB8J63zH = null;
		FileChannel GOkMotdL = null;
		try {
			RB8J63zH = new FileInputStream(vU1BPnOH).getChannel();
			GOkMotdL = new FileOutputStream(bFyIvhvV).getChannel();
			GOkMotdL.transferFrom(RB8J63zH, 0, RB8J63zH.size());
		} catch (IOException m1QB74bN) {
			logger.log(Level.SEVERE, "IO exception occurred while copying config file", m1QB74bN);
		} finally {
			if ((bFyIvhvV != null) && (bFyIvhvV.exists()) && (bFyIvhvV.length() > 0)) {
				WFGpvFs4 = true;
			}
			try {
				if (RB8J63zH != null) {
					RB8J63zH.close();
				}
				if (GOkMotdL != null) {
					GOkMotdL.close();
				}
			} catch (IOException sFt2bEIF) {
				logger.log(Level.INFO, "closing channels failed");
			}
		}
		return WFGpvFs4;
	}

}