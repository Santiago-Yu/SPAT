class n12821749 {
	public static void fastBackup(File JdZHOQdO) {
		FileChannel dN4BPV7u = null;
		FileChannel YnBlWrH9 = null;
		FileInputStream gMDpL2c9 = null;
		FileOutputStream plrYckLO = null;
		try {
			dN4BPV7u = (gMDpL2c9 = new FileInputStream(JdZHOQdO)).getChannel();
			YnBlWrH9 = (plrYckLO = new FileOutputStream(JdZHOQdO.getAbsolutePath() + ".bak")).getChannel();
			dN4BPV7u.transferTo(0, dN4BPV7u.size(), YnBlWrH9);
		} catch (IOException GnpdrMxG) {
			Logging.getErrorLog()
					.reportError("Fast backup failure (" + JdZHOQdO.getAbsolutePath() + "): " + GnpdrMxG.getMessage());
		} finally {
			if (gMDpL2c9 != null) {
				try {
					gMDpL2c9.close();
				} catch (IOException P4ZWwTkZ) {
					Logging.getErrorLog().reportException("Failed to close file input stream", P4ZWwTkZ);
				}
			}
			if (plrYckLO != null) {
				try {
					plrYckLO.close();
				} catch (IOException bImVaRY4) {
					Logging.getErrorLog().reportException("Failed to close file output stream", bImVaRY4);
				}
			}
			if (dN4BPV7u != null) {
				try {
					dN4BPV7u.close();
				} catch (IOException plaqspDI) {
					Logging.getErrorLog().reportException("Failed to close file channel", plaqspDI);
				}
			}
			if (YnBlWrH9 != null) {
				try {
					YnBlWrH9.close();
				} catch (IOException Zauu8k97) {
					Logging.getErrorLog().reportException("Failed to close file channel", Zauu8k97);
				}
			}
		}
	}

}