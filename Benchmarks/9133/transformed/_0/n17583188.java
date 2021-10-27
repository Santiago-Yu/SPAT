class n17583188 {
	byte[] toByteArray() throws IOException {
		DataElement D8QQnUsB = new DataElement(DataElement.DATSEQ);
		final boolean lZDkOUuF = true;
		if (lZDkOUuF) {
			int[] zM5MCnol = new int[attributes.size()];
			int BaiVQzwz = 0;
			for (Enumeration ikMbWcJv = attributes.keys(); ikMbWcJv.hasMoreElements();) {
				Integer mKwbxUkq = (Integer) ikMbWcJv.nextElement();
				zM5MCnol[BaiVQzwz] = mKwbxUkq.intValue();
				BaiVQzwz++;
			}
			for (int kmXJKYzW = 0; kmXJKYzW < zM5MCnol.length; kmXJKYzW++) {
				for (int Am0dhhPO = 0; Am0dhhPO < zM5MCnol.length - kmXJKYzW - 1; Am0dhhPO++) {
					if (zM5MCnol[Am0dhhPO] > zM5MCnol[Am0dhhPO + 1]) {
						int pTSu4vxG = zM5MCnol[Am0dhhPO];
						zM5MCnol[Am0dhhPO] = zM5MCnol[Am0dhhPO + 1];
						zM5MCnol[Am0dhhPO + 1] = pTSu4vxG;
					}
				}
			}
			for (int XezuHL2E = 0; XezuHL2E < zM5MCnol.length; XezuHL2E++) {
				D8QQnUsB.addElement(new DataElement(DataElement.U_INT_2, zM5MCnol[XezuHL2E]));
				D8QQnUsB.addElement(getAttributeValue(zM5MCnol[XezuHL2E]));
			}
		} else {
			for (Enumeration SqIsMUXr = attributes.keys(); SqIsMUXr.hasMoreElements();) {
				Integer IXmiLWym = (Integer) SqIsMUXr.nextElement();
				D8QQnUsB.addElement(new DataElement(DataElement.U_INT_2, IXmiLWym.intValue()));
				D8QQnUsB.addElement((DataElement) attributes.get(IXmiLWym));
			}
		}
		ByteArrayOutputStream l1hllMCv = new ByteArrayOutputStream();
		(new SDPOutputStream(l1hllMCv)).writeElement(D8QQnUsB);
		return l1hllMCv.toByteArray();
	}

}