class n11088622 {
	public static void copyFile(File eMMX8zrC, File q5zOou2l) throws IOException {
		InputStream sHIO2b2x = null;
		OutputStream vOaeRDdI = null;
		try {
			sHIO2b2x = new FileInputStream(eMMX8zrC);
			vOaeRDdI = new FileOutputStream(q5zOou2l);
			IOUtils.copy(sHIO2b2x, vOaeRDdI);
		} finally {
			try {
				if (vOaeRDdI != null)
					vOaeRDdI.close();
			} catch (Exception uOUjW6G6) {
			}
			try {
				if (sHIO2b2x != null)
					sHIO2b2x.close();
			} catch (Exception Zcs5rAWP) {
			}
		}
	}

}