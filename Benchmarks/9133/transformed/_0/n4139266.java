class n4139266 {
	public int down(String G0rf2qXp, String FTnIbJAI) {
		int bkSxKNWj = 1;
		long qsk595kW = 0;
		int gIVcFIUG = 0;
		byte[] itHe4vTg = new byte[1024];
		RandomAccessFile dvJZphUu = null;
		long n176fprz = 0;
		URL djrljNHH = null;
		HttpURLConnection QGUw8Gin = null;
		BufferedInputStream juSF1ey4 = null;
		try {
			djrljNHH = new URL(G0rf2qXp);
			QGUw8Gin = (HttpURLConnection) djrljNHH.openConnection();
			if (QGUw8Gin.getHeaderField("Content-Length") == null) {
				bkSxKNWj = 500;
			} else {
				n176fprz = Long.parseLong(QGUw8Gin.getHeaderField("Content-Length"));
				System.out.println("文件大小:" + n176fprz / 1000000 + " M");
				QGUw8Gin.disconnect();
				QGUw8Gin = (HttpURLConnection) djrljNHH.openConnection();
				qsk595kW = loadFileSize(FTnIbJAI + BACK_SUFFIX);
				System.out.println("已下载:" + qsk595kW / 1000000 + " M");
				QGUw8Gin.setRequestProperty("RANGE", "bytes=" + qsk595kW + "-");
				QGUw8Gin.setRequestProperty("Accept", "image/gif,image/x-xbitmap,application/msword,*/*");
				dvJZphUu = new RandomAccessFile(FTnIbJAI + BACK_SUFFIX, "rw");
				dvJZphUu.seek(qsk595kW);
				juSF1ey4 = new BufferedInputStream(QGUw8Gin.getInputStream());
				while ((gIVcFIUG = juSF1ey4.read(itHe4vTg)) > 0) {
					dvJZphUu.write(itHe4vTg, 0, gIVcFIUG);
					float dSFeFPgf = 0.f;
					float imYIfqQp = dvJZphUu.length();
					dSFeFPgf = imYIfqQp / n176fprz;
					System.out.println(dSFeFPgf * 100 + "%" + "\t\t" + imYIfqQp / 1000000 + "M");
				}
			}
		} catch (FileNotFoundException e8U2MOcg) {
			bkSxKNWj = 404;
		} catch (Exception rxspuprw) {
			rxspuprw.printStackTrace();
		} finally {
			try {
				if (juSF1ey4 != null)
					juSF1ey4.close();
				if (dvJZphUu != null)
					dvJZphUu.close();
			} catch (IOException n9QTDQJ7) {
				n9QTDQJ7.printStackTrace();
			}
		}
		if (loadFileSize(FTnIbJAI + BACK_SUFFIX) == n176fprz) {
			fileRename(FTnIbJAI + BACK_SUFFIX, FTnIbJAI);
		}
		return bkSxKNWj;
	}

}