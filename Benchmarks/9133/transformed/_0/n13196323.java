class n13196323 {
	public void sendMessage(Message ZT3PCr8y) {
		if (!blackList.contains(ZT3PCr8y.getTo())) {
			Hashtable<String, String> YHFp2aEz = ZT3PCr8y.getContent();
			Enumeration<String> nlBWuwlz = YHFp2aEz.keys();
			String vihM3baD;
			String SGDB16tN = "to=" + ZT3PCr8y.getTo() + "&from=" + ZT3PCr8y.getFrom() + "&";
			while (nlBWuwlz.hasMoreElements()) {
				vihM3baD = (String) nlBWuwlz.nextElement();
				SGDB16tN += vihM3baD + "=" + YHFp2aEz.get(vihM3baD) + "&";
			}
			URL kDLbDIB9 = null;
			try {
				logger.log(this, Level.FINER, "sending " + SGDB16tN + " to " + ZT3PCr8y.getTo());
				kDLbDIB9 = new URL("http://" + ZT3PCr8y.getTo() + ":8080/webmsgservice?" + SGDB16tN);
				BufferedReader c7yde4D3 = new BufferedReader(new InputStreamReader(kDLbDIB9.openStream()));
				c7yde4D3.readLine();
				c7yde4D3.close();
				logger.log(this, Level.FINER, "message sent to " + ZT3PCr8y.getTo());
			} catch (MalformedURLException FkuOQXJd) {
				blackList.add(ZT3PCr8y.getTo());
				logger.log(this, Level.WARNING, "an error occured during message sending (" + ZT3PCr8y.getTo() + ") : "
						+ FkuOQXJd.getMessage());
				FkuOQXJd.printStackTrace();
			} catch (IOException nnOqaGAY) {
				logger.log(this, Level.WARNING, "an error occured during message sending (" + ZT3PCr8y.getTo() + ") : "
						+ nnOqaGAY.getMessage());
				blackList.add(ZT3PCr8y.getTo());
			}
		} else {
			logger.log(this, Level.FINE, "will not send message to " + ZT3PCr8y.getTo() + " because black listed IP");
		}
	}

}