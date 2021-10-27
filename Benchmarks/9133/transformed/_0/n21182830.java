class n21182830 {
	public void buildCache() {
		XMLCacheBuilder PT5CMGVg = CompositePageUtil.getCacheBuilder();
		String oP0HAzVE = "";
		if (PT5CMGVg.getPostFix() != null && !PT5CMGVg.getPostFix().equals("")) {
			oP0HAzVE = "." + PT5CMGVg.getPostFix();
		}
		String rFBN1puK = PT5CMGVg.getBasePath();
		List CMB0C0Ff = CompositePageUtil.getXMLActions();
		for (int v8EqqzAo = 0; v8EqqzAo < CMB0C0Ff.size(); v8EqqzAo++) {
			try {
				XMLAction ZHWeIKhd = (XMLAction) CMB0C0Ff.get(v8EqqzAo);
				if (ZHWeIKhd.getEscapeCacheBuilder() != null && ZHWeIKhd.getEscapeCacheBuilder().equals("true"))
					continue;
				String ehTHKOOt = rFBN1puK + ZHWeIKhd.getName() + oP0HAzVE;
				URL n1FQIzhs = new URL(ehTHKOOt);
				HttpURLConnection knpzLpXV = (HttpURLConnection) n1FQIzhs.openConnection();
				knpzLpXV.setDoInput(true);
				knpzLpXV.setDoOutput(true);
				knpzLpXV.setUseCaches(false);
				knpzLpXV.setRequestProperty("Content-Type", "text/html");
				DataOutputStream ALJMfmWU = new DataOutputStream(knpzLpXV.getOutputStream());
				ALJMfmWU.flush();
				ALJMfmWU.close();
				knpzLpXV.disconnect();
			} catch (MalformedURLException HbU3chCU) {
				logger.error(HbU3chCU);
				HbU3chCU.printStackTrace();
			} catch (IOException lIZep3F8) {
				logger.equals(lIZep3F8);
				lIZep3F8.printStackTrace();
			}
		}
	}

}