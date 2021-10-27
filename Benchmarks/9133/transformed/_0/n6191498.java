class n6191498 {
	private static void copySmallFile(final File cpRMfZZy, final File EtC4zlPl) throws PtException {
		LOG.debug("Copying SMALL file '" + cpRMfZZy.getAbsolutePath() + "' to " + "'" + EtC4zlPl.getAbsolutePath()
				+ "'.");
		FileChannel msjMTm4T = null;
		FileChannel baylHP5S = null;
		try {
			msjMTm4T = new FileInputStream(cpRMfZZy).getChannel();
			baylHP5S = new FileOutputStream(EtC4zlPl).getChannel();
			msjMTm4T.transferTo(0, msjMTm4T.size(), baylHP5S);
		} catch (IOException X9WkItdl) {
			throw new PtException("Could not copy file from '" + cpRMfZZy.getAbsolutePath() + "' to " + "'"
					+ EtC4zlPl.getAbsolutePath() + "'!", X9WkItdl);
		} finally {
			PtCloseUtil.close(msjMTm4T, baylHP5S);
		}
	}

}