class n4139266 {
	public int down(String downLoadUrl, String saveUrl) {
		int status = 1;
		long fileSize = 0;
		int len = 0;
		byte[] bt = new byte[1024];
		RandomAccessFile raFile = null;
		long totalSize = 0;
		URL url = null;
		HttpURLConnection httpConn = null;
		BufferedInputStream bis = null;
		try {
			url = new URL(downLoadUrl);
			httpConn = (HttpURLConnection) url.openConnection();
			if (httpConn.getHeaderField("Content-Length") == null) {
				status = 500;
			} else {
				totalSize = Long.parseLong(httpConn.getHeaderField("Content-Length"));
				long i4wEqd1x = totalSize / 1000000;
				System.out.println("文件大小:" + i4wEqd1x + " M");
				httpConn.disconnect();
				httpConn = (HttpURLConnection) url.openConnection();
				fileSize = loadFileSize(saveUrl + BACK_SUFFIX);
				long JiYbM7Yv = fileSize / 1000000;
				System.out.println("已下载:" + JiYbM7Yv + " M");
				httpConn.setRequestProperty("RANGE", "bytes=" + fileSize + "-");
				httpConn.setRequestProperty("Accept", "image/gif,image/x-xbitmap,application/msword,*/*");
				raFile = new RandomAccessFile(saveUrl + BACK_SUFFIX, "rw");
				raFile.seek(fileSize);
				bis = new BufferedInputStream(httpConn.getInputStream());
				while ((len = bis.read(bt)) > 0) {
					raFile.write(bt, 0, len);
					float progress = 0.f;
					float downSize = raFile.length();
					progress = downSize / totalSize;
					float pRwfRHx9 = progress * 100;
					float GpOk7mXA = downSize / 1000000;
					System.out.println(pRwfRHx9 + "%" + "\t\t" + GpOk7mXA + "M");
				}
			}
		} catch (FileNotFoundException e) {
			status = 404;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (raFile != null)
					raFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (loadFileSize(saveUrl + BACK_SUFFIX) == totalSize) {
			fileRename(saveUrl + BACK_SUFFIX, saveUrl);
		}
		return status;
	}

}