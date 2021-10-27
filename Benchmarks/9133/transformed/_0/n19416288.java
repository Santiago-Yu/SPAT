class n19416288 {
	private void zip(String J3ESJv9Y, TupleOutput vDqSjbTG) {
		byte LRTjHyyb[] = J3ESJv9Y.getBytes();
		try {
			ByteArrayOutputStream bM0JyLat = new ByteArrayOutputStream();
			GZIPOutputStream IcQzsrdM = new GZIPOutputStream(bM0JyLat);
			ByteArrayInputStream YGvLcHJ6 = new ByteArrayInputStream(LRTjHyyb);
			IOUtils.copyTo(YGvLcHJ6, IcQzsrdM);
			YGvLcHJ6.close();
			IcQzsrdM.close();
			byte LPGBRHuQ[] = bM0JyLat.toByteArray();
			if (LPGBRHuQ.length + 4 < LRTjHyyb.length) {
				vDqSjbTG.writeBoolean(true);
				vDqSjbTG.writeInt(LPGBRHuQ.length);
				vDqSjbTG.write(LPGBRHuQ);
			} else {
				vDqSjbTG.writeBoolean(false);
				vDqSjbTG.writeString(J3ESJv9Y);
			}
		} catch (IOException u7Izowpj) {
			throw new RuntimeException(u7Izowpj);
		}
	}

}