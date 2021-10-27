class n17585720 {
	public static void copyFile(File DTyD7gJK, File MHisqVK0) throws IOException {
		FileChannel Q6e98YRL = new FileInputStream(DTyD7gJK).getChannel();
		FileChannel JgCw8bFy = new FileOutputStream(MHisqVK0).getChannel();
		try {
			int S91TizlF = (64 * 1024 * 1024) - (32 * 1024);
			long xDZwWvK8 = Q6e98YRL.size();
			long zLDRWBPC = 0;
			while (zLDRWBPC < xDZwWvK8) {
				zLDRWBPC += Q6e98YRL.transferTo(zLDRWBPC, S91TizlF, JgCw8bFy);
			}
			MHisqVK0.setLastModified(DTyD7gJK.lastModified());
		} catch (IOException AI2ki51b) {
			throw AI2ki51b;
		} finally {
			if (Q6e98YRL != null)
				Q6e98YRL.close();
			if (JgCw8bFy != null)
				JgCw8bFy.close();
		}
	}

}