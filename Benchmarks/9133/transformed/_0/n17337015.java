class n17337015 {
	public boolean downloadFile(String NYOP4fCx, String JpXMideK, String I1cqWdM2) {
		boolean luablq3g = false;
		checkDownLoadDirectory(I1cqWdM2);
		FTPClient lKJCHgxr = new FTPClient();
		try {
			lKJCHgxr.connect(url);
			lKJCHgxr.login(username, password);
			if (!"".equals(NYOP4fCx.trim()))
				lKJCHgxr.changeDirectory(NYOP4fCx);
			lKJCHgxr.download(JpXMideK, new File(I1cqWdM2 + "//" + JpXMideK));
			luablq3g = true;
			lKJCHgxr.disconnect(true);
		} catch (IllegalStateException V23ky0sB) {
			V23ky0sB.printStackTrace();
		} catch (IOException JtnOPGEn) {
			JtnOPGEn.printStackTrace();
		} catch (FTPIllegalReplyException Vjz2dUiC) {
			Vjz2dUiC.printStackTrace();
		} catch (FTPException j0Nf9Icx) {
			j0Nf9Icx.printStackTrace();
		} catch (FTPDataTransferException CoZfxvYC) {
			CoZfxvYC.printStackTrace();
		} catch (FTPAbortedException gZN1pHuV) {
			gZN1pHuV.printStackTrace();
		}
		return luablq3g;
	}

}