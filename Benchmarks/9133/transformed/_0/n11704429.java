class n11704429 {
	public void run() {
		RandomAccessFile eor79j3h = null;
		InputStream GhzUgVmV = null;
		try {
			HttpURLConnection SvNIslH9 = (HttpURLConnection) url.openConnection();
			SvNIslH9.setRequestProperty("Range", "bytes=" + downloaded + "-");
			SvNIslH9.connect();
			if (SvNIslH9.getResponseCode() / 100 != 2) {
				error();
			}
			int YRetNggh = SvNIslH9.getContentLength();
			if (YRetNggh < 1) {
				error();
			}
			if (size == -1) {
				size = YRetNggh;
				stateChanged();
			}
			eor79j3h = new RandomAccessFile(destination, "rw");
			eor79j3h.seek(downloaded);
			GhzUgVmV = SvNIslH9.getInputStream();
			while (status == DOWNLOADING) {
				byte KbEpBs0X[];
				if (size - downloaded > MAX_BUFFER_SIZE) {
					KbEpBs0X = new byte[MAX_BUFFER_SIZE];
				} else {
					KbEpBs0X = new byte[size - downloaded];
				}
				int zWPxpEOi = GhzUgVmV.read(KbEpBs0X);
				if (zWPxpEOi == -1)
					break;
				eor79j3h.write(KbEpBs0X, 0, zWPxpEOi);
				downloaded += zWPxpEOi;
				stateChanged();
			}
			if (status == DOWNLOADING) {
				status = COMPLETE;
				stateChanged();
			}
		} catch (Exception r50jgM6l) {
			error();
		} finally {
			if (eor79j3h != null) {
				try {
					eor79j3h.close();
				} catch (Exception r8WMjnIE) {
				}
			}
			if (GhzUgVmV != null) {
				try {
					GhzUgVmV.close();
				} catch (Exception y8zKZb1n) {
				}
			}
		}
	}

}