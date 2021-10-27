class n1026385 {
	public String transmit(String vuEX7ERH, String bPNsbYH7) throws Exception {
		if (cookie == null || "".equals(urlString)) {
			return null;
		}
		String CwUqYCTe = "";
		StringBuffer X0CjlMI8 = new StringBuffer();
		final String T8dpiXbC = String.valueOf(System.currentTimeMillis());
		URL JRavIORk = null;
		URLConnection HdHwNASe = null;
		BufferedReader m9jkuLIE = null;
		DataOutputStream MYb8xmW6 = null;
		try {
			JRavIORk = new URL(urlString);
			HdHwNASe = JRavIORk.openConnection();
			((HttpURLConnection) HdHwNASe).setRequestMethod("POST");
			HdHwNASe.setDoInput(true);
			HdHwNASe.setDoOutput(true);
			HdHwNASe.setAllowUserInteraction(true);
			HdHwNASe.setUseCaches(false);
			HdHwNASe.setRequestProperty(HEADER_COOKIE, cookie);
			if (vuEX7ERH != null) {
				String DZ9UVmqb = "Basic " + new sun.misc.BASE64Encoder().encode(vuEX7ERH.getBytes());
				HdHwNASe.setRequestProperty("Authorization", DZ9UVmqb);
			}
			MYb8xmW6 = new DataOutputStream(HdHwNASe.getOutputStream());
			MYb8xmW6.write((starter + T8dpiXbC + returnChar).getBytes());
			for (int borVBUE5 = 0; borVBUE5 < txtList.size(); borVBUE5++) {
				HtmlFormText NEbQ4xrc = (HtmlFormText) txtList.get(borVBUE5);
				MYb8xmW6.write(NEbQ4xrc.getTranslated());
				if (borVBUE5 + 1 < txtList.size()) {
					MYb8xmW6.write((starter + T8dpiXbC + returnChar).getBytes());
				} else if (fileList.size() > 0) {
					MYb8xmW6.write((starter + T8dpiXbC + returnChar).getBytes());
				}
			}
			for (int uYZEfjXj = 0; uYZEfjXj < fileList.size(); uYZEfjXj++) {
				HtmlFormFile yAQBrrLW = (HtmlFormFile) fileList.get(uYZEfjXj);
				MYb8xmW6.write(yAQBrrLW.getTranslated());
				if (uYZEfjXj + 1 < fileList.size()) {
					MYb8xmW6.write((starter + T8dpiXbC + returnChar).getBytes());
				}
			}
			MYb8xmW6.write((starter + T8dpiXbC + "--" + returnChar).getBytes());
			MYb8xmW6.flush();
			m9jkuLIE = new BufferedReader(new InputStreamReader(HdHwNASe.getInputStream(), "UTF-8"));
			CwUqYCTe = transactFormStr(m9jkuLIE);
			if (!"".equals(bPNsbYH7) && !"null".equals(bPNsbYH7)) {
				RandomAccessFile n0rudsfS = new RandomAccessFile(bPNsbYH7, "rw");
				n0rudsfS.seek(n0rudsfS.length());
				n0rudsfS.writeBytes(CwUqYCTe + "\n");
				n0rudsfS.close();
			}
			txtList.clear();
			fileList.clear();
		} catch (Exception iCdgKbXv) {
			log.error(iCdgKbXv, iCdgKbXv);
		} finally {
			try {
				MYb8xmW6.close();
			} catch (Exception HWx5XCD3) {
			}
			try {
				m9jkuLIE.close();
			} catch (Exception c2tDxd3Y) {
			}
		}
		return CwUqYCTe;
	}

}