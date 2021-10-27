class n15678383 {
	public void run() {
		videoId = videoId.trim();
		System.out.println("fetching video");
		String NxPXCnBi = "http://www.youtube.com/get_video_info?&video_id=" + videoId;
		try {
			URL xVvnaeBi = new URL(NxPXCnBi);
			HttpURLConnection kMJtBfIr = (HttpURLConnection) xVvnaeBi.openConnection();
			kMJtBfIr.setDoOutput(true);
			BufferedReader mB1i3uVc = new BufferedReader(new InputStreamReader(kMJtBfIr.getInputStream()));
			String xuj4pfvW = mB1i3uVc.readLine();
			int jHDSksUZ = xuj4pfvW.indexOf("&token=") + 7;
			int fcsxgGZH = xuj4pfvW.indexOf("&thumbnail_url=");
			String AM0FuSLM = xuj4pfvW.substring(jHDSksUZ, fcsxgGZH);
			String AFyfVuNG = "http://www.youtube.com/get_video?video_id=" + videoId + "&t=" + AM0FuSLM;
			xVvnaeBi = new URL(AFyfVuNG);
			kMJtBfIr = (HttpURLConnection) xVvnaeBi.openConnection();
			mB1i3uVc = new BufferedReader(new InputStreamReader(kMJtBfIr.getInputStream()));
			mB1i3uVc.readLine();
			AFyfVuNG = kMJtBfIr.getURL().toString();
			xVvnaeBi = new URL(AFyfVuNG);
			kMJtBfIr = (HttpURLConnection) xVvnaeBi.openConnection();
			InputStream RX6mx3bz;
			OutputStream pNq0G5Lr;
			URLConnection yLdze5SF;
			byte[] N0LAjWXF;
			int rkFEbFLM, QNitMQvr = 0;
			xVvnaeBi = new URL(AFyfVuNG);
			pNq0G5Lr = new BufferedOutputStream(new FileOutputStream(videoId + ".flv"));
			yLdze5SF = xVvnaeBi.openConnection();
			RX6mx3bz = yLdze5SF.getInputStream();
			N0LAjWXF = new byte[1024];
			while ((rkFEbFLM = RX6mx3bz.read(N0LAjWXF)) != -1) {
				pNq0G5Lr.write(N0LAjWXF, 0, rkFEbFLM);
				QNitMQvr += rkFEbFLM;
			}
			RX6mx3bz.close();
			pNq0G5Lr.close();
			System.out.println(videoUrl + " is ready");
		} catch (Exception ObOlBwcG) {
			System.out.println("Could not find flv-url " + videoId + "! " + ObOlBwcG.getMessage());
		} finally {
			ready = true;
		}
	}

}