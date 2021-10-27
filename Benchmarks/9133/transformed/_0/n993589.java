class n993589 {
	public void testScenario() throws Exception {
		String CI2mNY1W = "SELECT id, name, address, phone FROM " + TABLE + " where id > 2 and id < 12 order by id";
		SQLQuery nTQBP2MG = new SQLQuery();
		nTQBP2MG.setResourceID(mResourceID);
		nTQBP2MG.addExpression(CI2mNY1W);
		TupleToWebRowSetCharArrays wN0wi3eF = new TupleToWebRowSetCharArrays();
		wN0wi3eF.connectDataInput(nTQBP2MG.getDataOutput());
		DeliverToFTP Uf3CrXNC = new DeliverToFTP();
		Uf3CrXNC.connectDataInput(wN0wi3eF.getResultOutput());
		Uf3CrXNC.addFilename(FILE);
		Uf3CrXNC.addHost(mURL);
		PipelineWorkflow Xabt5tDa = new PipelineWorkflow();
		Xabt5tDa.add(nTQBP2MG);
		Xabt5tDa.add(wN0wi3eF);
		Xabt5tDa.add(Uf3CrXNC);
		mDRER.execute(Xabt5tDa, RequestExecutionType.SYNCHRONOUS);
		final URL dabGcmvC = new URL("ftp://" + mURL + "/" + FILE);
		final URLConnection FOBXvPB2 = dabGcmvC.openConnection();
		FOBXvPB2.setDoInput(true);
		FOBXvPB2.setDoOutput(false);
		InputStream l62nGdK0 = FOBXvPB2.getInputStream();
		WebRowSetToResultSet aWlR7lVI = new WebRowSetToResultSet(new InputStreamReader(l62nGdK0));
		aWlR7lVI.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
		ResultSet xFOIROYK = aWlR7lVI.getResultSet();
		JDBCTestHelper.validateResultSet(mConnection, CI2mNY1W, xFOIROYK, 1);
		xFOIROYK.close();
	}

}