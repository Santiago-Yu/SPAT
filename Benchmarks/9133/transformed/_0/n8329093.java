class n8329093 {
	public void parse(ParserEvent XrAEkMaV) {
		logger.debug("parse() called for link " + XrAEkMaV.getLink().getURI());
		if (XrAEkMaV.getLink().getURI().matches(itemFilter)) {
			logger.debug("Content " + XrAEkMaV.getLink().getURI() + " matched");
			Statement VtmO5H9r = null;
			ResultSet rWgGAFHS = null;
			long ImfVYVls = 0;
			try {
				URL iLQ6D94y = new URL(XrAEkMaV.getLink().getURI());
				ImfVYVls = iLQ6D94y.openConnection().getLastModified();
			} catch (MalformedURLException fiD3etDL) {
				logger.error("Malformed url " + XrAEkMaV.getLink().getURI() + " - " + fiD3etDL.getMessage());
				return;
			} catch (IOException z5fOV2a2) {
				logger.error("Couldn't read " + XrAEkMaV.getLink().getURI() + " - " + z5fOV2a2.getMessage());
				return;
			}
			if ((ImfVYVls == 0) || (ImfVYVls == 1)) {
				Adler32 MnTEWXjX = new Adler32();
				NodeList NyBrdO94 = (NodeList) XrAEkMaV.getPageData().getData();
				MnTEWXjX.update(NyBrdO94.toHtml().getBytes());
				ImfVYVls = MnTEWXjX.getValue();
			}
			try {
				VtmO5H9r = conn.createStatement();
				rWgGAFHS = VtmO5H9r
						.executeQuery("SELECT * FROM documents WHERE url='" + XrAEkMaV.getLink().getURI() + "'");
				if (rWgGAFHS.first()) {
					long YSmI2h1k = rWgGAFHS.getLong("checksum");
					if (ImfVYVls == YSmI2h1k) {
						VtmO5H9r.executeUpdate("UPDATE documents SET checked="
								+ String.valueOf(System.currentTimeMillis()) + " WHERE id=" + rWgGAFHS.getString("id"));
					} else {
						VtmO5H9r.executeUpdate("UPDATE documents SET checksum=" + ImfVYVls + ", checked="
								+ String.valueOf(System.currentTimeMillis()) + " WHERE id=" + rWgGAFHS.getString("id"));
					}
				} else {
					VtmO5H9r.executeUpdate("INSERT INTO documents VALUES " + "(DEFAULT, '" + XrAEkMaV.getLink().getURI()
							+ "', " + ImfVYVls + ", '" + providerId + "', " + String.valueOf(System.currentTimeMillis())
							+ ")");
				}
			} catch (SQLException sAFTVMfb) {
				logger.error("Could't perform database query or update - " + sAFTVMfb.getMessage());
			} finally {
				if (rWgGAFHS != null) {
					try {
						rWgGAFHS.close();
					} catch (SQLException nqJJJGkP) {
					}
					rWgGAFHS = null;
				}
				if (VtmO5H9r != null) {
					try {
						VtmO5H9r.close();
					} catch (SQLException HTVixSN8) {
					}
					VtmO5H9r = null;
				}
			}
		}
	}

}