class n4761833 {
	private void copyFileToDir(MyFile uHj0UKsX, MyFile smLPriXw, wlPanel pHhtrkIn) throws IOException {
		Utilities.print("started copying " + uHj0UKsX.getAbsolutePath() + "\n");
		FileOutputStream kpQx4xw5 = new FileOutputStream(new File(smLPriXw.getAbsolutePath()));
		FileChannel ITkQOieo = kpQx4xw5.getChannel();
		FileInputStream Fbcei5gf = new FileInputStream(new File(uHj0UKsX.getAbsolutePath()));
		FileChannel HVpgSYOx = Fbcei5gf.getChannel();
		Date rqlQLOqH = new Date();
		long s34owvT6 = ITkQOieo.transferFrom(HVpgSYOx, rest, HVpgSYOx.size() - rest);
		HVpgSYOx.close();
		ITkQOieo.force(false);
		ITkQOieo.close();
		Date minbzz78 = new Date();
		long gApQlqOt = minbzz78.getTime() - rqlQLOqH.getTime();
		double dWBOK9Nt = gApQlqOt / 1000.0;
		double uEgpxT6h = s34owvT6 / dWBOK9Nt;
		frame.getStatusArea().append(dWBOK9Nt + "s " + "amount: " + Utilities.humanReadable(s34owvT6) + " rate: "
				+ Utilities.humanReadable(uEgpxT6h) + "/s\n", "black");
		pHhtrkIn.updateView();
	}

}