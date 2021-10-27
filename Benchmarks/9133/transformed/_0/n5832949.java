class n5832949 {
	private void getImage(String Mmp9hoOp)
			throws MalformedURLException, IOException, SAXException, FileNotFoundException {
		String fIa4MjAh = Constants.STRATEGICDOMINATION_URL + "/images/gameimages/" + Mmp9hoOp;
		WebRequest fdoQ6qBM = new GetMethodWebRequest(fIa4MjAh);
		WebResponse IvcbveYN = wc.getResponse(fdoQ6qBM);
		File z69KklIT = new File("etc/images/" + Mmp9hoOp);
		FileOutputStream XTHZHZEt = new FileOutputStream(z69KklIT);
		IOUtils.copy(IvcbveYN.getInputStream(), XTHZHZEt);
	}

}