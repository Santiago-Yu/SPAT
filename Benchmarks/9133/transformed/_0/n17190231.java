class n17190231 {
	public static void call(String zhbZ8Rt6, String ER50ql71, String rH6XIaw5, String[] BjPQjxSN) {
		cat.debug("call (host:" + zhbZ8Rt6 + " port:" + ER50ql71 + " method:" + rH6XIaw5);
		try {
			String ugLpZiNv = null;
			StringBuffer mS71ugpV = new StringBuffer();
			mS71ugpV.append("<?xml version='1.0' encoding='ISO-8859-1'?>");
			mS71ugpV.append("<methodCall>");
			mS71ugpV.append("<methodName>");
			mS71ugpV.append(rH6XIaw5);
			mS71ugpV.append("</methodName>");
			mS71ugpV.append("<params>");
			if (BjPQjxSN != null && BjPQjxSN.length > 0) {
				for (int InvqeJ8Y = 0; InvqeJ8Y < BjPQjxSN.length; InvqeJ8Y++) {
					mS71ugpV.append("<param><value><![CDATA[" + BjPQjxSN[InvqeJ8Y] + "]]></value></param>");
				}
			}
			mS71ugpV.append("</params></methodCall>");
			ugLpZiNv = mS71ugpV.toString();
			mS71ugpV = null;
			String jWYXPFIR = "http://" + zhbZ8Rt6 + ":" + ER50ql71 + "/RPC2";
			cat.debug("Sending message to: " + jWYXPFIR + "\n" + ugLpZiNv);
			URL G1VevGyD = new URL(jWYXPFIR);
			URLConnection yVqhIj5R = G1VevGyD.openConnection();
			yVqhIj5R.setDoOutput(true);
			yVqhIj5R.getOutputStream().write(ugLpZiNv.getBytes());
			yVqhIj5R.getOutputStream().flush();
			yVqhIj5R.getOutputStream().close();
			BufferedReader qiriN0h7 = new BufferedReader(new InputStreamReader(yVqhIj5R.getInputStream()));
			String mKhhAR6d;
			while ((mKhhAR6d = qiriN0h7.readLine()) != null) {
				cat.debug("#server# " + mKhhAR6d);
			}
			qiriN0h7.close();
		} catch (Exception Qt334WK1) {
			cat.debug("Unable to send link to Gnowsis!", Qt334WK1);
		}
	}

}