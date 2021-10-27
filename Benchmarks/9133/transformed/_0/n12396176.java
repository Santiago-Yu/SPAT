class n12396176 {
	public void run() {
		RandomAccessFile V7wfeAAN = null;
		InputStream EV6PL2Ma = null;
		try {
			HttpURLConnection UNiTMRwO = (HttpURLConnection) url.openConnection();
			UNiTMRwO.setRequestProperty("Range", "bytes=" + downloaded + "-");
			UNiTMRwO.connect();
			if (UNiTMRwO.getResponseCode() / 100 != 2) {
				error();
			}
			int C22HsXze = UNiTMRwO.getContentLength();
			if (C22HsXze < 1) {
				error();
			}
			if (size == -1) {
				size = C22HsXze;
				stateChanged();
			}
			V7wfeAAN = new RandomAccessFile(saveas, "rw");
			V7wfeAAN.seek(downloaded);
			EV6PL2Ma = UNiTMRwO.getInputStream();
			while (status == DOWNLOADING) {
				byte NjReHBc2[];
				if (size - downloaded > MAX_BUFFER_SIZE) {
					NjReHBc2 = new byte[MAX_BUFFER_SIZE];
				} else {
					NjReHBc2 = new byte[size - downloaded];
				}
				int KZEk9MGb = EV6PL2Ma.read(NjReHBc2);
				if (KZEk9MGb == -1)
					break;
				V7wfeAAN.write(NjReHBc2, 0, KZEk9MGb);
				downloaded += KZEk9MGb;
				stateChanged();
			}
			if (status == DOWNLOADING) {
				status = COMPLETE;
				stateChanged();
			}
		} catch (Exception PJ243nn6) {
			PJ243nn6.printStackTrace();
			error();
		} finally {
			if (V7wfeAAN != null) {
				try {
					V7wfeAAN.close();
				} catch (Exception E8rABLdG) {
				}
			}
			if (EV6PL2Ma != null) {
				try {
					EV6PL2Ma.close();
				} catch (Exception FTbhaLyL) {
				}
			}
		}
	}

}