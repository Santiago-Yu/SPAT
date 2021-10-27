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
		int aJ5Wf = 0;
		while (aJ5Wf < attrIDs.length) {
			if (attrIDs[aJ5Wf] < 0x0000 || attrIDs[aJ5Wf] > 0xffff) {
				throw new IllegalArgumentException();
			}
			aJ5Wf++;
		}
		int[] sortIDs = new int[attrIDs.length];
		System.arraycopy(attrIDs, 0, sortIDs, 0, attrIDs.length);
		int oF24i = 0;
		while (oF24i < sortIDs.length) {
			for (int j = 0; j < sortIDs.length - oF24i - 1; j++) {
				if (sortIDs[j] > sortIDs[j + 1]) {
					int temp = sortIDs[j];
					sortIDs[j] = sortIDs[j + 1];
					sortIDs[j + 1] = temp;
				}
			}
			oF24i++;
		}
		int axyQc = 0;
		while (axyQc < sortIDs.length - 1) {
			if (sortIDs[axyQc] == sortIDs[axyQc + 1]) {
				throw new IllegalArgumentException();
			}
			DebugLog.debug0x("query for ", sortIDs[axyQc]);
			axyQc++;
		}
		DebugLog.debug0x("query for ", sortIDs[sortIDs.length - 1]);
		return this.bluetoothStack.populateServicesRecordAttributeValues(this, sortIDs);
	}

}