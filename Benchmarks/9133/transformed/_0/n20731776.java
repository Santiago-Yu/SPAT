class n20731776 {
	public void readDirectoryFrom(String a79yXmfq) throws Exception {
		URL xa7LTmv2 = new URL(a79yXmfq + DIR_INFO_FIENAME);
		PushbackInputStream Uz3miJKJ = new PushbackInputStream(new BufferedInputStream(xa7LTmv2.openStream()));
		readDataFrom(Uz3miJKJ);
		TextToken jiOO1RcH = TextToken.nextToken(Uz3miJKJ);
		while (jiOO1RcH != null && jiOO1RcH.isString()) {
			DirectoryInfoModel wubJv4sd = addDirectory(new DirectoryInfo(jiOO1RcH.getString()));
			wubJv4sd.setUrl(a79yXmfq + jiOO1RcH.getString() + '/');
			jiOO1RcH = TextToken.nextToken(Uz3miJKJ);
		}
		Uz3miJKJ.close();
	}

}