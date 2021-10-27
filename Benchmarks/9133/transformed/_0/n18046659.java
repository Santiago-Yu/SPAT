class n18046659 {
	public String fetch(final String Phv8cX6N) throws EncoderException {
		final String IV2PMtyE = new URLCodec().encode(Phv8cX6N);
		final String u3gK4hd0 = GeoCodeFetch.urlXmlPath + "&" + "address=" + IV2PMtyE;
		this.log.debug("requestUrl: {}", u3gK4hd0);
		try {
			final StringBuffer ByNOLzMp = new StringBuffer();
			final URL aBOiqc6f = new URL(u3gK4hd0);
			final BufferedReader pJiQFlJ7 = new BufferedReader(new InputStreamReader(aBOiqc6f.openStream()));
			String vd3Vxy8M;
			while ((vd3Vxy8M = pJiQFlJ7.readLine()) != null) {
				this.log.debug("line: {}", vd3Vxy8M);
				ByNOLzMp.append(vd3Vxy8M);
			}
			pJiQFlJ7.close();
			return (ByNOLzMp.toString());
		} catch (final MalformedURLException nYDYNJKD) {
			this.log.error(ExceptionUtils.getStackTrace(nYDYNJKD));
		} catch (final IOException FltJT6bw) {
			this.log.error(ExceptionUtils.getStackTrace(FltJT6bw));
		}
		return ("");
	}

}