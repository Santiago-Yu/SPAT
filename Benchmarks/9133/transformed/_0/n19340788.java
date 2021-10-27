class n19340788 {
	public void setInput(String eKTwsNUK, Component GmvWQaBH, FFMpegProgressReceiver W3DvxEKp) throws IOException {
		inputMedium = null;
		if (eKTwsNUK.contains("youtube")) {
			URL EfgVKjw7 = new URL(eKTwsNUK);
			InputStreamReader K7qNDa2g = new InputStreamReader(EfgVKjw7.openStream());
			BufferedReader ttE4IYUT = new BufferedReader(K7qNDa2g);
			String YYsd2IRn;
			String ubQQRTx4 = null;
			String Um4ucZAG = eKTwsNUK.substring(eKTwsNUK.indexOf("?v=") + 3);
			if (Um4ucZAG.indexOf("&") != -1)
				Um4ucZAG = Um4ucZAG.substring(0, Um4ucZAG.indexOf("&"));
			while ((YYsd2IRn = ttE4IYUT.readLine()) != null) {
				if (YYsd2IRn.contains("\"t\": \"")) {
					ubQQRTx4 = YYsd2IRn.substring(YYsd2IRn.indexOf("\"t\": \"") + 6);
					ubQQRTx4 = ubQQRTx4.substring(0, ubQQRTx4.indexOf("\""));
					break;
				}
			}
			ttE4IYUT.close();
			if (ubQQRTx4 == null)
				throw new IOException("Could not find flv-Video");
			Downloader Gs7ZoD6s = new Downloader(
					"http://www.youtube.com/get_video?video_id=" + Um4ucZAG + "&t=" + ubQQRTx4, W3DvxEKp, lang);
			Gs7ZoD6s.start();
			return;
		}
		Runtime GammTOHW = Runtime.getRuntime();
		Process nEK1NXUC = GammTOHW.exec(new String[] { path, "-i", eKTwsNUK });
		BufferedReader UKsNjG9F = new BufferedReader(new InputStreamReader(nEK1NXUC.getErrorStream()));
		String aNk8ciEB;
		Codec xjyUMpv1 = null;
		Codec IMLOFaYY = null;
		double He0Qx5Ug = -1;
		String SMTYdRAx = null;
		String XtgJsWs6 = null;
		String yYprCRh4 = null;
		String NEZvqQxX = null;
		String QGk4pKle = null;
		String ushla8lb = null;
		String WUZXvQxc = null;
		String cIWuGQlU = null;
		try {
			while ((aNk8ciEB = UKsNjG9F.readLine()) != null) {
				if (Constants.debug)
					System.out.println(aNk8ciEB);
				if (aNk8ciEB.contains("Duration:")) {
					int E5lpSBe5 = Integer.parseInt(aNk8ciEB.substring(12, 14));
					int gJk2IKpL = Integer.parseInt(aNk8ciEB.substring(15, 17));
					double om5Q1jac = Double.parseDouble(aNk8ciEB.substring(18, aNk8ciEB.indexOf(',')));
					He0Qx5Ug = om5Q1jac + 60 * gJk2IKpL + E5lpSBe5 * 60 * 60;
					Pattern TqxUNXRu = Pattern.compile("[0-9]+ kb/s");
					Matcher aNopU7hZ = TqxUNXRu.matcher(aNk8ciEB);
					if (aNopU7hZ.find())
						QGk4pKle = aNk8ciEB.substring(aNopU7hZ.start(), aNopU7hZ.end());
				}
				if (aNk8ciEB.contains("Video:")) {
					String hK1VSRiP = aNk8ciEB.substring(24);
					String ZOtH02GH[] = hK1VSRiP.split(", ");
					Pattern RdiFMpBv = Pattern.compile("Video: [a-zA-Z0-9]+,");
					Matcher Q8BvgESQ = RdiFMpBv.matcher(aNk8ciEB);
					String gWb0ks7K = "";
					if (Q8BvgESQ.find())
						gWb0ks7K = aNk8ciEB.substring(Q8BvgESQ.start(), Q8BvgESQ.end());
					xjyUMpv1 = supportedCodecs.getCodecByName(gWb0ks7K.replace("Video: ", "").replace(",", ""));
					yYprCRh4 = ZOtH02GH[1];
					RdiFMpBv = Pattern.compile("[0-9]+x[0-9]+");
					Q8BvgESQ = RdiFMpBv.matcher(hK1VSRiP);
					if (Q8BvgESQ.find())
						XtgJsWs6 = hK1VSRiP.substring(Q8BvgESQ.start(), Q8BvgESQ.end());
					RdiFMpBv = Pattern.compile("DAR [0-9]+:[0-9]+");
					Q8BvgESQ = RdiFMpBv.matcher(hK1VSRiP);
					if (Q8BvgESQ.find())
						SMTYdRAx = hK1VSRiP.substring(Q8BvgESQ.start(), Q8BvgESQ.end()).replace("DAR ", "");
					else if (XtgJsWs6 != null)
						SMTYdRAx = String
								.valueOf((double) (Math.round(((double) ConvertUtils.getWidthFromScala(XtgJsWs6)
										/ (double) ConvertUtils.getHeightFromScala(XtgJsWs6)) * 100)) / 100);
					RdiFMpBv = Pattern.compile("[0-9]+ kb/s");
					Q8BvgESQ = RdiFMpBv.matcher(hK1VSRiP);
					if (Q8BvgESQ.find())
						NEZvqQxX = hK1VSRiP.substring(Q8BvgESQ.start(), Q8BvgESQ.end());
				} else if (aNk8ciEB.contains("Audio:")) {
					String Op6DPLnf = aNk8ciEB.substring(24);
					Pattern bKSUl3DG = Pattern.compile("Audio: [a-zA-Z0-9]+,");
					Matcher oo9mMqLS = bKSUl3DG.matcher(aNk8ciEB);
					String d57cM5Ia = "";
					if (oo9mMqLS.find())
						d57cM5Ia = aNk8ciEB.substring(oo9mMqLS.start(), oo9mMqLS.end()).replace("Audio: ", "")
								.replace(",", "");
					if (d57cM5Ia.equals("mp3"))
						d57cM5Ia = "libmp3lame";
					IMLOFaYY = supportedCodecs.getCodecByName(d57cM5Ia);
					bKSUl3DG = Pattern.compile("[0-9]+ kb/s");
					oo9mMqLS = bKSUl3DG.matcher(Op6DPLnf);
					if (oo9mMqLS.find())
						ushla8lb = Op6DPLnf.substring(oo9mMqLS.start(), oo9mMqLS.end());
					bKSUl3DG = Pattern.compile("[0-9]+ Hz");
					oo9mMqLS = bKSUl3DG.matcher(Op6DPLnf);
					if (oo9mMqLS.find())
						WUZXvQxc = Op6DPLnf.substring(oo9mMqLS.start(), oo9mMqLS.end());
					if (aNk8ciEB.contains("5.1"))
						cIWuGQlU = "5.1";
					else if (aNk8ciEB.contains("2.1"))
						cIWuGQlU = "2.1";
					else if (aNk8ciEB.contains("stereo"))
						cIWuGQlU = "Stereo";
					else if (aNk8ciEB.contains("mono"))
						cIWuGQlU = "Mono";
				}
				if (xjyUMpv1 != null && IMLOFaYY != null && He0Qx5Ug != -1) {
					if (NEZvqQxX == null && QGk4pKle != null && ushla8lb != null)
						NEZvqQxX = String.valueOf(ConvertUtils.getRateFromRateString(QGk4pKle)
								- ConvertUtils.getRateFromRateString(ushla8lb)) + " kb/s";
					inputMedium = new InputMedium(IMLOFaYY, xjyUMpv1, eKTwsNUK, He0Qx5Ug, yYprCRh4, SMTYdRAx, XtgJsWs6,
							NEZvqQxX, QGk4pKle, ushla8lb, WUZXvQxc, cIWuGQlU);
					break;
				}
			}
			if ((xjyUMpv1 != null || IMLOFaYY != null) && He0Qx5Ug != -1)
				inputMedium = new InputMedium(IMLOFaYY, xjyUMpv1, eKTwsNUK, He0Qx5Ug, yYprCRh4, SMTYdRAx, XtgJsWs6,
						NEZvqQxX, QGk4pKle, ushla8lb, WUZXvQxc, cIWuGQlU);
		} catch (Exception P6Jswrt0) {
			if (GmvWQaBH != null)
				JOptionPane.showMessageDialog(GmvWQaBH,
						lang.inputerror + " Audiocodec? " + (IMLOFaYY != null) + " Videocodec? " + (xjyUMpv1 != null),
						lang.error, JOptionPane.ERROR_MESSAGE);
			if (Constants.debug)
				System.out.println("Audiocodec: " + IMLOFaYY + "\nVideocodec: " + xjyUMpv1);
			if (Constants.debug)
				P6Jswrt0.printStackTrace();
			throw new IOException("Input file error");
		}
		if (inputMedium == null) {
			if (GmvWQaBH != null)
				JOptionPane.showMessageDialog(GmvWQaBH,
						lang.inputerror + " Audiocodec? " + (IMLOFaYY != null) + " Videocodec? " + (xjyUMpv1 != null),
						lang.error, JOptionPane.ERROR_MESSAGE);
			if (Constants.debug)
				System.out.println("Audiocodec: " + IMLOFaYY + "\nVideocodec: " + xjyUMpv1);
			throw new IOException("Input file error");
		}
	}

}