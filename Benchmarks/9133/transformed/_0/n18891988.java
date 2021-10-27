class n18891988 {
	public static String getFile(String Q9wbvY1Q, String JCydukpw, String VvysNC8V) throws AxisFault {
		mLog.debug("Downloading WSDL file from: " + JCydukpw);
		mLog.debug("Received endpoint: " + VvysNC8V);
		String di70MnfE = null;
		try {
			String ERR9vPAX = System.getProperty("java.io.tmpdir");
			URL CjKDVeXl = new URL(JCydukpw);
			String HKjBEW49 = ERR9vPAX + File.separator + Q9wbvY1Q + ".wsdl";
			String DZEZukkO = HKjBEW49 + ".tmp";
			File O0I2EP26 = new File(HKjBEW49);
			File pxbIxZJH = new File(DZEZukkO);
			if (!O0I2EP26.exists() || O0I2EP26.length() == 0) {
				mLog.debug("Downloading the WSDL");
				O0I2EP26.createNewFile();
				InputStream InowDyJE = CjKDVeXl.openStream();
				FileOutputStream NRqss3c5 = new FileOutputStream(O0I2EP26);
				URLConnection FiiQt4zE = CjKDVeXl.openConnection();
				int NytpsksE = FiiQt4zE.getContentLength();
				ReadableByteChannel AyT4aBkw = Channels.newChannel(InowDyJE);
				FileChannel JtWuR9fO = NRqss3c5.getChannel();
				JtWuR9fO.transferFrom(AyT4aBkw, 0, NytpsksE);
				AyT4aBkw.close();
				JtWuR9fO.close();
				NRqss3c5.flush();
				NRqss3c5.close();
				InowDyJE.close();
				Document hOMNdGxA = XMLUtils.newDocument(new FileInputStream(O0I2EP26));
				NodeList ZkuPlVXB = hOMNdGxA.getElementsByTagName("wsdlsoap:address");
				for (int TpDKyDd6 = 0; TpDKyDd6 < ZkuPlVXB.getLength(); TpDKyDd6++) {
					Node IUc9DZOd = ZkuPlVXB.item(TpDKyDd6);
					if (IUc9DZOd.getNodeName().equals("wsdlsoap:address")) {
						((Element) IUc9DZOd).setAttribute("location", VvysNC8V);
					}
				}
				FileOutputStream KwNNINKN = new FileOutputStream(pxbIxZJH);
				XMLUtils.DocumentToStream(hOMNdGxA, KwNNINKN);
				KwNNINKN.flush();
				KwNNINKN.close();
				boolean WERZkpVi = O0I2EP26.delete();
				if (WERZkpVi) {
					WERZkpVi = pxbIxZJH.renameTo(new File(HKjBEW49));
				}
				mLog.debug("Return Value: " + WERZkpVi);
			} else {
				mLog.debug("The WSDL is already at the ServiceProvider");
			}
			di70MnfE = HKjBEW49;
		} catch (MalformedURLException mURWM7Iq) {
			mLog.error(
					"MalformedURLException: " + mURWM7Iq.getMessage() + ", cause: " + mURWM7Iq.getCause().getMessage());
			throw new AxisFault(mURWM7Iq.getMessage(), mURWM7Iq.getCause());
		} catch (IOException zfE3K7j0) {
			mLog.error("IOException: " + zfE3K7j0.getMessage() + ", cause: " + zfE3K7j0.getCause().getMessage());
			throw new AxisFault(zfE3K7j0.getMessage(), zfE3K7j0.getCause());
		} catch (ParserConfigurationException khbRskgG) {
			mLog.error("ParserConfigurationException: " + khbRskgG.getMessage() + ", cause: "
					+ khbRskgG.getCause().getMessage());
			throw new AxisFault(khbRskgG.getMessage(), khbRskgG.getCause());
		} catch (SAXException qAGE2G4U) {
			mLog.error("SAXException: " + qAGE2G4U.getMessage() + ", cause: " + qAGE2G4U.getCause().getMessage());
			throw new AxisFault(qAGE2G4U.getMessage(), qAGE2G4U.getCause());
		}
		return di70MnfE;
	}

}