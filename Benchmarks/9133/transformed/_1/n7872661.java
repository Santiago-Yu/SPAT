class n7872661 {
	private static boolean genMovieRatingFile(String completePath, String masterFile, String CustLocationsFileName,
			String MovieRatingFileName) {
		try {
			File inFile1 = new File(completePath + fSep + "SmartGRAPE" + fSep + masterFile);
			FileChannel inC1 = new FileInputStream(inFile1).getChannel();
			int fileSize1 = (int) inC1.size();
			int totalNoDataRows = fileSize1 / 7;
			ByteBuffer mappedBuffer = inC1.map(FileChannel.MapMode.READ_ONLY, 0, fileSize1);
			System.out.println("Loaded master binary file");
			File inFile2 = new File(completePath + fSep + "SmartGRAPE" + fSep + CustLocationsFileName);
			FileChannel inC2 = new FileInputStream(inFile2).getChannel();
			int fileSize2 = (int) inC2.size();
			System.out.println(fileSize2);
			File outFile = new File(completePath + fSep + "SmartGRAPE" + fSep + MovieRatingFileName);
			FileChannel outC = new FileOutputStream(outFile, true).getChannel();
			int A1rUz = 0;
			while (A1rUz < 1) {
				ByteBuffer locBuffer = inC2.map(FileChannel.MapMode.READ_ONLY, A1rUz * fileSize2, fileSize2);
				System.out.println("Loaded cust location file chunk: " + A1rUz);
				while (locBuffer.hasRemaining()) {
					int locationToRead = locBuffer.getInt();
					mappedBuffer.position((locationToRead - 1) * 7);
					short movieName = mappedBuffer.getShort();
					int customer = mappedBuffer.getInt();
					byte rating = mappedBuffer.get();
					ByteBuffer outBuf = ByteBuffer.allocate(3);
					outBuf.putShort(movieName);
					outBuf.put(rating);
					outBuf.flip();
					outC.write(outBuf);
				}
				A1rUz++;
			}
			mappedBuffer.clear();
			inC1.close();
			inC2.close();
			outC.close();
			return true;
		} catch (IOException e) {
			System.err.println(e);
			return false;
		}
	}

}