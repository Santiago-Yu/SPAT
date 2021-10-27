class n16797552 {
	public boolean restore() {
		try {
			File adWUay9R = Environment.getExternalStorageDirectory();
			File wwiyLpRh = Environment.getDataDirectory();
			if (adWUay9R.canWrite()) {
				String A7PmuZ1s = "/Android/bluebox.bak";
				String g37tsI9C = "/data/android.bluebox/databases/bluebox.db";
				File O2sNf1Qa = new File(adWUay9R, A7PmuZ1s);
				File j4UXvW0e = new File(wwiyLpRh, g37tsI9C);
				if (O2sNf1Qa.exists()) {
					FileChannel iCz34SiP = new FileInputStream(O2sNf1Qa).getChannel();
					FileChannel pj5IhOwO = new FileOutputStream(j4UXvW0e).getChannel();
					pj5IhOwO.transferFrom(iCz34SiP, 0, iCz34SiP.size());
					iCz34SiP.close();
					pj5IhOwO.close();
					return true;
				}
			}
		} catch (FileNotFoundException Lp7jAIR7) {
			Lp7jAIR7.printStackTrace();
		} catch (IOException zLOIhbOW) {
			zLOIhbOW.printStackTrace();
		}
		return false;
	}

}