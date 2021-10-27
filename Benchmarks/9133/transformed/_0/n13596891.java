class n13596891 {
	protected void doTransfer(HttpServletRequest zShy7deZ, HttpServletResponse DrEUwRbS, String MrAJgKqI)
			throws ServletException, IOException {
		ServletContext NYIhiLL4 = this.getServletConfig().getServletContext();
		WebApplicationContext HdWZXlYU = WebApplicationContextUtils.getRequiredWebApplicationContext(NYIhiLL4);
		String ndR2U40G = zShy7deZ.getParameter("url");
		System.out.println(ndR2U40G);
		URL z0Sphs5y;
		InputStream sAzIEnqK = null;
		ServletOutputStream iqdAIRid = null;
		try {
			z0Sphs5y = new URL(ndR2U40G);
			HttpURLConnection Y6t8oo5e = (HttpURLConnection) z0Sphs5y.openConnection();
			Enumeration lZUjYI7z = zShy7deZ.getHeaderNames();
			while (lZUjYI7z.hasMoreElements()) {
				String loeWJN4E = lZUjYI7z.nextElement().toString();
				Y6t8oo5e.setRequestProperty(loeWJN4E, zShy7deZ.getHeader(loeWJN4E));
			}
			Y6t8oo5e.setRequestProperty("host", z0Sphs5y.getHost());
			Y6t8oo5e.setRequestProperty("refer", ndR2U40G);
			Y6t8oo5e.setRequestMethod(MrAJgKqI);
			Y6t8oo5e.setDoOutput(true);
			Y6t8oo5e.setDoInput(true);
			InputStreamReader ZdaqhxKx = new InputStreamReader(zShy7deZ.getInputStream());
			char oc9uJ6nU[] = new char[1024];
			int b8MUzsP6;
			OutputStreamWriter lwqUsk7q = new OutputStreamWriter(Y6t8oo5e.getOutputStream());
			while ((b8MUzsP6 = ZdaqhxKx.read(oc9uJ6nU)) != -1) {
				System.out.println(oc9uJ6nU);
				lwqUsk7q.write(oc9uJ6nU, 0, b8MUzsP6);
			}
			lwqUsk7q.flush();
			lwqUsk7q.close();
			ZdaqhxKx.close();
			System.out.println(Y6t8oo5e.getResponseCode());
			System.out.println(Y6t8oo5e.getResponseMessage());
			if (Y6t8oo5e.getResponseCode() == Y6t8oo5e.HTTP_OK) {
				DrEUwRbS.setContentType(Y6t8oo5e.getContentType());
				DrEUwRbS.addHeader("Content-Encoding", Y6t8oo5e.getContentEncoding());
				iqdAIRid = DrEUwRbS.getOutputStream();
				sAzIEnqK = Y6t8oo5e.getInputStream();
				byte eTQRYAi5[] = new byte[1024];
				while ((b8MUzsP6 = sAzIEnqK.read(eTQRYAi5)) != -1) {
					iqdAIRid.write(eTQRYAi5, 0, b8MUzsP6);
					System.out.print(eTQRYAi5);
				}
				iqdAIRid.flush();
				sAzIEnqK.close();
				iqdAIRid.close();
			} else {
				DrEUwRbS.sendError(Y6t8oo5e.getResponseCode(), Y6t8oo5e.getResponseMessage());
			}
		} catch (MalformedURLException nJrHtjM6) {
			nJrHtjM6.printStackTrace();
		} catch (IOException VHAxZw38) {
			VHAxZw38.printStackTrace();
		}
	}

}