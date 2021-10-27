class n8174539 {
	public static void invokeServlet(String gtTCce2B, String nfq5lMtp) throws Exception {
		boolean ocFarYUp = true;
		try {
			if (!"sayHi".equals(gtTCce2B)) {
				ocFarYUp = false;
			}
			URL GKmnZ3xd = new URL("http://localhost:9080/helloworld/*.do");
			HttpURLConnection mC72eEFV = (HttpURLConnection) GKmnZ3xd.openConnection();
			mC72eEFV.setRequestMethod("POST");
			mC72eEFV.setDoOutput(true);
			BufferedWriter oJAenDPi = new BufferedWriter(new OutputStreamWriter(mC72eEFV.getOutputStream()));
			oJAenDPi.write("Operation=" + gtTCce2B);
			if (!ocFarYUp) {
				oJAenDPi.write("&User=" + nfq5lMtp);
			}
			oJAenDPi.flush();
			oJAenDPi.close();
			BufferedReader mR76h8wy = new BufferedReader(new InputStreamReader(mC72eEFV.getInputStream()));
			boolean cHw4zbdB = false;
			String dsBNh7Vl;
			if (ocFarYUp) {
				while ((dsBNh7Vl = mR76h8wy.readLine()) != null) {
					if (dsBNh7Vl.contains("Bonjour")) {
						System.out.println(" sayHi server return: Bonjour");
						cHw4zbdB = true;
						break;
					}
				}
			} else {
				while ((dsBNh7Vl = mR76h8wy.readLine()) != null) {
					if (dsBNh7Vl.contains("Hello CXF")) {
						System.out.println(" greetMe server return: Hello CXF");
						cHw4zbdB = true;
						break;
					}
				}
			}
			if (!cHw4zbdB) {
				System.out.println("Can't got correct return from server.");
			}
			mR76h8wy.close();
		} catch (MalformedURLException oQ2bYDhR) {
			oQ2bYDhR.printStackTrace();
		} catch (IOException wh08HCr1) {
			wh08HCr1.printStackTrace();
		} catch (Exception LV5XHVwN) {
			LV5XHVwN.printStackTrace();
		}
	}

}