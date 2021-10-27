class n13365065 {
	public Object downloadFile(File tnAPXpQb, URL[] xinrfXqX, DownloadListener EHusIxvu, Object oCxU5UPJ, long gPcPh1D3,
			PRIORITY XhX0mgr1) throws DownloadException {
		URL RlFPy37k = xinrfXqX[0];
		if (!RlFPy37k.getProtocol().equalsIgnoreCase("http")) {
			throw new DownloadException(" Only HTTP is supported in this version ");
		}
		if (!tnAPXpQb.exists()) {
			try {
				tnAPXpQb.createNewFile();
			} catch (IOException cN568Ghl) {
				cN568Ghl.printStackTrace();
				throw new DownloadException("Unable to download from URL : " + RlFPy37k.toString());
			}
		}
		HeadMethod DekvljK2 = new HeadMethod(RlFPy37k.toString());
		HttpClient AT9fqkaP = new HttpClient();
		try {
			AT9fqkaP.executeMethod(DekvljK2);
			Header[] AkksxT7y = DekvljK2.getResponseHeaders();
			for (Header kw3qcQCw : AkksxT7y) {
				System.out.println(kw3qcQCw);
			}
			Header A5vZCoMX = DekvljK2.getResponseHeader("Content-Length");
			Object kq9rFLVI = A5vZCoMX.getValue();
			Long utetnlVV = Long.parseLong(kq9rFLVI.toString());
			System.out.println(gPcPh1D3 + " : " + utetnlVV);
			GetMethod cXhKKZBF = new GetMethod(RlFPy37k.toString());
			AT9fqkaP.executeMethod(cXhKKZBF);
			InputStream to24uVH0 = cXhKKZBF.getResponseBodyAsStream();
			FileOutputStream PtZyChFN = new FileOutputStream(tnAPXpQb);
			IOUtils.copy(to24uVH0, PtZyChFN);
			System.out.println(" DOWNLOADED FILE");
		} catch (HttpException YYIOfzJs) {
			YYIOfzJs.printStackTrace();
		} catch (IOException BUlMCgbR) {
			BUlMCgbR.printStackTrace();
		}
		return null;
	}

}