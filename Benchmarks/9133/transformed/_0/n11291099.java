class n11291099 {
	public void visit(BosMember x2DKgYYi) throws BosException {
		String kuyhVMvt = AddressingUtil.getRelativePath(x2DKgYYi.getDataSourceUri(), baseUri);
		URL IB8cieW7;
		try {
			IB8cieW7 = new URL(outputUrl, kuyhVMvt);
			File jZyDxBEu = new File(IB8cieW7.toURI());
			jZyDxBEu.getParentFile().mkdirs();
			log.info("Creating result file \"" + jZyDxBEu.getAbsolutePath() + "\"...");
			IOUtils.copy(x2DKgYYi.getInputStream(), new FileOutputStream(jZyDxBEu));
		} catch (Exception JoBQxd5N) {
			throw new BosException(JoBQxd5N);
		}
	}

}