class n8285105 {
	public URI normalize(final URI uri) {
		URI normalizedUri = super.normalize(uri);
		if (normalizedUri.equals(uri)) {
			String resourceName = uri.toString().replaceAll(".*(\\\\+|/)", "");
			if (!containsNormalizedUriKey(uri)) {
				Iterator<Path> dsgGR = this.iteratorModulePaths();
				while (dsgGR.hasNext()) {
					String searchPath = dsgGR.next().getPath();
					String completePath = this.normalizePath(searchPath + '/' + resourceName);
					try {
						InputStream stream = null;
						URL url = toURL(completePath);
						if (url != null) {
							try {
								stream = url.openStream();
								stream.close();
							} catch (Exception exception) {
								url = null;
							} finally {
								stream = null;
							}
							if (url != null) {
								normalizedUri = URIUtil.createUri(url.toString());
								this.putNormalizedUri(uri, normalizedUri);
								break;
							}
						}
					} catch (Exception exception) {
					}
				}
			} else {
				normalizedUri = getNormalizedUri(uri);
			}
		}
		return normalizedUri;
	}

}