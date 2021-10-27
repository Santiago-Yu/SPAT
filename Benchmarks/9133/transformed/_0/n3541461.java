class n3541461 {
	public static String get(String Zagtudu0) {
		if (NoMuleRuntime.DEBUG)
			System.out.println("GET : " + Zagtudu0);
		try {
			URL OpPUkiA4 = new URL(Zagtudu0);
			URLConnection QI7OvhcW = OpPUkiA4.openConnection();
			BufferedReader NDV4piKk = new BufferedReader(new InputStreamReader(QI7OvhcW.getInputStream()));
			String wt4CIHfE = "";
			String YiFgUqVO = "";
			while ((wt4CIHfE = NDV4piKk.readLine()) != null) {
				YiFgUqVO += wt4CIHfE;
			}
			NoMuleRuntime.showDebug("ANSWER: " + YiFgUqVO);
			return YiFgUqVO;
		} catch (MalformedURLException CjMlRL3W) {
			CjMlRL3W.printStackTrace();
		} catch (IOException fOibXEfO) {
			fOibXEfO.printStackTrace();
		}
		return "";
	}

}