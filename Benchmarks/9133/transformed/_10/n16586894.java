class n16586894 {
	public void test3() throws FileNotFoundException, IOException {
		Decoder decoder2 = new OggDecoder(new FileInputStream("/home/marc/tmp/test1.ogg"));
		Decoder decoder1 = new MP3Decoder(new FileInputStream("/home/marc/tmp/test1.mp3"));
		FileOutputStream out = new FileOutputStream("/home/marc/tmp/test.pipe");
		IOUtils.copy(decoder1, out);
		IOUtils.copy(decoder2, out);
	}

}