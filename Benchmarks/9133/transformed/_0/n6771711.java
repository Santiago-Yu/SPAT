class n6771711 {
	@SuppressWarnings("deprecation")
	public static final ReturnCode runCommand(IOBundle IxHOMnZA, String[] MQHUJ65J) {
		if ((MQHUJ65J.length < 3) || (MQHUJ65J.length > 4))
			return ReturnCode.makeReturnCode(ReturnCode.RET_INVALID_NUM_ARGS,
					"Invalid number of arguments: " + MQHUJ65J.length);
		if ((MQHUJ65J.length == 3) && (!MQHUJ65J[1].equals("show")))
			return ReturnCode.makeReturnCode(ReturnCode.RET_INVALID_NUM_ARGS,
					"Invalid number of arguments: " + MQHUJ65J.length);
		if ((MQHUJ65J.length == 4) && (!(MQHUJ65J[2].equals("training") || MQHUJ65J[2].equals("log")
				|| MQHUJ65J[2].equals("configuration"))))
			return ReturnCode.makeReturnCode(ReturnCode.RET_BAD_REQUEST, "Access denied to directory: " + MQHUJ65J[2]);
		if (MQHUJ65J[1].equals("open")) {
			final String FcfLDQGW = MQHUJ65J[2] + "/" + MQHUJ65J[3];
			final File yAXdAVrs = new File(FcfLDQGW);
			FileInputStream X36lcMlZ = null;
			BufferedInputStream zTO44oSa = null;
			DataInputStream ZwhAvAuB = null;
			try {
				X36lcMlZ = new FileInputStream(yAXdAVrs);
				zTO44oSa = new BufferedInputStream(X36lcMlZ);
				ZwhAvAuB = new DataInputStream(zTO44oSa);
				IxHOMnZA.println(FcfLDQGW);
				IxHOMnZA.println(yAXdAVrs.length() + " bytes");
				while (ZwhAvAuB.available() != 0) {
					IxHOMnZA.println(ZwhAvAuB.readLine());
				}
				X36lcMlZ.close();
				zTO44oSa.close();
				ZwhAvAuB.close();
			} catch (FileNotFoundException omT5fFdl) {
				omT5fFdl.printStackTrace();
				return ReturnCode.makeReturnCode(ReturnCode.RET_NOT_FOUND, "File " + FcfLDQGW + " doesn't exist");
			} catch (IOException G32Inr7H) {
				G32Inr7H.printStackTrace();
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "Error reading File " + FcfLDQGW);
			}
		} else if (MQHUJ65J[1].equals("save")) {
			final String fWvcekql = MQHUJ65J[2] + "/" + MQHUJ65J[3];
			String sc9vphR9;
			try {
				BufferedWriter BPPj8Jyt = new BufferedWriter(new FileWriter(fWvcekql));
				sc9vphR9 = IxHOMnZA.readLine();
				int cQZ0AzxU = Integer.parseInt(sc9vphR9.trim());
				while (cQZ0AzxU > 0) {
					BPPj8Jyt.write(IxHOMnZA.read());
					cQZ0AzxU = cQZ0AzxU - 1;
				}
				BPPj8Jyt.flush();
				BPPj8Jyt.close();
			} catch (IOException e52032Rh) {
				e52032Rh.printStackTrace();
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "Error writing File " + fWvcekql);
			}
		} else if (MQHUJ65J[1].equals("delete")) {
			final String NpTCjf3V = MQHUJ65J[2] + "/" + MQHUJ65J[3];
			final File XEzIYz9J = new File(NpTCjf3V);
			if (!XEzIYz9J.exists())
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "No such file or directory: " + NpTCjf3V);
			if (!XEzIYz9J.canWrite())
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "File is write-protected: " + NpTCjf3V);
			if (XEzIYz9J.isDirectory()) {
				String[] oqYiQK2J = XEzIYz9J.list();
				if (oqYiQK2J.length > 0)
					return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "Directory is not empty: " + NpTCjf3V);
			}
			if (!XEzIYz9J.delete())
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "Deletion failed: " + NpTCjf3V);
		} else if (MQHUJ65J[1].equals("show")) {
			File xHAguMya = new File(MQHUJ65J[2]);
			String[] WyMl2SlY;
			if ((!xHAguMya.isDirectory()) || (!xHAguMya.exists())) {
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "No such directory: " + xHAguMya);
			}
			int iJoaULRm = 0;
			WyMl2SlY = xHAguMya.list();
			IxHOMnZA.println("Files in directory \"" + xHAguMya + "\":");
			for (int B4B3MnyG = 0; B4B3MnyG < WyMl2SlY.length; B4B3MnyG++) {
				xHAguMya = new File(WyMl2SlY[B4B3MnyG]);
				if (!xHAguMya.isDirectory()) {
					iJoaULRm++;
					IxHOMnZA.println(" " + WyMl2SlY[B4B3MnyG]);
				}
			}
			IxHOMnZA.println("Total " + iJoaULRm + " files");
		} else
			return ReturnCode.makeReturnCode(ReturnCode.RET_BAD_REQUEST, "Unrecognized command");
		return ReturnCode.makeReturnCode(ReturnCode.RET_OK);
	}

}