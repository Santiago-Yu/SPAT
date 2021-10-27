class n15612870 {
	public static void main(String[] LCG3noj7) {
		FileInputStream Xx0DShXp = null;
		FileOutputStream qNRJccJP = null;
		BufferedInputStream gZigS57c = null;
		BufferedOutputStream z3suGwEH = null;
		try {
			Xx0DShXp = new FileInputStream("D:/5.xls");
			qNRJccJP = new FileOutputStream("c:/Dxw.java");
			gZigS57c = new BufferedInputStream(Xx0DShXp);
			z3suGwEH = new BufferedOutputStream(qNRJccJP);
			int OWLU3w5m = gZigS57c.read();
			while (OWLU3w5m != -1) {
				z3suGwEH.write(OWLU3w5m);
				OWLU3w5m = gZigS57c.read();
			}
		} catch (IOException cGdyykW5) {
			cGdyykW5.printStackTrace();
		} finally {
			if (gZigS57c != null) {
				try {
					gZigS57c.close();
				} catch (IOException woG1wqhK) {
					woG1wqhK.printStackTrace();
				}
			}
			if (z3suGwEH != null) {
				try {
					z3suGwEH.close();
				} catch (IOException Q0lmGoYN) {
					Q0lmGoYN.printStackTrace();
				}
			}
		}
	}

}