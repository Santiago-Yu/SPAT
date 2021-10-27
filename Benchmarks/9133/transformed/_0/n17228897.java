class n17228897 {
	public static boolean doPost(String jV03kQt3, Map<String, String> zq5SRtGq) throws IOException {
		URL TEqaKQZv = new URL(jV03kQt3);
		URLConnection KGAdJgVm = TEqaKQZv.openConnection();
		KGAdJgVm.setDoOutput(true);
		PrintWriter tSkpzfn2 = new PrintWriter(KGAdJgVm.getOutputStream());
		boolean taALLx2m = true;
		for (Map.Entry<String, String> pair : zq5SRtGq.entrySet()) {
			if (taALLx2m)
				taALLx2m = false;
			else
				tSkpzfn2.print('&');
			String pga5ls27 = pair.getKey();
			String ifTAFxGx = pair.getValue();
			tSkpzfn2.print(pga5ls27);
			tSkpzfn2.print('=');
			tSkpzfn2.print(URLEncoder.encode(ifTAFxGx, "UTF-8"));
		}
		tSkpzfn2.close();
		Scanner KK9JbAy9;
		StringBuilder ucTXzXWR = new StringBuilder();
		try {
			KK9JbAy9 = new Scanner(KGAdJgVm.getInputStream());
		} catch (IOException UhhDFHyp) {
			if (!(KGAdJgVm instanceof HttpURLConnection))
				throw UhhDFHyp;
			InputStream GAwpfK7O = ((HttpURLConnection) KGAdJgVm).getErrorStream();
			KK9JbAy9 = new Scanner(GAwpfK7O);
		}
		while (KK9JbAy9.hasNextLine()) {
			ucTXzXWR.append(KK9JbAy9.nextLine());
			ucTXzXWR.append("\n");
		}
		KK9JbAy9.close();
		return true;
	}

}