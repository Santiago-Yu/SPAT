class n20920051 {
	public static void copyTo(File eakqEccP, File yFd6ZbfQ) {
		if (eakqEccP.isHidden())
			;
		else if (eakqEccP.isDirectory()) {
			File AhUlGcCp = new File(yFd6ZbfQ.getPath() + "/" + eakqEccP.getName());
			AhUlGcCp.mkdir();
			for (File H3pDvpqi : eakqEccP.listFiles())
				copyTo(H3pDvpqi, AhUlGcCp);
		} else {
			try {
				File mK3twFj9 = new File(yFd6ZbfQ.getPath() + "/" + eakqEccP.getName());
				mK3twFj9.createNewFile();
				FileChannel wLJaa6BO = new FileInputStream(eakqEccP).getChannel();
				FileChannel FbL7qIoZ = new FileOutputStream(mK3twFj9).getChannel();
				wLJaa6BO.transferTo(0, wLJaa6BO.size(), FbL7qIoZ);
				wLJaa6BO.close();
				FbL7qIoZ.close();
			} catch (IOException W05X0g04) {
				Logger.getLogger(EditorUtil.class.getName()).log(Level.SEVERE, null, W05X0g04);
			}
		}
	}

}