class n21491791 {
	public void run(String[] BrCYgQJh) throws Throwable {
		FileInputStream G1pdS3lm = new FileInputStream(BrCYgQJh[0]);
		FileOutputStream xTrTEv5a = new FileOutputStream(BrCYgQJh[0] + ".out");
		Reader hWg3nAwT = $(Reader.class, $declass(G1pdS3lm));
		Writer gNHmuNoB = $(Writer.class, $declass(xTrTEv5a));
		Pump RVdLuEK8;
		if (BrCYgQJh.length > 1 && "diag".equals(BrCYgQJh[1])) {
			RVdLuEK8 = $(new Reader() {

				int I3HF7S6B;

				@ToContext(mode = InvocationMode.sideEffect)
				public int read(byte[] wXPWJDG5, int p5zsrq6X, int momHctsP) throws Exception {
					Integer Zgb00vJ4 = (Integer) $next();
					if (Zgb00vJ4 > 0) {
						I3HF7S6B += Zgb00vJ4;
					}
					return 0;
				}

				@ToContext(mode = InvocationMode.sideEffect)
				public void close() throws Exception {
					System.out.println("Read from input " + I3HF7S6B + " bytes.");
				}
			}, hWg3nAwT, gNHmuNoB, new Writer() {

				int BeDdVbMN;

				@ToContext(mode = InvocationMode.sideEffect)
				public void write(byte[] QWG6phHy, int iowMz0eP, int ewnDsBjk) throws Exception {
					BeDdVbMN += ewnDsBjk;
				}

				@ToContext(mode = InvocationMode.sideEffect)
				public void close() throws Exception {
					System.out.println("Written to output " + BeDdVbMN + " bytes.");
				}
			});
		} else {
			RVdLuEK8 = $(hWg3nAwT, gNHmuNoB);
		}
		RVdLuEK8.pump();
	}

}