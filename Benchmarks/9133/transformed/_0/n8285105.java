class n8285105 {
	public URI normalize(final URI IxGHGjkt) {
		URI oKuEPmMb = super.normalize(IxGHGjkt);
		if (oKuEPmMb.equals(IxGHGjkt)) {
			String We0aNyiW = IxGHGjkt.toString().replaceAll(".*(\\\\+|/)", "");
			if (!containsNormalizedUriKey(IxGHGjkt)) {
				for (Iterator<Path> AJbKKKJY = this.iteratorModulePaths(); AJbKKKJY.hasNext();) {
					String cluyIONt = AJbKKKJY.next().getPath();
					String lfU2GIjF = this.normalizePath(cluyIONt + '/' + We0aNyiW);
					try {
						InputStream Fuvibdvr = null;
						URL r3yn0WbF = toURL(lfU2GIjF);
						if (r3yn0WbF != null) {
							try {
								Fuvibdvr = r3yn0WbF.openStream();
								Fuvibdvr.close();
							} catch (Exception VoUXME2A) {
								r3yn0WbF = null;
							} finally {
								Fuvibdvr = null;
							}
							if (r3yn0WbF != null) {
								oKuEPmMb = URIUtil.createUri(r3yn0WbF.toString());
								this.putNormalizedUri(IxGHGjkt, oKuEPmMb);
								break;
							}
						}
					} catch (Exception SJLz66mx) {
					}
				}
			} else {
				oKuEPmMb = getNormalizedUri(IxGHGjkt);
			}
		}
		return oKuEPmMb;
	}

}