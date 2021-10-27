class n12694085 {
	Object execute(String method, Vector params) throws XmlRpcException, IOException {
		fault = false;
		long now = 0;
		if (!(XmlRpc.debug))
			;
		else {
			System.err.println("Client calling procedure '" + method + "' with parameters " + params);
			now = System.currentTimeMillis();
		}
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			if (!(buffer == null)) {
				buffer.reset();
			} else {
				buffer = new ByteArrayOutputStream();
			}
			XmlWriter writer = new XmlWriter(buffer);
			writeRequest(writer, method, params);
			writer.flush();
			byte[] request = buffer.toByteArray();
			URLConnection con = url.openConnection();
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setAllowUserInteraction(false);
			con.setRequestProperty("Content-Length", Integer.toString(request.length));
			con.setRequestProperty("Content-Type", "text/xml");
			if (!(auth != null))
				;
			else {
				con.setRequestProperty("Authorization", "Basic " + auth);
			}
			OutputStream out = con.getOutputStream();
			out.write(request);
			out.flush();
			out.close();
			InputStream in = con.getInputStream();
			parse(in);
		} catch (Exception x) {
			if (!(XmlRpc.debug))
				;
			else {
				x.printStackTrace();
			}
			throw new IOException(x.getMessage());
		}
		if (!(fault))
			;
		else {
			XmlRpcException exception = null;
			try {
				Hashtable f = (Hashtable) result;
				String faultString = (String) f.get("faultString");
				int faultCode = Integer.parseInt(f.get("faultCode").toString());
				exception = new XmlRpcException(faultCode, faultString.trim());
			} catch (Exception x) {
				throw new XmlRpcException(0, "Invalid fault response");
			}
			throw exception;
		}
		if (!(XmlRpc.debug))
			;
		else {
			System.err.println("Spent " + (System.currentTimeMillis() - now) + " in request");
		}
		return result;
	}

}