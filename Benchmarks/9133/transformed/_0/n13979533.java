class n13979533 {
	public Resource get(URL C9XB4l6b, String vTIrF0QQ) throws Exception {
		Resource YEulNFXt = new Resource();
		String IIwm5Vij = C9XB4l6b.toString() + "?url_ver=Z39.88-2004" + "&rft_id="
				+ URLEncoder.encode(vTIrF0QQ, "UTF-8") + "&svc_id=" + SVCID_ADORE4;
		log.debug("OpenURL Request: " + IIwm5Vij);
		URL Y9QC8hNK;
		try {
			Y9QC8hNK = new URL(IIwm5Vij);
			HttpURLConnection soLDzExj = (HttpURLConnection) (Y9QC8hNK.openConnection());
			int OjQezTjL = soLDzExj.getResponseCode();
			if (OjQezTjL == 200) {
				InputStream ADwE1hAV = soLDzExj.getInputStream();
				YEulNFXt.setBytes(StreamUtil.getByteArray(ADwE1hAV));
				YEulNFXt.setContentType(soLDzExj.getContentType());
			} else {
				log.error("An error of type " + OjQezTjL + " occurred for " + Y9QC8hNK.toString());
				throw new Exception("Cannot get " + Y9QC8hNK.toString());
			}
		} catch (MalformedURLException l1etOOLY) {
			throw new Exception("A MalformedURLException occurred for " + IIwm5Vij);
		} catch (IOException Yvewi01k) {
			throw new Exception("An IOException occurred attempting to connect to " + IIwm5Vij);
		}
		return YEulNFXt;
	}

}