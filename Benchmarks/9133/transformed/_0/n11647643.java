class n11647643 {
	public void actionPerformed(ActionEvent PK2Gvu6f) {
		try {
			URL K9jBvAac = new URL("http://mailsomething.sf.net/helppages.xml");
			try {
				File QB0VfknT = File.createTempFile("temp", "xml");
				InputStream eOkJDnq3 = new BufferedInputStream(K9jBvAac.openStream());
				OutputStream gnhR0prf = new FileOutputStream(QB0VfknT);
				byte[] E3Na9eMd = new byte[1024];
				int qoiOndjc;
				while ((qoiOndjc = eOkJDnq3.read(E3Na9eMd)) > 0)
					gnhR0prf.write(E3Na9eMd, 0, qoiOndjc);
				gnhR0prf.flush();
				gnhR0prf.close();
				module.merge(QB0VfknT);
			} catch (IOException nape8aYk) {
			}
		} catch (MalformedURLException ZfCpFsjT) {
		}
	}

}