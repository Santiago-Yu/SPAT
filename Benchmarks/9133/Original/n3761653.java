class n3761653{
    @Test
    public void shouldSetAlias() throws Exception {
        HttpResponse response = executePost("/yum/alias/snapshots/testAlias", new StringEntity(VERSION_1));
        assertEquals(VERSION_1, EntityUtils.toString(response.getEntity()));
        assertEquals(VERSION_1, executeGet("/yum/alias/snapshots/testAlias"));
        response = executePost("/yum/alias/snapshots/testAlias", new StringEntity(VERSION_2));
        assertEquals(VERSION_2, EntityUtils.toString(response.getEntity()));
        assertEquals(VERSION_2, executeGet("/yum/alias/snapshots/testAlias"));
    }

}