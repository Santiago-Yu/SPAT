class n3838437 {
	public static boolean copyFile(final File bzbjV5d8, final File M724fYav) {
		try {
			FileChannel JAaFh7UU = new FileInputStream(bzbjV5d8).getChannel();
			FileChannel FOXW9kXC = new FileOutputStream(M724fYav).getChannel();
			JAaFh7UU.transferTo(0, JAaFh7UU.size(), FOXW9kXC);
			JAaFh7UU.close();
			FOXW9kXC.close();
			return true;
		} catch (IOException VB8yWRIM) {
			SystemUtils.LOG.log(Level.INFO, "SystemUtils.copyFile() Exception while copy file "
					+ bzbjV5d8.getAbsolutePath() + " to " + M724fYav.getAbsolutePath(), VB8yWRIM);
			return false;
		}
	}

}