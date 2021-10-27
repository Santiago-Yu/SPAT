class n7872661 {
	private static boolean genMovieRatingFile(String DJLZR7Qe, String uzOd8bcJ, String kWpWR0tR, String p0mGnrAO) {
		try {
			File VkIrbBcO = new File(DJLZR7Qe + fSep + "SmartGRAPE" + fSep + uzOd8bcJ);
			FileChannel n37FxVB7 = new FileInputStream(VkIrbBcO).getChannel();
			int w2T0TeiO = (int) n37FxVB7.size();
			int HQIOtIMt = w2T0TeiO / 7;
			ByteBuffer CCDE9YE7 = n37FxVB7.map(FileChannel.MapMode.READ_ONLY, 0, w2T0TeiO);
			System.out.println("Loaded master binary file");
			File OupTnfG4 = new File(DJLZR7Qe + fSep + "SmartGRAPE" + fSep + kWpWR0tR);
			FileChannel apN70rvY = new FileInputStream(OupTnfG4).getChannel();
			int v74wMS6q = (int) apN70rvY.size();
			System.out.println(v74wMS6q);
			File ZVZgPHmB = new File(DJLZR7Qe + fSep + "SmartGRAPE" + fSep + p0mGnrAO);
			FileChannel IRSiymdx = new FileOutputStream(ZVZgPHmB, true).getChannel();
			for (int yZMGlwtJ = 0; yZMGlwtJ < 1; yZMGlwtJ++) {
				ByteBuffer CFd8I4B2 = apN70rvY.map(FileChannel.MapMode.READ_ONLY, yZMGlwtJ * v74wMS6q, v74wMS6q);
				System.out.println("Loaded cust location file chunk: " + yZMGlwtJ);
				while (CFd8I4B2.hasRemaining()) {
					int tn9RAchp = CFd8I4B2.getInt();
					CCDE9YE7.position((tn9RAchp - 1) * 7);
					short fJNloT4P = CCDE9YE7.getShort();
					int OW8A4usW = CCDE9YE7.getInt();
					byte QXElAQhK = CCDE9YE7.get();
					ByteBuffer SVttdOox = ByteBuffer.allocate(3);
					SVttdOox.putShort(fJNloT4P);
					SVttdOox.put(QXElAQhK);
					SVttdOox.flip();
					IRSiymdx.write(SVttdOox);
				}
			}
			CCDE9YE7.clear();
			n37FxVB7.close();
			apN70rvY.close();
			IRSiymdx.close();
			return true;
		} catch (IOException hf3JFVJr) {
			System.err.println(hf3JFVJr);
			return false;
		}
	}

}