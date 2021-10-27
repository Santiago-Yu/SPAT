class n7468827 {
	public void run() {
		try {
			HttpURLConnection kXaqw4hf = (HttpURLConnection) url.openConnection();
			kXaqw4hf.setRequestMethod("GET");
			kXaqw4hf.setDoInput(true);
			byte[] CAeCYbbk = (username + ":" + password).getBytes();
			BASE64Encoder YHbXm4HL = new BASE64Encoder();
			kXaqw4hf.setRequestProperty("Authorization", "Basic " + YHbXm4HL.encode(CAeCYbbk));
			BufferedInputStream zpO927Am = new BufferedInputStream(kXaqw4hf.getInputStream());
			FileOutputStream OqtuWDgb = new FileOutputStream(toFile);
			BufferedOutputStream MJQuzZkn = new BufferedOutputStream(OqtuWDgb, 1024);
			byte[] rVF6GD26 = new byte[1024];
			int eIaUBYPv = 0;
			while ((eIaUBYPv = zpO927Am.read(rVF6GD26, 0, 1024)) >= 0) {
				MJQuzZkn.write(rVF6GD26, 0, eIaUBYPv);
				lastIteraction = System.currentTimeMillis();
			}
			MJQuzZkn.flush();
			MJQuzZkn.close();
			OqtuWDgb.flush();
			OqtuWDgb.close();
			zpO927Am.close();
			kXaqw4hf.disconnect();
			finish = true;
		} catch (Exception HKRKCtPU) {
			this.e = HKRKCtPU;
		}
	}

}