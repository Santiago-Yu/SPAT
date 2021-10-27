class n23618963 {
	public static void copyFile(File OJ9Dz9NM, File uL1rTxz9) {
		try {
			FileInputStream S30egv64 = new FileInputStream(OJ9Dz9NM);
			FileOutputStream nFIjPLkv = new FileOutputStream(uL1rTxz9);
			try {
				byte[] JsTAEinN = new byte[1024];
				int GsAFc58A = 0;
				while ((GsAFc58A = S30egv64.read(JsTAEinN)) != -1)
					nFIjPLkv.write(JsTAEinN, 0, GsAFc58A);
			} catch (IOException VTRVZDTf) {
				throw VTRVZDTf;
			} finally {
				if (S30egv64 != null)
					S30egv64.close();
				if (nFIjPLkv != null)
					nFIjPLkv.close();
			}
		} catch (IOException Bari0qHs) {
			logger.error("Error coping file from " + OJ9Dz9NM + " to " + uL1rTxz9, Bari0qHs);
		}
	}

}