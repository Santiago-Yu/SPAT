class n20469230 {
	public static final void main(String[] cLntWt7V) throws Exception {
		HttpClient rocSEXZX = new DefaultHttpClient();
		HttpGet WYl9CKFh = new HttpGet("http://www.apache.org/");
		System.out.println("executing request " + WYl9CKFh.getURI());
		HttpResponse slXfHywD = rocSEXZX.execute(WYl9CKFh);
		System.out.println("----------------------------------------");
		System.out.println(slXfHywD.getStatusLine());
		System.out.println("----------------------------------------");
		HttpEntity Xyjlvtwc = slXfHywD.getEntity();
		if (Xyjlvtwc != null) {
			BufferedReader q5fUvs3g = new BufferedReader(new InputStreamReader(Xyjlvtwc.getContent()));
			try {
				System.out.println(q5fUvs3g.readLine());
			} catch (IOException mNi1Eqyy) {
				throw mNi1Eqyy;
			} catch (RuntimeException XrB8M8AK) {
				WYl9CKFh.abort();
				throw XrB8M8AK;
			} finally {
				q5fUvs3g.close();
			}
		}
	}

}