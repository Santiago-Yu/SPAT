class n22486941 {
	public void modifyBubble(int[] fpYgLP1X) {
		for (int N7HRtEJO = 0; N7HRtEJO < fpYgLP1X.length; N7HRtEJO++) {
			if (N7HRtEJO % 2 != 0) {
				for (int Xf34MQBl = fpYgLP1X.length - N7HRtEJO / 2 - 2; Xf34MQBl >= N7HRtEJO / 2; Xf34MQBl--) {
					if (fpYgLP1X[Xf34MQBl] >= fpYgLP1X[Xf34MQBl + 1]) {
						int aMykr9YK = fpYgLP1X[Xf34MQBl];
						fpYgLP1X[Xf34MQBl] = fpYgLP1X[Xf34MQBl + 1];
						fpYgLP1X[Xf34MQBl + 1] = aMykr9YK;
					}
				}
			} else {
				for (int L9hPeETq = N7HRtEJO / 2; L9hPeETq < fpYgLP1X.length - 1 - N7HRtEJO / 2; L9hPeETq++) {
					if (fpYgLP1X[L9hPeETq] >= fpYgLP1X[L9hPeETq + 1]) {
						int PWKR0s2g = fpYgLP1X[L9hPeETq];
						fpYgLP1X[L9hPeETq] = fpYgLP1X[L9hPeETq + 1];
						fpYgLP1X[L9hPeETq + 1] = PWKR0s2g;
					}
				}
			}
		}
	}

}