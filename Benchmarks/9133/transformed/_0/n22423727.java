class n22423727 {
	public void copyFile(String Ip2TjSD7, String rXlK1Vkn) {
		FileWriter wFCuwRby = null;
		FileReader hBtTvi9o = null;
		BufferedReader W7A5jMTv = null;
		BufferedWriter SXerzpqC = null;
		File V2oeEFlj = null;
		try {
			hBtTvi9o = new FileReader(Ip2TjSD7);
			wFCuwRby = new FileWriter(rXlK1Vkn);
			W7A5jMTv = new BufferedReader(hBtTvi9o);
			SXerzpqC = new BufferedWriter(wFCuwRby);
			V2oeEFlj = new File(Ip2TjSD7);
			int V7nPkS6V = (int) V2oeEFlj.length();
			char yiPWdeCx[] = new char[V7nPkS6V];
			while (W7A5jMTv.read(yiPWdeCx, 0, V7nPkS6V) != -1)
				SXerzpqC.write(yiPWdeCx, 0, V7nPkS6V);
		} catch (FileNotFoundException xUnggxyh) {
			System.out.println(Ip2TjSD7 + " does not exist!");
		} catch (IOException zag28gAH) {
			System.out.println("Error reading/writing files!");
		} finally {
			try {
				if (W7A5jMTv != null)
					W7A5jMTv.close();
				if (SXerzpqC != null)
					SXerzpqC.close();
			} catch (IOException FbBQXRSc) {
			}
		}
	}

}