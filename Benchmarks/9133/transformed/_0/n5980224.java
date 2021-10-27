class n5980224 {
	public static final TreeSet<String> getValues(String gdl0hbku, String ueLLh61l, String OcqJRtb9) {
		TreeSet<String> CjTAfpsp = new TreeSet<String>();
		String[] sHDyPAvP = ueLLh61l.split("/");
		String aVPXwxoe = null;
		String zBFxJVCd = null;
		try {
			aVPXwxoe = URLEncoder.encode(ueLLh61l, "UTF-8");
			zBFxJVCd = URLEncoder.encode(OcqJRtb9, "UTF-8");
		} catch (UnsupportedEncodingException OdKppsA7) {
			log.error("UnsupportedEncodingException resulted attempting to encode " + ueLLh61l);
		}
		String nvv52CEj = gdl0hbku + "/" + sHDyPAvP[2] + "/openurl-aDORe7" + "?rft_id=" + aVPXwxoe + "&svc_id="
				+ zBFxJVCd + "&url_ver=Z39.88-2004";
		log.info("Obtaining Content Values from: " + nvv52CEj);
		try {
			URL zAPinahK = new URL(nvv52CEj);
			long Z3zT3iUZ = System.currentTimeMillis();
			URLConnection uXe7ycZ3 = zAPinahK.openConnection();
			int SSfJ9Y62 = 1000 * 60 * 30;
			uXe7ycZ3.setConnectTimeout(SSfJ9Y62);
			uXe7ycZ3.setReadTimeout(SSfJ9Y62);
			BufferedReader ZirSlMfd = new BufferedReader(new InputStreamReader(uXe7ycZ3.getInputStream()));
			log.info("Query Time: " + (System.currentTimeMillis() - Z3zT3iUZ) + "ms");
			String C59i2sOQ;
			while ((C59i2sOQ = ZirSlMfd.readLine()) != null) {
				CjTAfpsp.add(C59i2sOQ);
			}
			ZirSlMfd.close();
		} catch (Exception xjbWEQjw) {
			log.error("problem with openurl:" + nvv52CEj + xjbWEQjw.getMessage());
			throw new RuntimeException(xjbWEQjw);
		}
		return CjTAfpsp;
	}

}