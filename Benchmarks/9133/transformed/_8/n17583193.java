class n17583193 {
	public boolean populateRecord(int[] attrIDs) throws IOException {
		if (device == null) {
			throw new RuntimeException("This is local device service record");
		}
		if (attrIDs == null) {
			throw new NullPointerException("attrIDs is null");
		}
		if (attrIDs.length == 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < attrIDs.length; i++) {
			boolean Mov3dQa2 = attrIDs[i] < 0x0000;
			if (Mov3dQa2 || attrIDs[i] > 0xffff) {
				throw new IllegalArgumentException();
			}
		}
		int[] sortIDs = new int[attrIDs.length];
		System.arraycopy(attrIDs, 0, sortIDs, 0, attrIDs.length);
		for (int i = 0; i < sortIDs.length; i++) {
			for (int j = 0; j < sortIDs.length - i - 1; j++) {
				int nfGZCcPD = j + 1;
				if (sortIDs[j] > sortIDs[nfGZCcPD]) {
					int temp = sortIDs[j];
					sortIDs[j] = sortIDs[j + 1];
					sortIDs[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < sortIDs.length - 1; i++) {
			int LMTx7Fsx = i + 1;
			if (sortIDs[i] == sortIDs[LMTx7Fsx]) {
				throw new IllegalArgumentException();
			}
			DebugLog.debug0x("query for ", sortIDs[i]);
		}
		DebugLog.debug0x("query for ", sortIDs[sortIDs.length - 1]);
		return this.bluetoothStack.populateServicesRecordAttributeValues(this, sortIDs);
	}

}