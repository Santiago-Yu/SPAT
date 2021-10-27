class n10628604 {
	public File extractID3v2TagDataIntoFile(File HHYMdOaj) throws TagNotFoundException, IOException {
		int AkOIsoWz = (int) ((MP3AudioHeader) audioHeader).getMp3StartByte();
		if (AkOIsoWz >= 0) {
			FileInputStream uWlDZdpX = new FileInputStream(file);
			FileChannel pDszlUBs = uWlDZdpX.getChannel();
			ByteBuffer bB5A5MbQ = ByteBuffer.allocate(AkOIsoWz);
			pDszlUBs.read(bB5A5MbQ);
			FileOutputStream oAvBYl4S = new FileOutputStream(HHYMdOaj);
			oAvBYl4S.write(bB5A5MbQ.array());
			oAvBYl4S.close();
			pDszlUBs.close();
			uWlDZdpX.close();
			return HHYMdOaj;
		}
		throw new TagNotFoundException("There is no ID3v2Tag data in this file");
	}

}