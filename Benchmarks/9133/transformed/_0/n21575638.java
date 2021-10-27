class n21575638 {
	protected void writeGZippedBytes(byte cgDMvrpf[], TupleOutput YMJ62ENd) {
		if (cgDMvrpf == null || cgDMvrpf.length == 0) {
			YMJ62ENd.writeBoolean(false);
			writeBytes(cgDMvrpf, YMJ62ENd);
			return;
		}
		try {
			ByteArrayOutputStream fesKYBpB = new ByteArrayOutputStream(cgDMvrpf.length);
			GZIPOutputStream KoSY9uOT = new GZIPOutputStream(fesKYBpB);
			ByteArrayInputStream uumHIIx0 = new ByteArrayInputStream(cgDMvrpf);
			IOUtils.copyTo(uumHIIx0, KoSY9uOT);
			KoSY9uOT.finish();
			KoSY9uOT.close();
			uumHIIx0.close();
			byte ZIHGezYQ[] = fesKYBpB.toByteArray();
			if (ZIHGezYQ.length < cgDMvrpf.length) {
				YMJ62ENd.writeBoolean(true);
				writeBytes(ZIHGezYQ, YMJ62ENd);
			} else {
				YMJ62ENd.writeBoolean(false);
				writeBytes(cgDMvrpf, YMJ62ENd);
			}
		} catch (IOException iEJfrJ2d) {
			throw new RuntimeException(iEJfrJ2d);
		}
	}

}