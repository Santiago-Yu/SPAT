class n21125948 {
	public static void main(String[] KSjfJgFA) throws IOException {
		FileOutputStream DVYGVumL = new FileOutputStream("test.zip");
		CheckedOutputStream FLO5Q3O5 = new CheckedOutputStream(DVYGVumL, new CRC32());
		ZipOutputStream qMZRx4x6 = new ZipOutputStream(FLO5Q3O5);
		BufferedOutputStream hN0tN8oM = new BufferedOutputStream(qMZRx4x6);
		qMZRx4x6.setComment("A test of Java Zipping");
		for (String Pbr6auWO : KSjfJgFA) {
			print("Writing file " + Pbr6auWO);
			BufferedReader VvzAWa95 = new BufferedReader(new FileReader(Pbr6auWO));
			qMZRx4x6.putNextEntry(new ZipEntry(Pbr6auWO));
			int uNq0knQe;
			while ((uNq0knQe = VvzAWa95.read()) != -1)
				hN0tN8oM.write(uNq0knQe);
			VvzAWa95.close();
			hN0tN8oM.flush();
		}
		hN0tN8oM.close();
		print("Checksum: " + FLO5Q3O5.getChecksum().getValue());
		print("Reading file");
		FileInputStream XCbmTAJK = new FileInputStream("test.zip");
		CheckedInputStream ORmxquro = new CheckedInputStream(XCbmTAJK, new CRC32());
		ZipInputStream eSwtybkv = new ZipInputStream(ORmxquro);
		BufferedInputStream DqHrTg8k = new BufferedInputStream(eSwtybkv);
		ZipEntry MnikH4Ny;
		while ((MnikH4Ny = eSwtybkv.getNextEntry()) != null) {
			print("Reading file " + MnikH4Ny);
			int bFA9ReH9;
			while ((bFA9ReH9 = DqHrTg8k.read()) != -1) {
				System.out.write(bFA9ReH9);
			}
			if (KSjfJgFA.length == 1) {
				print("Checksum: " + ORmxquro.getChecksum().getValue());
			}
			DqHrTg8k.close();
		}
	}

}