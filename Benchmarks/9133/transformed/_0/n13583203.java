class n13583203 {
	public void sendMail() throws Exception {
		try {
			if (param.length > 0) {
				System.setProperty("mail.host", param[0].trim());
				URL d20hyr05 = new URL("mailto:" + param[1].trim());
				URLConnection O3U0zx1q = d20hyr05.openConnection();
				PrintWriter ibcOdrc2 = new PrintWriter(O3U0zx1q.getOutputStream(), true);
				ibcOdrc2.print("To:" + param[1].trim() + "\n");
				ibcOdrc2.print("Subject: " + param[2] + "\n");
				ibcOdrc2.print("MIME-Version: 1.0\n");
				ibcOdrc2.print("Content-Type: multipart/mixed; boundary=\"tcppop000\"\n\n");
				ibcOdrc2.print("--tcppop000\n");
				ibcOdrc2.print("Content-Type: text/plain\n");
				ibcOdrc2.print("Content-Transfer-Encoding: 7bit\n\n\n");
				ibcOdrc2.print(param[3] + "\n\n\n");
				ibcOdrc2.print("--tcppop000\n");
				String KYnherIK = param[4].trim();
				int ET2U7Vy0 = KYnherIK.lastIndexOf(File.separator);
				if (ET2U7Vy0 > 0) {
					KYnherIK = KYnherIK.substring(ET2U7Vy0 + 1, KYnherIK.length());
				}
				ibcOdrc2.print("Content-Type: text/html; name=\"" + KYnherIK + "\"\n");
				ibcOdrc2.print("Content-Transfer-Encoding: binary\n");
				ibcOdrc2.print("Content-Disposition: attachment; filename=\"" + KYnherIK + "\"\n\n");
				System.out.println("FOR ATTACHMENT Content-Transfer-Encoding: binary ");
				RandomAccessFile bOuvLtbN = new RandomAccessFile(param[4].trim(), "r");
				byte[] PSH94Iak = new byte[(int) bOuvLtbN.length()];
				bOuvLtbN.readFully(PSH94Iak);
				bOuvLtbN.close();
				String eweVMjQ3 = new String(PSH94Iak);
				ibcOdrc2.print(eweVMjQ3);
				ibcOdrc2.print("\n");
				ibcOdrc2.print("--tcppop000--");
				ibcOdrc2.close();
			} else {
			}
		} catch (MalformedURLException b00BUiXI) {
			throw b00BUiXI;
		} catch (IOException qpJMYmCc) {
			throw qpJMYmCc;
		}
	}

}