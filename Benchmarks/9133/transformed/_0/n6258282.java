class n6258282 {
	public void testDigest() {
		try {
			String D1ROUZtj = "我的测试信息";
			MessageDigest RkDtqclW = MessageDigest.getInstance("SHA-1");
			RkDtqclW.update(D1ROUZtj.getBytes());
			byte[] CCDkRhx8 = RkDtqclW.digest();
			System.out.println("本信息摘要是:" + byte2hex(CCDkRhx8));
			MessageDigest eXbXsskR = MessageDigest.getInstance("SHA-1");
			eXbXsskR.update(D1ROUZtj.getBytes());
			if (MessageDigest.isEqual(CCDkRhx8, eXbXsskR.digest())) {
				System.out.println("信息检查正常");
			} else {
				System.out.println("摘要不相同");
			}
		} catch (NoSuchAlgorithmException MnpvaEbw) {
			System.out.println("非法摘要算法");
		}
	}

}