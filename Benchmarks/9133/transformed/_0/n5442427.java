class n5442427 {
	@Override
	public ISource writeTo(ISource BjRmjamF) throws ResourceException {
		try {
			Document giMKZ6Fa = getParent().getDocument();
			Nodes FbA5ovfa = giMKZ6Fa.query(getPosition().getXpath());
			if (FbA5ovfa.size() == 0) {
				FbA5ovfa = giMKZ6Fa.query("//html");
			}
			if (FbA5ovfa.size() > 0 && FbA5ovfa.get(0) instanceof Element) {
				Element PQJ0OXI4 = (Element) FbA5ovfa.get(0);
				List<URL> V8PJRybu = getResourceURLs();
				if (getType() == EType.TEXT) {
					Element tYnneIdA = getHeaderTag();
					ByteArrayOutputStream tWQsdrug = new ByteArrayOutputStream();
					UtilIO.writeAllTo(V8PJRybu, tWQsdrug);
					String JJqnpJOo = tWQsdrug.toString();
					tWQsdrug.close();
					tYnneIdA.appendChild(JJqnpJOo);
					if (getPosition().getPlace() == EPlace.START) {
						PQJ0OXI4.insertChild(tYnneIdA, 0);
					} else {
						PQJ0OXI4.appendChild(tYnneIdA);
					}
				} else {
					for (URL c0JpQ8k8 : V8PJRybu) {
						String aVoEVVJs = c0JpQ8k8.toString();
						String TYjEjD7l = aVoEVVJs.substring(aVoEVVJs.lastIndexOf("/") + 1) + "_res_"
								+ (serialNumber++);
						Element bSSFX2Qf = getHeaderTag(BjRmjamF, TYjEjD7l);
						File rBOuSftk = getFile(BjRmjamF, TYjEjD7l);
						if (!rBOuSftk.getParentFile().exists()) {
							if (!rBOuSftk.getParentFile().mkdirs()) {
								throw new ResourceException(
										"Could not create resource directory '" + rBOuSftk.getParent() + "'.");
							}
						}
						UtilIO.writeToClose(c0JpQ8k8.openStream(), new FileOutputStream(rBOuSftk));
						if (getPosition().getPlace() == EPlace.START) {
							PQJ0OXI4.insertChild(bSSFX2Qf, 0);
						} else {
							PQJ0OXI4.appendChild(bSSFX2Qf);
						}
					}
				}
			} else {
				throw new ResourceException("Head element not found.");
			}
		} catch (IOException E6wUKPMV) {
			throw new ResourceException(E6wUKPMV);
		} catch (SourceException dO8eiRPP) {
			throw new ResourceException(dO8eiRPP);
		}
		return BjRmjamF;
	}

}