class n12528438 {
	@Override
	public void handle(String laWbX69J, HttpServletRequest S0PDh9dY, HttpServletResponse EEUlwKO3, int MFvEcYRK)
			throws IOException, ServletException {
		System.out.println("uri: " + S0PDh9dY.getRequestURI());
		System.out.println("queryString: " + S0PDh9dY.getQueryString());
		System.out.println("method: " + S0PDh9dY.getMethod());
		ByteArrayOutputStream ynKiMAER = new ByteArrayOutputStream();
		IOUtils.copy(S0PDh9dY.getInputStream(), ynKiMAER);
		System.out.println("body: " + ynKiMAER.toString());
		PrintWriter EINuGq0g = EEUlwKO3.getWriter();
		EINuGq0g.append("testsvar");
		Random C4sw2Sje = new Random();
		for (int VKEmFv6J = 0; VKEmFv6J < 10; VKEmFv6J++) {
			int mqWfaPlp = C4sw2Sje.nextInt(Integer.MAX_VALUE);
			EINuGq0g.append(mqWfaPlp + "");
		}
		System.out.println();
		EINuGq0g.close();
		EEUlwKO3.setStatus(HttpServletResponse.SC_OK);
	}

}