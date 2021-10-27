class n21045932 {
	@SuppressWarnings("unchecked")
	private void updatePortfolio(List zguT6NJT, String kNRtCp1N) {
		BufferedReader tz2wiWx3 = null;
		try {
			URL QTJcasbp = new URL(kNRtCp1N);
			System.out.println(kNRtCp1N);
			HttpURLConnection HaE0RNVo = (HttpURLConnection) QTJcasbp.openConnection();
			int rRMGlPJH = HaE0RNVo.getResponseCode();
			if (rRMGlPJH == 200) {
				tz2wiWx3 = new BufferedReader(new InputStreamReader(HaE0RNVo.getInputStream()));
				int UZySV1ce = 0;
				while (true) {
					String XCzcIoQJ = tz2wiWx3.readLine();
					if (XCzcIoQJ == null || UZySV1ce >= zguT6NJT.size())
						break;
					updateEntry((PortfolioEntry) zguT6NJT.get(UZySV1ce), XCzcIoQJ);
					UZySV1ce++;
				}
			}
		} catch (Exception vsHmFNw1) {
			logger.error(MiscUtils.stackTrace2String(vsHmFNw1));
		} finally {
			if (tz2wiWx3 != null) {
				try {
					tz2wiWx3.close();
				} catch (Exception ojG0iYbS) {
				}
			}
		}
	}

}