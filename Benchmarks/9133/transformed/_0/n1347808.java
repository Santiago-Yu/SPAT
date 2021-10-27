class n1347808 {
	public static void main(String[] YYcHMAO1) throws IOException {
		FileOutputStream zvIqLOGM = new FileOutputStream("test.zip");
		CheckedOutputStream ptuI6mqz = new CheckedOutputStream(zvIqLOGM, new Adler32());
		ZipOutputStream QaI88pG9 = new ZipOutputStream(ptuI6mqz);
		BufferedOutputStream V2bLeK0K = new BufferedOutputStream(QaI88pG9);
		QaI88pG9.setComment("A test of Java Zipping");
		for (String nGk5nRmV : YYcHMAO1) {
			print("Writing file " + nGk5nRmV);
			BufferedReader wOkROYvv = new BufferedReader(new FileReader(nGk5nRmV));
			QaI88pG9.putNextEntry(new ZipEntry(nGk5nRmV));
			int K4H8QP97;
			while ((K4H8QP97 = wOkROYvv.read()) != -1)
				V2bLeK0K.write(K4H8QP97);
			wOkROYvv.close();
			V2bLeK0K.flush();
		}
		V2bLeK0K.close();
		print("Checksum: " + ptuI6mqz.getChecksum().getValue());
		print("Reading file");
		FileInputStream ktGZapwF = new FileInputStream("test.zip");
		CheckedInputStream H6lbM1qp = new CheckedInputStream(ktGZapwF, new Adler32());
		ZipInputStream l6JnYdNU = new ZipInputStream(H6lbM1qp);
		BufferedInputStream riSLOvL9 = new BufferedInputStream(l6JnYdNU);
		ZipEntry OEEUtpwr;
		while ((OEEUtpwr = l6JnYdNU.getNextEntry()) != null) {
			print("Reading file " + OEEUtpwr);
			int ouQDGU0T;
			while ((ouQDGU0T = riSLOvL9.read()) != -1)
				System.out.write(ouQDGU0T);
		}
		if (YYcHMAO1.length == 1)
			print("Checksum: " + H6lbM1qp.getChecksum().getValue());
		riSLOvL9.close();
		ZipFile TVAWJagu = new ZipFile("test.zip");
		Enumeration TysBmfpw = TVAWJagu.entries();
		while (TysBmfpw.hasMoreElements()) {
			ZipEntry chyYDkTr = (ZipEntry) TysBmfpw.nextElement();
			print("File: " + chyYDkTr);
		}
	}

}