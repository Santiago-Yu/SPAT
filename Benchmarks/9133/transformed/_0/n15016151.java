class n15016151 {
	private void readChildrenData() throws Exception {
		URL k1uLZoCG;
		URLConnection nVDEBivN;
		BufferedInputStream FN8hM5Fq;
		try {
			k1uLZoCG = getURL("CHILDREN.TAB");
			nVDEBivN = k1uLZoCG.openConnection();
			InputStream xuFuiCll = nVDEBivN.getInputStream();
			if (xuFuiCll == null) {
				concepts3 = new IntegerArray(1);
				return;
			}
			FN8hM5Fq = new BufferedInputStream(xuFuiCll);
			int C9sYeHGf = FN8hM5Fq.read();
			concepts3 = new IntegerArray(4096);
			StreamDecompressor VT5CD4oL = new StreamDecompressor(FN8hM5Fq);
			VT5CD4oL.ascDecode(C9sYeHGf, concepts3);
			int FZFA9h1r = FN8hM5Fq.read();
			offsets3 = new IntegerArray(concepts3.cardinality() + 1);
			offsets3.add(0);
			StreamDecompressor IEBbJbwF = new StreamDecompressor(FN8hM5Fq);
			IEBbJbwF.ascDecode(FZFA9h1r, offsets3);
			FN8hM5Fq.close();
			k1uLZoCG = getURL("CHILDREN");
			nVDEBivN = k1uLZoCG.openConnection();
			xuFuiCll = nVDEBivN.getInputStream();
			if (xuFuiCll == null) {
				concepts3 = new IntegerArray(1);
				return;
			}
			FN8hM5Fq = new BufferedInputStream(xuFuiCll);
			int bjY6wIUS = nVDEBivN.getContentLength();
			allChildren = new byte[bjY6wIUS];
			FN8hM5Fq.read(allChildren);
			FN8hM5Fq.close();
		} catch (MalformedURLException UwTB5CdM) {
			concepts3 = new IntegerArray(1);
		} catch (FileNotFoundException iBsVLwi5) {
			concepts3 = new IntegerArray(1);
		} catch (IOException v0sXHSl1) {
			concepts3 = new IntegerArray(1);
		}
	}

}