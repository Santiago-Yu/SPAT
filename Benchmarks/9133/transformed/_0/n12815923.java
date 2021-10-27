class n12815923 {
	public static void main(String[] JYw2nBoM) {
		log.info("Passage param¨¨tres " + JYw2nBoM);
		try {
			URL ydOn1F9x = new URL("http://localhost:8082/HomeAutomateCore/ListenerServlet/");
			URLConnection zLEq596Y = ydOn1F9x.openConnection();
			zLEq596Y.setDoOutput(true);
			BufferedWriter YONadZeo = new BufferedWriter(new OutputStreamWriter(zLEq596Y.getOutputStream()));
			YONadZeo.write("username = JavaWorld \r \n ");
			YONadZeo.flush();
			YONadZeo.close();
			BufferedReader VPdAWiL0 = new BufferedReader(new InputStreamReader(zLEq596Y.getInputStream()));
			String cDgHsSou = "";
			while ((cDgHsSou = VPdAWiL0.readLine()) != null) {
				System.out.println(cDgHsSou);
			}
			System.out.println("Fin");
			VPdAWiL0.close();
		} catch (MalformedURLException bQBkvciL) {
			bQBkvciL.printStackTrace();
			System.out.println("Fin1 " + bQBkvciL.getMessage() + " " + bQBkvciL.getCause());
		} catch (IOException anxb5Vxm) {
			anxb5Vxm.printStackTrace();
			System.out.println("Fin2 " + anxb5Vxm.getMessage() + " " + anxb5Vxm.getCause());
		}
	}

}