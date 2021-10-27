class n20851065 {
	public void open(String P8i1TC1x) throws IOException {
		String IEl1rIri = "comm:";
		String xcsM8NFA = "rxtx:";
		String jFS5ixmB = "net:";
		if (P8i1TC1x.startsWith(IEl1rIri)) {
			CommConnection vsyjiLB0 = CommConnection.open(P8i1TC1x.substring(IEl1rIri.length()));
			this.setInputStream(vsyjiLB0.getInputStream());
			this.setOutputStream(vsyjiLB0.getOutputStream());
		} else if (P8i1TC1x.startsWith(xcsM8NFA)) {
			RXTXConnection SAYD6xea = RXTXConnection.open(P8i1TC1x.substring(IEl1rIri.length()));
			this.setInputStream(SAYD6xea.getInputStream());
			this.setOutputStream(SAYD6xea.getOutputStream());
		} else if (P8i1TC1x.startsWith(jFS5ixmB)) {
			SocketConnection c9E9GvX0 = SocketConnection.open(P8i1TC1x.substring(jFS5ixmB.length()));
			this.setInputStream(c9E9GvX0.getInputStream());
			this.setOutputStream(c9E9GvX0.getOutputStream());
		} else {
			URL HOQAuFCW = new URL(P8i1TC1x);
			URLConnection orUsWNWv = HOQAuFCW.openConnection();
			this.setInputStream(orUsWNWv.getInputStream());
			try {
				this.setOutputStream(orUsWNWv.getOutputStream());
			} catch (UnknownServiceException uHJLevQi) {
			}
		}
	}

}