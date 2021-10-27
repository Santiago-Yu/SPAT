class n993589{
    public void testScenario() throws Exception {
        String expression = "SELECT id, name, address, phone FROM " + TABLE + " where id > 2 and id < 12 order by id";
        SQLQuery query = new SQLQuery();
        query.setResourceID(mResourceID);
        query.addExpression(expression);
        TupleToWebRowSetCharArrays tupleToWebRowSet = new TupleToWebRowSetCharArrays();
        tupleToWebRowSet.connectDataInput(query.getDataOutput());
        DeliverToFTP deliverToFTP = new DeliverToFTP();
        deliverToFTP.connectDataInput(tupleToWebRowSet.getResultOutput());
        deliverToFTP.addFilename(FILE);
        deliverToFTP.addHost(mURL);
        PipelineWorkflow pipeline = new PipelineWorkflow();
        pipeline.add(query);
        pipeline.add(tupleToWebRowSet);
        pipeline.add(deliverToFTP);
        mDRER.execute(pipeline, RequestExecutionType.SYNCHRONOUS);
        final URL url = new URL("ftp://" + mURL + "/" + FILE);
        final URLConnection connection = url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(false);
        InputStream is = connection.getInputStream();
        WebRowSetToResultSet converter = new WebRowSetToResultSet(new InputStreamReader(is));
        converter.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
        ResultSet rs = converter.getResultSet();
        JDBCTestHelper.validateResultSet(mConnection, expression, rs, 1);
        rs.close();
    }

}