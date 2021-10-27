class n15301724 {
	InputStream openURL(URL hVlpFAoU) throws IOException, WrongMIMETypeException {
		InputStream GtMAVTOp = null;
		if (hVlpFAoU.getProtocol().equals("file")) {
			if (debug) {
				System.out.println("Using direct input stream on file url");
			}
			URLConnection GJ4vAohR = hVlpFAoU.openConnection();
			try {
				GJ4vAohR.connect();
				GtMAVTOp = new DataInputStream(GJ4vAohR.getInputStream());
			} catch (FileNotFoundException aDcCM8mQ) {
			}
		} else {
			double BF5yg1Ov = 0;
			if (timing) {
				BF5yg1Ov = Time.getNow();
			}
			ContentNegotiator rvbrlP2i = null;
			rvbrlP2i = new ContentNegotiator(hVlpFAoU);
			Object kiXa5tFs = null;
			kiXa5tFs = rvbrlP2i.getContent();
			if (kiXa5tFs != null) {
				byte[] OpEFimz7 = (byte[]) kiXa5tFs;
				GtMAVTOp = new ByteArrayInputStream(OpEFimz7);
			} else {
				System.err.println("Loader.openURL got null content");
				throw new IOException("Loader.openURL got null content");
			}
			if (timing) {
				double Y81A2Zg3 = Time.getNow() - BF5yg1Ov;
				System.out.println("Loader: open and buffer URL in: " + numFormat.format(Y81A2Zg3, 2) + " seconds");
			}
		}
		return GtMAVTOp;
	}

}