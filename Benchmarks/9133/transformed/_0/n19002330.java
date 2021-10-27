class n19002330 {
	public static void copyFile(File pgX8ZtQR, File N8e7gsL5)
			throws ResourceNotFoundException, ParseErrorException, Exception {
		if (pgX8ZtQR.getAbsolutePath().endsWith(".vm")) {
			copyVMFile(pgX8ZtQR,
					N8e7gsL5.getAbsolutePath().substring(0, N8e7gsL5.getAbsolutePath().lastIndexOf(".vm")));
		} else {
			FileInputStream pDAmFUGB;
			FileOutputStream pqYI7HOT;
			FileChannel qDrloZSg, HcrSUgjs;
			long uO4tQoN5;
			MappedByteBuffer iJx51QDJ;
			pDAmFUGB = new FileInputStream(pgX8ZtQR);
			pqYI7HOT = new FileOutputStream(N8e7gsL5);
			qDrloZSg = pDAmFUGB.getChannel();
			HcrSUgjs = pqYI7HOT.getChannel();
			uO4tQoN5 = qDrloZSg.size();
			iJx51QDJ = qDrloZSg.map(FileChannel.MapMode.READ_ONLY, 0, uO4tQoN5);
			HcrSUgjs.write(iJx51QDJ);
			qDrloZSg.close();
			pDAmFUGB.close();
			HcrSUgjs.close();
			pqYI7HOT.close();
		}
	}

}