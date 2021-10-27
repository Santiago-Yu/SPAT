class n14800928 {
	public void doPost(HttpServletRequest oCrJaDkQ, HttpServletResponse sjvi77AN) throws ServletException, IOException {
		sjvi77AN.setContentType("text/plain;charset=UTF-8");
		oCrJaDkQ.setCharacterEncoding("utf-8");
		HttpURLConnection YuLj6B57 = null;
		byte[] bqxJJzLX = null;
		try {
			byte[] T50UfmvH = HttpUtil.getHttpURLReturnData(oCrJaDkQ);
			if (-1 == T50UfmvH.length || 23 > T50UfmvH.length)
				throw new Exception();
			MsgPrint.showMsg("========byte length" + T50UfmvH.length);
			String HLZHW9Fu = oCrJaDkQ.getParameter("userTag");
			String s6Y3eViN = oCrJaDkQ.getParameter("isEncrypt");
			URL rDzXIXMA = new URL(ProtocolContanst.TRANSFERS_URL + HLZHW9Fu + "&isEncrypt=" + s6Y3eViN);
			YuLj6B57 = (HttpURLConnection) rDzXIXMA.openConnection();
			YuLj6B57.setDoOutput(true);
			YuLj6B57.setRequestProperty("Content-Length", String.valueOf(T50UfmvH.length));
			OutputStream VO3SOQor = YuLj6B57.getOutputStream();
			VO3SOQor.write(T50UfmvH);
			VO3SOQor.close();
			InputStream dju4x9GY = YuLj6B57.getInputStream();
			if (0 >= YuLj6B57.getContentLength()) {
				throw new Exception();
			}
			byte[] tAQWQrC6 = new byte[YuLj6B57.getContentLength()];
			byte[] GYtvguci = new byte[1024];
			int shVGffIc = 0;
			int WB2FwMq9 = 0;
			while ((shVGffIc = dju4x9GY.read(GYtvguci)) != -1) {
				System.arraycopy(GYtvguci, 0, tAQWQrC6, WB2FwMq9, shVGffIc);
				WB2FwMq9 += shVGffIc;
			}
			dju4x9GY.close();
			bqxJJzLX = tAQWQrC6;
		} catch (Exception ZsfZFt93) {
		}
		ServletOutputStream ZPtlxGAs = sjvi77AN.getOutputStream();
		if (null != bqxJJzLX) {
			sjvi77AN.setContentLength(bqxJJzLX.length);
			ZPtlxGAs.write(bqxJJzLX);
		} else {
			sjvi77AN.setContentLength(26);
			ZPtlxGAs.write(new byte[] { 48, 48, 55, -23, 3, 56, 49, 54, 57, 55, 49, 51, 54, 72, 71, 52, 48, 1, 3, 3, 48,
					48, 48, 48, 48, 48 });
		}
		ZPtlxGAs.flush();
		ZPtlxGAs.close();
	}

}