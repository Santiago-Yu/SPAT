class n8620255 {
	private void sendMessages() {
		Configuration wN2u6Reo = Configuration.getInstance();
		for (int cItN2eBJ = 0; cItN2eBJ < errors.size(); cItN2eBJ++) {
			String BaxTS22O = null;
			synchronized (this) {
				BaxTS22O = errors.get(cItN2eBJ);
				if (DEBUG)
					System.out.println(BaxTS22O);
				errors.remove(cItN2eBJ);
			}
			if (!wN2u6Reo.getCustomerFeedback())
				continue;
			if (wN2u6Reo.getApproveCustomerFeedback()) {
				ConfirmCustomerFeedback oTgHKWrm = new ConfirmCustomerFeedback(
						JOptionPane.getFrameForComponent(SqlTablet.getInstance()), BaxTS22O);
				if (oTgHKWrm.getResult() == ConfirmCustomerFeedback.Result.NO)
					continue;
			}
			try {
				URL vRddgsK5 = new URL("http://www.sqltablet.com/beta/bug.php");
				URLConnection G3VoEXC1 = vRddgsK5.openConnection();
				G3VoEXC1.setDoOutput(true);
				G3VoEXC1.setDoOutput(true);
				G3VoEXC1.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				DataOutputStream kuNvWGfQ = new DataOutputStream(G3VoEXC1.getOutputStream());
				String eszLVtbW[] = BaxTS22O.split("\n");
				for (int TuMLy6yD = 0; TuMLy6yD < eszLVtbW.length; TuMLy6yD++) {
					String KFtXF0ni = (TuMLy6yD > 0 ? "&line" : "line") + TuMLy6yD + "=";
					KFtXF0ni += URLEncoder.encode(eszLVtbW[TuMLy6yD], "UTF-8");
					kuNvWGfQ.write(KFtXF0ni.getBytes());
				}
				kuNvWGfQ.flush();
				kuNvWGfQ.close();
				BufferedReader TXEzbTPU = new BufferedReader(new InputStreamReader(G3VoEXC1.getInputStream()));
				String GaQJPxpE;
				while ((GaQJPxpE = TXEzbTPU.readLine()) != null) {
					if (DEBUG)
						System.out.println("RemoteLogger : " + GaQJPxpE + "\n");
				}
				TXEzbTPU.close();
			} catch (MalformedURLException y9LfHepk) {
				y9LfHepk.printStackTrace();
			} catch (IOException vqVZbnUP) {
				vqVZbnUP.printStackTrace();
			}
		}
	}

}