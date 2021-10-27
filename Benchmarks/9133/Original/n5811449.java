class n5811449{
    @Test
    public void shouldProgateStagingRepoToYumGroupRepo() throws Exception {
        givenGroupRepository(GROUP_REPO_ID, "maven2yum");
        givenClosedStagingRepoWithRpm(ARTIFACT_ID_1, "4.3.2");
        givenClosedStagingRepoWithRpm(ARTIFACT_ID_2, "2.3.4");
        wait(10, SECONDS);
        final HttpResponse response = executeGetWithResponse(NEXUS_BASE_URL + "/content/groups/staging-test-group/repodata/primary.xml.gz");
        final String repoContent = IOUtils.toString(new GZIPInputStream(new ByteArrayInputStream(toByteArray(response.getEntity()))));
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        assertThat(repoContent, containsString(ARTIFACT_ID_1));
        assertThat(repoContent, containsString(ARTIFACT_ID_2));
    }

}