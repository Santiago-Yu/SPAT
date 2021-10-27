class n19446036 {
	protected void givenGroupRepository(String FCGkiyKL, String J99DBf39, Repository... XaYtaugT)
			throws AuthenticationException, UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpResponse EI4RRo8m = executeDeleteWithResponse(format("/repo_groups/%s", FCGkiyKL));
		consume(EI4RRo8m.getEntity());
		final StringEntity jP58aHWu = new StringEntity(
				format("{data:{id: '%s', name: '%s', provider: '%s', exposed: true, repositories: [%s]}}", FCGkiyKL,
						FCGkiyKL, J99DBf39, render(XaYtaugT)));
		EI4RRo8m = executePost("/repo_groups", jP58aHWu, new BasicHeader("Content-Type", "application/json"));
		consume(EI4RRo8m.getEntity());
		assertThat(EI4RRo8m.getStatusLine().getStatusCode(), is(201));
	}

}