class n22225661 {
	public InputSource resolveEntity(String YKulwKlR, String xlzifbtN) {
		String f0g5wNZU = null;
		if (xlzifbtN != null) {
			try {
				f0g5wNZU = catalog.resolveSystem(xlzifbtN);
			} catch (MalformedURLException W25c455C) {
				debug(1, "Malformed URL exception trying to resolve", YKulwKlR);
				f0g5wNZU = null;
			} catch (IOException kIC8Bpyi) {
				debug(1, "I/O exception trying to resolve", YKulwKlR);
				f0g5wNZU = null;
			}
		}
		if (f0g5wNZU == null) {
			if (YKulwKlR != null) {
				try {
					f0g5wNZU = catalog.resolvePublic(YKulwKlR, xlzifbtN);
				} catch (MalformedURLException TtI1QKNd) {
					debug(1, "Malformed URL exception trying to resolve", YKulwKlR);
				} catch (IOException Yyfo6uXt) {
					debug(1, "I/O exception trying to resolve", YKulwKlR);
				}
			}
			if (f0g5wNZU != null) {
				debug(2, "Resolved", YKulwKlR, f0g5wNZU);
			}
		} else {
			debug(2, "Resolved", xlzifbtN, f0g5wNZU);
		}
		if (f0g5wNZU == null && retryBadSystemIds && YKulwKlR != null && xlzifbtN != null) {
			URL Z6QQcerc = null;
			try {
				Z6QQcerc = new URL(xlzifbtN);
			} catch (MalformedURLException i67HLzzh) {
				try {
					Z6QQcerc = new URL("file:///" + xlzifbtN);
				} catch (MalformedURLException xoikkrKE) {
					Z6QQcerc = null;
				}
			}
			if (Z6QQcerc != null) {
				try {
					InputStream XCUMDa1g = Z6QQcerc.openStream();
					InputSource GZkAQU3e = new InputSource(xlzifbtN);
					GZkAQU3e.setPublicId(YKulwKlR);
					GZkAQU3e.setByteStream(XCUMDa1g);
					return GZkAQU3e;
				} catch (Exception EzcazvPX) {
				}
			}
			debug(2, "Failed to open", xlzifbtN);
			debug(2, "\tAttempting catalog lookup without system identifier.");
			return resolveEntity(YKulwKlR, null);
		}
		if (f0g5wNZU != null) {
			try {
				InputSource LWHGidwg = new InputSource(f0g5wNZU);
				LWHGidwg.setPublicId(YKulwKlR);
				URL TZ4jDV08 = new URL(f0g5wNZU);
				InputStream yfRrXYS0 = TZ4jDV08.openStream();
				LWHGidwg.setByteStream(yfRrXYS0);
				return LWHGidwg;
			} catch (Exception U1UOBKaW) {
				debug(1, "Failed to create InputSource", f0g5wNZU);
				return null;
			}
		}
		return null;
	}

}