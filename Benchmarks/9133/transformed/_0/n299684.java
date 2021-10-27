class n299684 {
	public static void main(String[] fkRs9RmR) throws Exception {
		String pqWwuOy0 = "http://php.tech.sina.com.cn/download/d_load.php?d_id=7877&down_id=151542";
		pqWwuOy0 = EncodeUtils.encodeURL(pqWwuOy0);
		URL U6DwKoht = new URL(pqWwuOy0);
		System.out.println("第一次：" + U6DwKoht);
		HttpURLConnection zHKz9DU6 = (HttpURLConnection) U6DwKoht.openConnection();
		HttpURLConnection.setFollowRedirects(true);
		Map xjvKg9DQ = zHKz9DU6.getRequestProperties();
		System.out.println("第一次请求头：");
		printMap(xjvKg9DQ);
		zHKz9DU6.connect();
		System.out.println("第一次响应：");
		System.out.println(zHKz9DU6.getResponseMessage());
		int dTVmSLVX = zHKz9DU6.getResponseCode();
		System.out.println("第一次code:" + dTVmSLVX);
		printMap(zHKz9DU6.getHeaderFields());
		System.out.println(zHKz9DU6.getURL().getFile());
		if (dTVmSLVX == 404 && !(zHKz9DU6.getURL() + "").equals(pqWwuOy0)) {
			System.out.println(zHKz9DU6.getURL());
			String U8um1iGE = URLEncoder.encode(zHKz9DU6.getURL().toString(), "gbk");
			System.out.println(URLEncoder.encode("在线音乐播放脚本", "GBK"));
			System.out.println(U8um1iGE);
			U6DwKoht = new URL(U8um1iGE);
			System.out.println("第二次：" + U6DwKoht);
			zHKz9DU6 = (HttpURLConnection) U6DwKoht.openConnection();
			System.out.println("第二次响应：");
			System.out.println("code:" + dTVmSLVX);
			printMap(zHKz9DU6.getHeaderFields());
		}
	}

}