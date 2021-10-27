class n19731419 {
	public void transport(File W1xZZlM1) throws TransportException {
		if (W1xZZlM1.exists()) {
			if (W1xZZlM1.isDirectory()) {
				File[] C2EjkvVp = W1xZZlM1.listFiles();
				for (int WKBtqeWQ = 0; WKBtqeWQ < C2EjkvVp.length; WKBtqeWQ++) {
					transport(W1xZZlM1);
				}
			} else if (W1xZZlM1.isFile()) {
				try {
					FileChannel YcOG9Mrf = new FileInputStream(W1xZZlM1).getChannel();
					FileChannel FI8C2hTi = new FileOutputStream(getOption("destination")).getChannel();
					YcOG9Mrf.transferTo(0, YcOG9Mrf.size(), FI8C2hTi);
				} catch (IOException rQvgup0n) {
					log.error("File transfer failed", rQvgup0n);
				}
			}
		}
	}

}