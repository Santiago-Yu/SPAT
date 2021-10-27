class n23277837 {
	private File download(String r7LmuLOw, URL Hls0duqb) {
		int Cxv1rChD = -1;
		int uZjTyQvA = 0;
		try {
			fireDownloadStarted(r7LmuLOw);
			File OtOrdf89 = createFile(r7LmuLOw);
			BufferedOutputStream BOqPMZ06 = new BufferedOutputStream(new FileOutputStream(OtOrdf89));
			System.out.println("下载资源：" + r7LmuLOw + ", url=" + Hls0duqb);
			// BufferedInputStream bis = new
			// BufferedInputStream(url.openStream());
			InputStream wpaMz92p = Hls0duqb.openStream();
			byte[] VLjYCJiv = new byte[1024];
			int FSV8TEfn = 0;
			long VUTbGhP0 = 0;
			Cxv1rChD = wpaMz92p.available();
			while ((FSV8TEfn = wpaMz92p.read(VLjYCJiv)) != -1) {
				BOqPMZ06.write(VLjYCJiv, 0, FSV8TEfn);
				uZjTyQvA += FSV8TEfn;
				long MthEaTTh = System.currentTimeMillis();
				if (MthEaTTh - VUTbGhP0 > 500) {
					fireDownloadUpdate(r7LmuLOw, Cxv1rChD, uZjTyQvA);
					VUTbGhP0 = MthEaTTh;
				}
			}
			BOqPMZ06.close();
			System.out.println("资源下载完毕：" + r7LmuLOw);
			fireDownloadCompleted(r7LmuLOw);
			return OtOrdf89;
		} catch (IOException OlzFzAh0) {
			System.out.println("下载资源失败：" + r7LmuLOw + ", error=" + OlzFzAh0.getMessage());
			fireDownloadInterrupted(r7LmuLOw);
			if (!(OlzFzAh0 instanceof FileNotFoundException)) {
				OlzFzAh0.printStackTrace();
			}
		}
		return null;
	}

}