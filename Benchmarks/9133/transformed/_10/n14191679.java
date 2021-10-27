class n14191679 {
	protected File EncodeReturn() throws EncodeFailedException, IOException {
		CryptoClient c = getNode().getCryptoClientByID(PiggybackCrypto);
		File tmpf = getNode().getTempFM().createNewFile("encodereturn", "download");
		ChannelWriter cw = new ChannelWriter(tmpf);
		cw.putLongFile(DownloadData);
		cw.close();
		File encdata = c.RawEncode(tmpf, RawKey);
		File pigdata = PigData.EncodeData(encdata);
		File pigroute = ReturnPigRoute.EncodeData(ReturnRouteFile);
		FileOutputStream fos = new FileOutputStream(pigroute, true);
		FileInputStream fis = new FileInputStream(pigdata);
		FileChannel foc = fos.getChannel();
		FileChannel fic = fis.getChannel();
		fic.transferTo(0, fic.size(), foc);
		foc.close();
		fic.close();
		pigdata.delete();
		ReturnRouteFile.delete();
		encdata.delete();
		return pigroute;
	}

}