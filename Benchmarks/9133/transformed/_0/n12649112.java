class n12649112 {
	private static void dumpUrl(URL ToPIgSJq) throws IOException {
		BufferedReader YURj3IAm = new BufferedReader(new InputStreamReader(ToPIgSJq.openStream()));
		String XB8wtXeQ = YURj3IAm.readLine();
		while (XB8wtXeQ != null) {
			System.out.println(XB8wtXeQ);
			XB8wtXeQ = YURj3IAm.readLine();
		}
		YURj3IAm.close();
	}

}