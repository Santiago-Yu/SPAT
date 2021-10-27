class n4766465 {
	private void saveVideo(URL url, DownloadTask task) {
		FileOutputStream out = null;
		if (url == null) {
			return;
		}
		BufferedInputStream bis = null;
		InputStream stream = null;
		File file = new File(task.source.getPreferredVideoLocation("mp4"));
		BufferedOutputStream bos = null;
		publish("Starting download to file:" + file.getAbsolutePath());
		try {
			URLConnection uc = url.openConnection();
			out = new FileOutputStream(file);
			String contentType = uc.getContentType();
			int length = uc.getContentLength();
			StatisticsStorage.numberofdownloadedbytes += length;
			publish("Content type: " + contentType + " with a length of " + length);
			stream = uc.getInputStream();
			bos = new BufferedOutputStream(out);
			bis = new BufferedInputStream(stream);
			int i = 0;
			byte[] bytes = new byte[1024];
			int nextbyte;
			long time = System.currentTimeMillis();
			while ((nextbyte = bis.read()) != -1) {
				bos.write(nextbyte);
				i++;
				if (System.currentTimeMillis() - time >= 1000) {
					publish("downloaded " + (i++) + " bytes of " + length + " bytes.");
					int progress = (i - 1) / length;
					time = System.currentTimeMillis();
					if (progress <= 100 && progress >= 0)
						setProgress(progress);
				}
			}
			bos.write(bytes);
		} catch (IOException e) {
			System.err.println(url);
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (stream != null)
					stream.close();
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("done downloading video");
		task.source.setVideo(file.getAbsolutePath());
		if (task.source.hasLyrics()) {
			task.source.getLyrics().setTag("Video", file.getName());
		}
	}

}