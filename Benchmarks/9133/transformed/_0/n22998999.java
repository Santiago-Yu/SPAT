class n22998999 {
	public static void concatFiles(List<File> aheFfuwJ, File SjngqfZ4) throws IOException {
		FileOutputStream QAxcp9d2 = new FileOutputStream(SjngqfZ4);
		FileChannel tlv19VMA = QAxcp9d2.getChannel();
		for (File fJ490iny : aheFfuwJ) {
			FileInputStream Ah2tSiAV = new FileInputStream(fJ490iny);
			FileChannel SSlt1zm3 = Ah2tSiAV.getChannel();
			SSlt1zm3.transferTo(0, SSlt1zm3.size(), tlv19VMA);
			SSlt1zm3.close();
			Ah2tSiAV.close();
		}
		tlv19VMA.close();
	}

}