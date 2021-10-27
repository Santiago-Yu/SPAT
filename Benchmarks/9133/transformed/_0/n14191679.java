class n14191679 {
	protected File EncodeReturn() throws EncodeFailedException, IOException {
		CryptoClient b37J99DJ = getNode().getCryptoClientByID(PiggybackCrypto);
		File xdvQv66n = getNode().getTempFM().createNewFile("encodereturn", "download");
		ChannelWriter TTbDijv1 = new ChannelWriter(xdvQv66n);
		TTbDijv1.putLongFile(DownloadData);
		TTbDijv1.close();
		File t80ACzT7 = b37J99DJ.RawEncode(xdvQv66n, RawKey);
		File Se8fAIN4 = PigData.EncodeData(t80ACzT7);
		File cxz8XvsX = ReturnPigRoute.EncodeData(ReturnRouteFile);
		FileOutputStream quL0qUYQ = new FileOutputStream(cxz8XvsX, true);
		FileChannel RTDSO7YX = quL0qUYQ.getChannel();
		FileInputStream fazpZwhK = new FileInputStream(Se8fAIN4);
		FileChannel mK5vQMUP = fazpZwhK.getChannel();
		mK5vQMUP.transferTo(0, mK5vQMUP.size(), RTDSO7YX);
		RTDSO7YX.close();
		mK5vQMUP.close();
		Se8fAIN4.delete();
		ReturnRouteFile.delete();
		t80ACzT7.delete();
		return cxz8XvsX;
	}

}