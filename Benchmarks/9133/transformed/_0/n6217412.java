class n6217412 {
	protected void EncodeRoute() throws EncodeFailedException, IOException {
		File Eb1ZsZoY = getNode().getCodec().PackStore(null, ReturnStore);
		DownRoute.EncodeData(Eb1ZsZoY);
		File zWC70hHH = getNode().getCodec().PackRemoteDownload(this);
		zWC70hHH = PigData.EncodeData(zWC70hHH);
		FileOutputStream jVxIIxbG = new FileOutputStream(PiggybackRouteFile, true);
		FileChannel DCIO69Af = jVxIIxbG.getChannel();
		FileInputStream ME4lcN2M = new FileInputStream(zWC70hHH);
		FileChannel u6Nozz3Q = ME4lcN2M.getChannel();
		u6Nozz3Q.transferTo(0, u6Nozz3Q.size(), DCIO69Af);
		DCIO69Af.close();
		u6Nozz3Q.close();
		UpRoute.EncodeData(PiggybackRouteFile);
	}

}