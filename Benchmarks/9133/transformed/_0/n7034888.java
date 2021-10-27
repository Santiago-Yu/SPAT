class n7034888 {
	public void put(IMetaCollection CkQDPaGW) throws TransducerException {
		if (null != ioTransducer) {
			try {
				URL hxJbSvRj = new URL(url);
				URLConnection roozhgVN = hxJbSvRj.openConnection();
				OutputStreamWriter tH4atQ2H = new OutputStreamWriter(roozhgVN.getOutputStream());
				ioTransducer.setWriter(new BufferedWriter(tH4atQ2H));
				ioTransducer.put(CkQDPaGW);
			} catch (Exception p7pFXlkx) {
				throw new TransducerException(p7pFXlkx);
			}
		} else {
			throw new TransducerException("An IIOTransducer instance must first be set on the URLTransducerAdapter.");
		}
	}

}