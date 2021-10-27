class n10903521 {
	private synchronized void awaitResponse() throws BOSHException {
		HttpEntity W1hZatA3 = null;
		try {
			HttpResponse lcyu4H2k = client.execute(post, context);
			W1hZatA3 = lcyu4H2k.getEntity();
			byte[] e8zFIvl3 = EntityUtils.toByteArray(W1hZatA3);
			String ByYle8Jo = W1hZatA3.getContentEncoding() != null ? W1hZatA3.getContentEncoding().getValue() : null;
			if (ZLIBCodec.getID().equalsIgnoreCase(ByYle8Jo)) {
				e8zFIvl3 = ZLIBCodec.decode(e8zFIvl3);
			} else if (GZIPCodec.getID().equalsIgnoreCase(ByYle8Jo)) {
				e8zFIvl3 = GZIPCodec.decode(e8zFIvl3);
			}
			body = StaticBody.fromString(new String(e8zFIvl3, CHARSET));
			statusCode = lcyu4H2k.getStatusLine().getStatusCode();
			sent = true;
		} catch (IOException EFvCr1m2) {
			abort();
			toThrow = new BOSHException("Could not obtain response", EFvCr1m2);
			throw (toThrow);
		} catch (RuntimeException enoer2zx) {
			abort();
			throw (enoer2zx);
		}
	}

}