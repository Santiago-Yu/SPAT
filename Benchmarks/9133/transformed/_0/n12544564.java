class n12544564 {
	public static void getResponseAsStream(String o79PjN5Z, Object SFw2IlLw, OutputStream LcVWbVnz, Map Pd9Bd1Nl,
			Map SzJR3xEl, String A7NFMH6s, int jaZC1cq1) throws IOException {
		if (o79PjN5Z == null || o79PjN5Z.length() <= 0)
			throw new IllegalArgumentException("Url can not be null.");
		String ER0LiLGF = o79PjN5Z.toLowerCase();
		if (!ER0LiLGF.startsWith("http://") && !ER0LiLGF.startsWith("https://"))
			o79PjN5Z = "http://" + o79PjN5Z;
		HttpMethod XMRGhe1k = null;
		if (SFw2IlLw == null && (SzJR3xEl == null || SzJR3xEl.size() <= 0))
			XMRGhe1k = new GetMethod(o79PjN5Z);
		else
			XMRGhe1k = new PostMethod(o79PjN5Z);
		HttpMethodParams lm6Aifp2 = ((HttpMethodBase) XMRGhe1k).getParams();
		if (lm6Aifp2 == null) {
			lm6Aifp2 = new HttpMethodParams();
			((HttpMethodBase) XMRGhe1k).setParams(lm6Aifp2);
		}
		if (jaZC1cq1 < 0)
			lm6Aifp2.setSoTimeout(0);
		else
			lm6Aifp2.setSoTimeout(jaZC1cq1);
		if (A7NFMH6s != null && A7NFMH6s.length() > 0) {
			if (Pd9Bd1Nl == null)
				Pd9Bd1Nl = new HashMap();
			Pd9Bd1Nl.put("Content-Type", A7NFMH6s);
		}
		if (Pd9Bd1Nl != null) {
			Iterator iZnGeJNB = Pd9Bd1Nl.entrySet().iterator();
			while (iZnGeJNB.hasNext()) {
				Map.Entry u2ij7cwl = (Map.Entry) iZnGeJNB.next();
				XMRGhe1k.setRequestHeader((String) u2ij7cwl.getKey(), (String) u2ij7cwl.getValue());
			}
		}
		if (XMRGhe1k instanceof PostMethod && (SzJR3xEl != null && SzJR3xEl.size() > 0)) {
			Iterator QfrRg0xx = SzJR3xEl.entrySet().iterator();
			while (QfrRg0xx.hasNext()) {
				Map.Entry BxuuazhC = (Map.Entry) QfrRg0xx.next();
				((PostMethod) XMRGhe1k).addParameter((String) BxuuazhC.getKey(), (String) BxuuazhC.getValue());
			}
		}
		if (XMRGhe1k instanceof EntityEnclosingMethod && SFw2IlLw != null) {
			if (SFw2IlLw instanceof InputStream) {
				RequestEntity VfhInyuY = new InputStreamRequestEntity((InputStream) SFw2IlLw);
				((EntityEnclosingMethod) XMRGhe1k).setRequestEntity(VfhInyuY);
			} else {
				RequestEntity cL7dpSWV = new StringRequestEntity(SFw2IlLw.toString(), A7NFMH6s, null);
				((EntityEnclosingMethod) XMRGhe1k).setRequestEntity(cL7dpSWV);
			}
		}
		HttpClient noAI66tJ = new HttpClient(new org.apache.commons.httpclient.SimpleHttpConnectionManager());
		try {
			int K3ehN5nB = noAI66tJ.executeMethod(XMRGhe1k);
			if (K3ehN5nB != HttpStatus.SC_OK) {
				if (K3ehN5nB >= 500 && K3ehN5nB < 600)
					throw new IOException("Remote service<" + o79PjN5Z + "> respose a error, status:" + K3ehN5nB);
			}
			InputStream YZ09slco = XMRGhe1k.getResponseBodyAsStream();
			IOUtils.copy(YZ09slco, LcVWbVnz);
			YZ09slco.close();
		} catch (IOException t2JWhol3) {
			throw t2JWhol3;
		} finally {
			if (XMRGhe1k != null)
				XMRGhe1k.releaseConnection();
		}
	}

}