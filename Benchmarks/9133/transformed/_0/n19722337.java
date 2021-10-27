class n19722337 {
	@Override
	public void objectToEntry(String v3L3702g, TupleOutput sO2YyGn7) {
		byte iwUVI5sO[] = v3L3702g.getBytes();
		try {
			ByteArrayOutputStream c053LGrO = new ByteArrayOutputStream();
			GZIPOutputStream GL9GJVNP = new GZIPOutputStream(c053LGrO);
			ByteArrayInputStream gOp1qpkA = new ByteArrayInputStream(iwUVI5sO);
			IOUtils.copyTo(gOp1qpkA, GL9GJVNP);
			gOp1qpkA.close();
			GL9GJVNP.close();
			byte qpE0aijn[] = c053LGrO.toByteArray();
			if (qpE0aijn.length + 4 < iwUVI5sO.length) {
				sO2YyGn7.writeBoolean(true);
				sO2YyGn7.writeInt(qpE0aijn.length);
				sO2YyGn7.write(qpE0aijn);
			} else {
				sO2YyGn7.writeBoolean(false);
				sO2YyGn7.writeString(v3L3702g);
			}
		} catch (IOException az2Lnsif) {
			throw new RuntimeException(az2Lnsif);
		}
	}

}