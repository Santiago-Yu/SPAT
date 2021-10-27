class n13320273 {
	@Override
	public IMedium createMedium(String P9DgQpC5, IMetadata wrBd1iYs) throws MM4UCannotCreateMediumElementsException {
		Debug.println("createMedium(): URL: " + P9DgQpC5);
		IAudio hhoyQlwr = null;
		try {
			String giocdWvx = null;
			try {
				URL T2Hl1G6b = new URL(P9DgQpC5);
				InputStream nB07Qio4 = T2Hl1G6b.openStream();
				ByteArrayOutputStream x7ZoqPPt = new ByteArrayOutputStream();
				byte[] Hiyqib36 = new byte[1024];
				int iAPgIKRx;
				while ((iAPgIKRx = nB07Qio4.read(Hiyqib36)) > 0)
					x7ZoqPPt.write(Hiyqib36, 0, iAPgIKRx);
				MediaCache CeGaesBy = new MediaCache();
				giocdWvx = CeGaesBy.addAudio(P9DgQpC5, x7ZoqPPt).getURI().substring(5);
			} catch (MalformedURLException gQuXoTBo) {
				giocdWvx = P9DgQpC5;
			}
			TAudioFileFormat Hs1OeVB1 = null;
			try {
				Hs1OeVB1 = (TAudioFileFormat) new MpegAudioFileReader().getAudioFileFormat(new File(giocdWvx));
			} catch (Exception JDYFi6xw) {
				System.err.println("getAudioFileFormat() failed: " + JDYFi6xw);
			}
			int CxPxFuwr = Constants.UNDEFINED_INTEGER;
			if (Hs1OeVB1 != null) {
				CxPxFuwr = Math
						.round(Integer.valueOf(Hs1OeVB1.properties().get("duration").toString()).intValue() / 1000);
			}
			String Arv40bQX = Utilities.getMimetype(Utilities.getURISuffix(P9DgQpC5));
			wrBd1iYs.addIfNotNull(IMedium.MEDIUM_METADATA_MIMETYPE, Arv40bQX);
			if (CxPxFuwr != Constants.UNDEFINED_INTEGER) {
				hhoyQlwr = new Audio(this, CxPxFuwr, P9DgQpC5, wrBd1iYs);
			}
		} catch (Exception z6uxhOE5) {
			z6uxhOE5.printStackTrace();
			return null;
		}
		return hhoyQlwr;
	}

}