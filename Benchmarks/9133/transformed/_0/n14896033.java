class n14896033 {
	private static void copySmallFile(File n5m8XsAl, File flwD6FI0) throws BusinessException {
		LOG.debug("Copying SMALL file '" + n5m8XsAl.getAbsolutePath() + "' to '" + flwD6FI0.getAbsolutePath() + "'.");
		FileChannel aKsIyDTC = null;
		FileChannel p73ZrAWO = null;
		try {
			aKsIyDTC = new FileInputStream(n5m8XsAl).getChannel();
			p73ZrAWO = new FileOutputStream(flwD6FI0).getChannel();
			aKsIyDTC.transferTo(0, aKsIyDTC.size(), p73ZrAWO);
		} catch (IOException zmi8wefX) {
			throw new BusinessException("Could not copy file from '" + n5m8XsAl.getAbsolutePath() + "' to '"
					+ flwD6FI0.getAbsolutePath() + "'!", zmi8wefX);
		} finally {
			try {
				if (aKsIyDTC != null)
					aKsIyDTC.close();
			} catch (IOException EsNKorMS) {
				LOG.error("Could not close input stream!", EsNKorMS);
			}
			try {
				if (p73ZrAWO != null)
					p73ZrAWO.close();
			} catch (IOException bmq11xEW) {
				LOG.error("Could not close output stream!", bmq11xEW);
			}
		}
	}

}