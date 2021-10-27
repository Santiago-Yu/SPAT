class n6951110 {
	public ValidEPoint[] split(EPoint sjYfLLJo, EPoint Oi7FfWtO, long gnOgMSpm, EPoint jsGdZSPs)
			throws MalformedURLException, IOException, NoSuchAlgorithmException, InvalidEPointCertificateException,
			InvalidKeyException, SignatureException {
		URLConnection ufPJQwDo = new URL(url, "action").openConnection();
		OutputStream zbRZTt1D;
		InputStream quIFGBwK;
		ValidEPoint[] V3KUS2Vk = new ValidEPoint[2];
		ufPJQwDo.setDoOutput(true);
		ufPJQwDo.setDoInput(true);
		ufPJQwDo.setAllowUserInteraction(false);
		zbRZTt1D = ufPJQwDo.getOutputStream();
		zbRZTt1D.write(("B=" + URLEncoder.encode(sjYfLLJo.toString(), "UTF-8") + "&D=" + Base16.encode(Oi7FfWtO.getMD())
				+ "&F=" + Long.toString(gnOgMSpm) + "&C=" + Base16.encode(jsGdZSPs.getMD())).getBytes());
		zbRZTt1D.close();
		quIFGBwK = ufPJQwDo.getInputStream();
		V3KUS2Vk[1] = new ValidEPoint(this, jsGdZSPs, quIFGBwK);
		quIFGBwK.close();
		V3KUS2Vk[0] = validate(Oi7FfWtO);
		return V3KUS2Vk;
	}

}