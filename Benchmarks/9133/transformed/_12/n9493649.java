class n9493649 {
	public boolean loadFile(String inpfile) {
		if (osmlContainer == null)
			return false;
		hApdx.clear();
		try {
			BufferedReader in = null;
			if (inpfile.indexOf("http://") >= 0) {
				URL url = null;
				url = new URL(inpfile);
				URLConnection conn = url.openConnection();
				conn.setUseCaches(false);
				InputStreamReader is = new InputStreamReader(conn.getInputStream());
				in = new BufferedReader(is);
			} else {
				in = new BufferedReader(new FileReader(inpfile));
			}
			String pline = null;
			while ((pline = in.readLine()) != null) {
				StringTokenizer tok = new StringTokenizer(pline, "\t\n\r");
				if (tok.countTokens() < 2)
					continue;
				String name = tok.nextToken(), apdx = tok.nextToken();
				String note = "";
				if (tok.countTokens() > 0)
					note = tok.nextToken();
				if (name.length() == 0 || apdx.length() == 0)
					continue;
				OmicElementContainer element = (OmicElementContainer) OmicElementContainer.createContainer();
				element.setName(name);
				element.setNote(note);
				element.addAppendix(apdx);
				String keys[] = commaPattern.split(apdx);
				for (int j = 0; j < keys.length; j++) {
					ArrayList v = (ArrayList) hApdx.get(keys[j]);
					if (v == null)
						v = new ArrayList();
					v.add(element);
					hApdx.put(keys[j], v);
				}
			}
			in.close();
		} catch (MalformedURLException mfe) {
			System.out.println("MalformedURLException");
			return false;
		} catch (IOException ioe) {
			System.out.println("IOException");
			return false;
		}
		System.out.println("appendix name list size " + hApdx.size());
		if (bElementDirected) {
			int nCount = 0;
			ArrayList<OmicElementContainer> omicElementList = osmlContainer.getAllOmicElementContainers();
			for (OmicElementContainer element : omicElementList) {
				String name = element.getName(), apdx = element.getAppendix();
				if (name.length() == 0)
					continue;
				String names[] = commaPattern.split(name), apdxs[] = commaPattern.split(apdx);
				String list[] = new String[names.length + apdxs.length];
				for (int j = 0; j < names.length; j++)
					list[j] = names[j];
				for (int j = 0; j < apdxs.length; j++)
					list[j + names.length] = apdxs[j];
				for (int j = 0; j < list.length; j++) {
					ArrayList v = (ArrayList) hApdx.get(list[j]);
					if (v == null)
						continue;
					for (int k = 0; k < v.size(); k++) {
						OmicElementContainer appendix = (OmicElementContainer) v.get(k);
						element.addAppendix(appendix.getName());
						nCount++;
					}
				}
			}
			System.out.println("match appendix element " + nCount + " items");
		}
		if (bFunctionDirected) {
			int nCount = 0;
			FunctionalClassContainer functions[] = osmlContainer.getFunctionalClassContainer("[@container=all]");
			ArrayList vFunction = new ArrayList();
			for (int i = 0; i < functions.length; i++) {
				if (!vFunction.contains(functions[i]))
					vFunction.add(functions[i]);
			}
			for (int i = 0; i < vFunction.size(); i++) {
				FunctionalClassContainer function = (FunctionalClassContainer) vFunction.get(i);
				String name = function.getName();
				if (name.length() == 0)
					continue;
				String names[] = name.split(",");
				for (int j = 0; j < names.length; j++) {
					ArrayList v = (ArrayList) hApdx.get(names[j]);
					if (v == null)
						continue;
					for (int k = 0; k < v.size(); k++) {
						OmicElementContainer appendix = (OmicElementContainer) v.get(k);
						functions[i].addOmicElementContainer(appendix);
						nCount++;
					}
				}
			}
			System.out.println("match appendix function " + nCount + " items");
		}
		return true;
	}

}