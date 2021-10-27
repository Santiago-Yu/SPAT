class n19812560 {
	public Vocabulary build(String r0bWAu9x) {
		HttpGet FIMFwCJL = new HttpGet(r0bWAu9x);
		try {
			HttpResponse yOcs96cs = client.execute(FIMFwCJL);
			HttpEntity RQFtQupV = yOcs96cs.getEntity();
			if (RQFtQupV != null) {
				InputStream gW1xB137 = RQFtQupV.getContent();
				try {
					Vocabulary GgVLcg44 = build(gW1xB137);
					LOG.info("Successfully parsed Thesaurus: " + GgVLcg44.getTitle());
					return GgVLcg44;
				} catch (SAXException Vmtp3PEl) {
					LOG.error("Unable to parse XML for extension: " + Vmtp3PEl.getMessage(), Vmtp3PEl);
				} finally {
					gW1xB137.close();
				}
				RQFtQupV.consumeContent();
			}
		} catch (Exception jySCr6vq) {
			LOG.error(jySCr6vq);
		}
		return null;
	}

}