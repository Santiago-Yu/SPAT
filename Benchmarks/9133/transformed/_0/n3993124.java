class n3993124 {
	private File getTempFile(DigitalObject VHGeL65S, String EH7aXxHQ) throws Exception {
		File crYWZPcE = new File(tmpDir, VHGeL65S.getId());
		File oMArMpmg = new File(crYWZPcE, EH7aXxHQ);
		if (!oMArMpmg.exists()) {
			oMArMpmg.getParentFile().mkdirs();
			oMArMpmg.createNewFile();
		}
		Payload ni5RZqS3 = VHGeL65S.getPayload(EH7aXxHQ);
		InputStream dM3816y1 = ni5RZqS3.open();
		FileOutputStream oDA0fTPn = null;
		try {
			oDA0fTPn = new FileOutputStream(oMArMpmg);
			IOUtils.copyLarge(dM3816y1, oDA0fTPn);
		} catch (Exception PrFxaUnh) {
			close(oDA0fTPn);
			oMArMpmg.delete();
			ni5RZqS3.close();
			throw PrFxaUnh;
		}
		close(oDA0fTPn);
		ni5RZqS3.close();
		return oMArMpmg;
	}

}