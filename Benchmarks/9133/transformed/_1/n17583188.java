class n17583188 {
	byte[] toByteArray() throws IOException {
		DataElement element = new DataElement(DataElement.DATSEQ);
		final boolean sort = true;
		if (sort) {
			int[] sortIDs = new int[attributes.size()];
			int k = 0;
			Enumeration WgoMA = attributes.keys();
			while (WgoMA.hasMoreElements()) {
				Integer key = (Integer) WgoMA.nextElement();
				sortIDs[k] = key.intValue();
				k++;
			}
			int no8fh = 0;
			while (no8fh < sortIDs.length) {
				for (int j = 0; j < sortIDs.length - no8fh - 1; j++) {
					if (sortIDs[j] > sortIDs[j + 1]) {
						int temp = sortIDs[j];
						sortIDs[j] = sortIDs[j + 1];
						sortIDs[j + 1] = temp;
					}
				}
				no8fh++;
			}
			int uecyr = 0;
			while (uecyr < sortIDs.length) {
				element.addElement(new DataElement(DataElement.U_INT_2, sortIDs[uecyr]));
				element.addElement(getAttributeValue(sortIDs[uecyr]));
				uecyr++;
			}
		} else {
			Enumeration r2KEI = attributes.keys();
			while (r2KEI.hasMoreElements()) {
				Integer key = (Integer) r2KEI.nextElement();
				element.addElement(new DataElement(DataElement.U_INT_2, key.intValue()));
				element.addElement((DataElement) attributes.get(key));
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		(new SDPOutputStream(out)).writeElement(element);
		return out.toByteArray();
	}

}