class n6693221 {
	public void dumpDB(String Kycp1E31, String OgVDK9au) {
		try {
			FileChannel RBJiS9av = new FileInputStream(Kycp1E31).getChannel();
			FileChannel uo4JLbcw = new FileOutputStream(OgVDK9au).getChannel();
			RBJiS9av.transferTo(0, RBJiS9av.size(), uo4JLbcw);
			RBJiS9av.close();
			uo4JLbcw.close();
		} catch (Exception ILBdCpZd) {
			Log.d("exception", ILBdCpZd.toString());
		}
	}

}