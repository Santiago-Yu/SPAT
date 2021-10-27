class n22026286 {
	public static void main(String kXStAaGe[]) {
		int XkGC1QUy, n435aTsQ, Te48EVDb;
		short E71ALBVv = 100;
		short nSWmLbCR[] = new short[E71ALBVv];
		printIntro();
		int HcH27a8D = (int) System.currentTimeMillis();
		for (XkGC1QUy = 0; XkGC1QUy < E71ALBVv; XkGC1QUy++) {
			nSWmLbCR[XkGC1QUy] = (short) (E71ALBVv - 1 - XkGC1QUy);
		}
		for (XkGC1QUy = 0; XkGC1QUy < E71ALBVv; XkGC1QUy++) {
			for (n435aTsQ = 0; n435aTsQ < E71ALBVv - XkGC1QUy - 1; n435aTsQ++) {
				if (nSWmLbCR[n435aTsQ] > nSWmLbCR[n435aTsQ + 1]) {
					short o9FgYhP2 = nSWmLbCR[n435aTsQ];
					nSWmLbCR[n435aTsQ] = nSWmLbCR[n435aTsQ + 1];
					nSWmLbCR[n435aTsQ + 1] = o9FgYhP2;
				}
			}
			if (WANT_PROGRESS) {
				printProgress();
			}
		}
		HcH27a8D = (int) System.currentTimeMillis() - HcH27a8D;
		System.out.print(HcH27a8D);
		System.out.print("End\n");
	}

}