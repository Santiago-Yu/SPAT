class n13999345 {
	private void writeFile(String S7EHLZpT, URL FnG4dmKI) throws IOException {
		Location u7H9bFt4 = resourcesHome.resolve(S7EHLZpT);
		InputStream OnyLhUhB = FnG4dmKI.openStream();
		OutputStream aSrOvu7l = u7H9bFt4.getOutputStream();
		try {
			byte OMogpjds[] = new byte[1024];
			int SVCqniG9;
			while (true) {
				SVCqniG9 = OnyLhUhB.read(OMogpjds);
				if (SVCqniG9 == -1)
					break;
				aSrOvu7l.write(OMogpjds, 0, SVCqniG9);
			}
		} finally {
			try {
				OnyLhUhB.close();
			} finally {
				aSrOvu7l.close();
			}
		}
	}

}