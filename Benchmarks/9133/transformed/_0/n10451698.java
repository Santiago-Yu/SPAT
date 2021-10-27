class n10451698 {
	private void copy(File vLAOf9cT, File Ry3Y7Q9m) throws IOException {
		if (vLAOf9cT.isDirectory()) {
			File NYoL2c9B = new File(Ry3Y7Q9m, vLAOf9cT.getName());
			NYoL2c9B.mkdir();
			File[] bQGydSPy = vLAOf9cT.listFiles();
			for (int rtFY3LIE = 0; rtFY3LIE < bQGydSPy.length; rtFY3LIE++) {
				if (bQGydSPy[rtFY3LIE].getName().equals(".svn")) {
					continue;
				}
				copy(bQGydSPy[rtFY3LIE], NYoL2c9B);
			}
		} else {
			File nNcPhOIN = new File(Ry3Y7Q9m, vLAOf9cT.getName());
			if (nNcPhOIN.exists() && vLAOf9cT.lastModified() == nNcPhOIN.lastModified()) {
				return;
			}
			FileOutputStream YBPH33ih = new FileOutputStream(nNcPhOIN);
			FileInputStream OpmQmGMV = new FileInputStream(vLAOf9cT);
			byte[] kmxDyAn2 = new byte[2048];
			int nLoSf6o2 = 0;
			while ((nLoSf6o2 = OpmQmGMV.read(kmxDyAn2)) > 0) {
				YBPH33ih.write(kmxDyAn2, 0, nLoSf6o2);
			}
			YBPH33ih.flush();
			YBPH33ih.close();
			OpmQmGMV.close();
		}
	}

}