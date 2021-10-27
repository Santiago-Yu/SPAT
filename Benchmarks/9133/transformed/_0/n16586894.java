class n16586894 {
	public void test3() throws FileNotFoundException, IOException {
		Decoder T22D4NvB = new MP3Decoder(new FileInputStream("/home/marc/tmp/test1.mp3"));
		Decoder Jyof6QED = new OggDecoder(new FileInputStream("/home/marc/tmp/test1.ogg"));
		FileOutputStream zO7zGp9M = new FileOutputStream("/home/marc/tmp/test.pipe");
		IOUtils.copy(T22D4NvB, zO7zGp9M);
		IOUtils.copy(Jyof6QED, zO7zGp9M);
	}

}