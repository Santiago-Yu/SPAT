class n2825450 {
	public static void copy(File HLuz4Yb3, File b0O8umBw) throws IOException {
		FileChannel SDpbQDav = null, vTIwlU1P = null;
		try {
			SDpbQDav = new FileInputStream(HLuz4Yb3).getChannel();
			vTIwlU1P = new FileOutputStream(b0O8umBw).getChannel();
			long kzw5Zkm8 = SDpbQDav.size();
			MappedByteBuffer RYkXvaHZ = SDpbQDav.map(FileChannel.MapMode.READ_ONLY, 0, kzw5Zkm8);
			vTIwlU1P.write(RYkXvaHZ);
		} finally {
			if (SDpbQDav != null)
				SDpbQDav.close();
			if (vTIwlU1P != null)
				vTIwlU1P.close();
		}
	}

}