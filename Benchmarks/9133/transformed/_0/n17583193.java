class n17583193 {
	public boolean populateRecord(int[] Zvwpk18x) throws IOException {
		if (device == null) {
			throw new RuntimeException("This is local device service record");
		}
		if (Zvwpk18x == null) {
			throw new NullPointerException("attrIDs is null");
		}
		if (Zvwpk18x.length == 0) {
			throw new IllegalArgumentException();
		}
		for (int fxVkqZzC = 0; fxVkqZzC < Zvwpk18x.length; fxVkqZzC++) {
			if (Zvwpk18x[fxVkqZzC] < 0x0000 || Zvwpk18x[fxVkqZzC] > 0xffff) {
				throw new IllegalArgumentException();
			}
		}
		int[] JWc2uR0N = new int[Zvwpk18x.length];
		System.arraycopy(Zvwpk18x, 0, JWc2uR0N, 0, Zvwpk18x.length);
		for (int sTPoPviw = 0; sTPoPviw < JWc2uR0N.length; sTPoPviw++) {
			for (int bWNlTxZZ = 0; bWNlTxZZ < JWc2uR0N.length - sTPoPviw - 1; bWNlTxZZ++) {
				if (JWc2uR0N[bWNlTxZZ] > JWc2uR0N[bWNlTxZZ + 1]) {
					int zDkyEBNW = JWc2uR0N[bWNlTxZZ];
					JWc2uR0N[bWNlTxZZ] = JWc2uR0N[bWNlTxZZ + 1];
					JWc2uR0N[bWNlTxZZ + 1] = zDkyEBNW;
				}
			}
		}
		for (int nr4en7Uz = 0; nr4en7Uz < JWc2uR0N.length - 1; nr4en7Uz++) {
			if (JWc2uR0N[nr4en7Uz] == JWc2uR0N[nr4en7Uz + 1]) {
				throw new IllegalArgumentException();
			}
			DebugLog.debug0x("query for ", JWc2uR0N[nr4en7Uz]);
		}
		DebugLog.debug0x("query for ", JWc2uR0N[JWc2uR0N.length - 1]);
		return this.bluetoothStack.populateServicesRecordAttributeValues(this, JWc2uR0N);
	}

}