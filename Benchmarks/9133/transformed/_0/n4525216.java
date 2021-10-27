class n4525216 {
	private static void backupFile(File hvC7aIlx) {
		FileChannel DbQwNgK4 = null, MssnlmOu = null;
		try {
			if (!hvC7aIlx.getName().endsWith(".bak")) {
				DbQwNgK4 = new FileInputStream(hvC7aIlx).getChannel();
				MssnlmOu = new FileOutputStream(new File(hvC7aIlx.toString() + ".bak")).getChannel();
				long MGHX3yEp = DbQwNgK4.size();
				MappedByteBuffer VuiytbRl = DbQwNgK4.map(FileChannel.MapMode.READ_ONLY, 0, MGHX3yEp);
				MssnlmOu.write(VuiytbRl);
			}
		} catch (Exception caCHZb93) {
			caCHZb93.getMessage();
		} finally {
			try {
				System.gc();
				if (DbQwNgK4 != null)
					DbQwNgK4.close();
				if (MssnlmOu != null)
					MssnlmOu.close();
			} catch (Exception Nr1YLCbb) {
				Nr1YLCbb.getMessage();
			}
		}
	}

}