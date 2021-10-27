class n19446036{
    protected void givenGroupRepository(String repoId, String providerId, Repository... memberRepos) throws AuthenticationException, UnsupportedEncodingException, IOException, ClientProtocolException {
        HttpResponse response = executeDeleteWithResponse(format("/repo_groups/%s", repoId));
        consume(response.getEntity());
        final StringEntity content = new StringEntity(format("{data:{id: '%s', name: '%s', provider: '%s', exposed: true, repositories: [%s]}}", repoId, repoId, providerId, render(memberRepos)));
        response = executePost("/repo_groups", content, new BasicHeader("Content-Type", "application/json"));
        consume(response.getEntity());
        assertThat(response.getStatusLine().getStatusCode(), is(201));
    }

}