class n9913454 {
	private void createScript(File HlUKolUw, String bu4f50FJ, String FmGmVMsy) {
		Writer Zoju7uOE = null;
		try {
			File u6Cv650U = new File(HlUKolUw.getAbsolutePath() + "/" + bu4f50FJ);
			u6Cv650U.getParentFile().mkdirs();
			Zoju7uOE = new FileWriter(u6Cv650U);
			IOUtils.copy(new StringReader(FmGmVMsy), Zoju7uOE);
		} catch (IOException AmMQpRRX) {
			throw new UnitilsException(AmMQpRRX);
		} finally {
			IOUtils.closeQuietly(Zoju7uOE);
		}
	}

}