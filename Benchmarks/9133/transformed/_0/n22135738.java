class n22135738 {
	protected void sort(double[] QeSEZCLf) throws Exception {
		for (int cfsGAatk = QeSEZCLf.length - 1; cfsGAatk >= 0; cfsGAatk--) {
			boolean QuFOCQ5m = false;
			for (int r4QqGmtU = 0; r4QqGmtU < cfsGAatk; r4QqGmtU++) {
				if (QeSEZCLf[r4QqGmtU] > QeSEZCLf[r4QqGmtU + 1]) {
					double YYgcPay5 = QeSEZCLf[r4QqGmtU];
					QeSEZCLf[r4QqGmtU] = QeSEZCLf[r4QqGmtU + 1];
					QeSEZCLf[r4QqGmtU + 1] = YYgcPay5;
					QuFOCQ5m = true;
				}
			}
			if (!QuFOCQ5m)
				return;
		}
	}

}