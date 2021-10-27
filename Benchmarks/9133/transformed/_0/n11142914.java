class n11142914 {
	private boolean copyAvecProgressNIO(File ckzSxJk6, File lMyI9DkN, JProgressBar Cbc652Uo) throws IOException {
		boolean mDo1h93v = false;
		FileInputStream sPzpDpyS = new FileInputStream(ckzSxJk6);
		FileOutputStream oBEQtr2I = new FileOutputStream(lMyI9DkN);
		java.nio.channels.FileChannel T2xFULTa = sPzpDpyS.getChannel();
		java.nio.channels.FileChannel BeIg7a91 = oBEQtr2I.getChannel();
		Cbc652Uo.setValue(0);
		Cbc652Uo.setString(ckzSxJk6 + " : 0 %");
		T2xFULTa.transferTo(0, T2xFULTa.size(), BeIg7a91);
		Cbc652Uo.setValue(100);
		Cbc652Uo.setString(ckzSxJk6 + " : 100 %");
		if (T2xFULTa.size() == BeIg7a91.size()) {
			mDo1h93v = true;
		} else {
			mDo1h93v = false;
		}
		sPzpDpyS.close();
		oBEQtr2I.close();
		return (mDo1h93v);
	}

}