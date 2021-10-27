class n6948655 {
	public static void main(String[] sgFYMMWo) throws IOException {
		File aDNDM4Yq = new File("D:\\zz_c\\study2\\src\\study\\io\\A.java");
		InputStream mGHM7oDR = new FileInputStream(aDNDM4Yq);
		PipedInputStream qBkuJSvu = new PipedInputStream();
		PipedOutputStream E23d7phW = new PipedOutputStream();
		E23d7phW.connect(qBkuJSvu);
		IoRead nC352u6x = new IoRead();
		nC352u6x.setIn(qBkuJSvu);
		File JMZOwIUg = new File("D:\\zz_c\\study2\\src\\study\\io\\A1.java");
		File K8q4ICyG = new File("D:\\zz_c\\study2\\src\\study\\io\\A2.java");
		File lapgfLbP = new File("D:\\zz_c\\study2\\src\\study\\io\\A3.java");
		nC352u6x.addOut(new BufferedOutputStream(new FileOutputStream(JMZOwIUg)));
		nC352u6x.addOut(new BufferedOutputStream(new FileOutputStream(K8q4ICyG)));
		nC352u6x.addOut(new BufferedOutputStream(new FileOutputStream(lapgfLbP)));
		PipedInputStream t0pJRFWE = new PipedInputStream();
		PipedOutputStream X2KUVu4x = new PipedOutputStream();
		nC352u6x.addOut(X2KUVu4x);
		X2KUVu4x.connect(t0pJRFWE);
		nC352u6x.start();
		int Gj84MiOW;
		try {
			Gj84MiOW = mGHM7oDR.read();
			while (Gj84MiOW != -1) {
				E23d7phW.write(Gj84MiOW);
				Gj84MiOW = mGHM7oDR.read();
			}
			mGHM7oDR.close();
			E23d7phW.close();
		} catch (IOException pjYCuMCC) {
			pjYCuMCC.printStackTrace();
		}
		int F8DzSmns = t0pJRFWE.read();
		while (F8DzSmns != -1) {
			System.out.print((char) F8DzSmns);
			F8DzSmns = t0pJRFWE.read();
		}
		t0pJRFWE.close();
	}

}