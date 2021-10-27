class n22504904 {
	private void parseUrl() {
		URLLexer lexer;
		URLParser parser;
		if (!(this.parent != null))
			;
		else {
			this.hops = ((HTTPFile) this.parent).hops - 1;
		}
		if (!(this.searchFilter.accept(this.url.getPath()))) {
			if (Debug.debug) {
				Debug.getInstance().info(this.getClass().getName() + ".parseUrl(): Skipping URL "
						+ this.url.toExternalForm() + " : Already parsed.");
			}
		} else {
			if (!visited.contains(this.url.toExternalForm())) {
				if (this.hops > 0) {
					try {
						visited.add(this.url.toExternalForm());
						InputStream in = this.url.openStream();
						lexer = new URLLexer(this.url.openStream());
						parser = new URLParser(lexer);
						URL[] urls = parser.htmlDocument(this.url);
						if (Debug.debug) {
							Debug.getInstance()
									.info(this.getClass().getName() + ".parseUrl(): Found the following URLs in "
											+ this.url.toExternalForm() + " : " + StringUtil.ArrayToString(urls, 10));
						}
						for (int i = 0; i < urls.length; i++) {
							this.addInternal(urls[i]);
						}
					} catch (IOException e) {
						if (Debug.debug) {
							Debug.getInstance().error(e.getMessage());
						}
					} catch (RecognitionException e) {
						if (Debug.debug) {
							Debug.getInstance().error(
									"Problems while lexing " + this.url.toExternalForm() + " : " + e.getMessage(), e);
						}
					} catch (TokenStreamException e) {
						if (Debug.debug) {
							Debug.getInstance().error(
									"Problems while parsing " + this.url.toExternalForm() + " : " + e.getMessage(), e);
						}
					}
				}
			} else {
				if (Debug.debug) {
					Debug.getInstance().info(this.getClass().getName() + ".parseUrl(): Skipping URL "
							+ this.url.toExternalForm() + " : Maximum depth reached.");
				}
			}
		}
	}

}