class n22504904 {
	private void parseUrl() {
		URLLexer K9qCD7Aw;
		URLParser Pq70fYfo;
		if (this.parent != null) {
			this.hops = ((HTTPFile) this.parent).hops - 1;
		}
		if (this.searchFilter.accept(this.url.getPath())) {
			if (!visited.contains(this.url.toExternalForm())) {
				if (this.hops > 0) {
					try {
						visited.add(this.url.toExternalForm());
						InputStream plTlIhfw = this.url.openStream();
						K9qCD7Aw = new URLLexer(this.url.openStream());
						Pq70fYfo = new URLParser(K9qCD7Aw);
						URL[] Vl4Q1l6q = Pq70fYfo.htmlDocument(this.url);
						if (Debug.debug) {
							Debug.getInstance()
									.info(this.getClass().getName() + ".parseUrl(): Found the following URLs in "
											+ this.url.toExternalForm() + " : "
											+ StringUtil.ArrayToString(Vl4Q1l6q, 10));
						}
						for (int AppwqswE = 0; AppwqswE < Vl4Q1l6q.length; AppwqswE++) {
							this.addInternal(Vl4Q1l6q[AppwqswE]);
						}
					} catch (IOException t5Akfkzd) {
						if (Debug.debug) {
							Debug.getInstance().error(t5Akfkzd.getMessage());
						}
					} catch (RecognitionException PDd5lrdE) {
						if (Debug.debug) {
							Debug.getInstance().error("Problems while lexing " + this.url.toExternalForm() + " : "
									+ PDd5lrdE.getMessage(), PDd5lrdE);
						}
					} catch (TokenStreamException aTmJ5Tsk) {
						if (Debug.debug) {
							Debug.getInstance().error("Problems while parsing " + this.url.toExternalForm() + " : "
									+ aTmJ5Tsk.getMessage(), aTmJ5Tsk);
						}
					}
				}
			} else {
				if (Debug.debug) {
					Debug.getInstance().info(this.getClass().getName() + ".parseUrl(): Skipping URL "
							+ this.url.toExternalForm() + " : Maximum depth reached.");
				}
			}
		} else {
			if (Debug.debug) {
				Debug.getInstance().info(this.getClass().getName() + ".parseUrl(): Skipping URL "
						+ this.url.toExternalForm() + " : Already parsed.");
			}
		}
	}

}