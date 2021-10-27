class n13586003 {
	public ObservationResult[] call(String url, String servicename, String srsname, String version, String offering,
			String observed_property, String responseFormat) {
		System.out.println("GetObservationBasic.call url " + url);
		URLConnection connection = null;
		URL service = null;
		boolean isDataArrayRead = false;
		ArrayList<ObservationResult> obsList = new ArrayList<ObservationResult>();
		try {
			service = new URL(url);
			connection = service.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		try {
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			GetObservationDocument getobDoc = GetObservationDocument.Factory.newInstance();
			GetObservation getob = getobDoc.addNewGetObservation();
			getob.setService(servicename);
			getob.setVersion(version);
			getob.setSrsName(srsname);
			getob.setOffering(offering);
			getob.setObservedPropertyArray(new String[] { observed_property });
			getob.setResponseFormat(responseFormat);
			String request = URLEncoder.encode(getobDoc.xmlText(), "UTF-8");
			out.writeBytes(request);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			URL observation_url = new URL("file:///E:/Temp/Observation.xml");
			URLConnection urlc = observation_url.openConnection();
			urlc.connect();
			InputStream observation_url_is = urlc.getInputStream();
			ObservationCollectionDocument obsCollDoc = ObservationCollectionDocument.Factory.parse(observation_url_is);
			ObservationCollectionType obsColl = obsCollDoc.getObservationCollection();
			ObservationPropertyType[] aObsPropType = obsColl.getMemberArray();
			for (ObservationPropertyType observationPropertyType : aObsPropType) {
				ObservationType observation = observationPropertyType.getObservation();
				if (observation != null) {
					System.out.println("observation " + observation.getClass().getName());
					ObservationResult obsResult = new ObservationResult();
					if (observation instanceof GeometryObservationTypeImpl) {
						GeometryObservationTypeImpl geometryObservation = (GeometryObservationTypeImpl) observation;
						TimeObjectPropertyType samplingTime = geometryObservation.getSamplingTime();
						TimeInstantTypeImpl timeInstant = (TimeInstantTypeImpl) samplingTime.getTimeObject();
						TimePositionType timePosition = timeInstant.getTimePosition();
						StringTokenizer date_st;
						String time = (String) timePosition.getObjectValue();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String day = new StringTokenizer(time, "T").nextToken();
						String timetemp = null;
						Date d = sdf.parse(day);
						date_st = new StringTokenizer(time, "T");
						sdf = new SimpleDateFormat("HH:mm:ss");
						while (date_st.hasMoreElements())
							timetemp = date_st.nextToken();
						Date ti = sdf.parse(timetemp.substring(0, timetemp.lastIndexOf(':') + 2));
						d.setHours(ti.getHours());
						d.setMinutes(ti.getMinutes());
						d.setSeconds(ti.getSeconds());
						obsResult.setDatetime(d);
						FeaturePropertyType featureOfInterest = (FeaturePropertyType) geometryObservation
								.getFeatureOfInterest();
						String textValue = "null";
						Node fnode = featureOfInterest.getDomNode();
						NodeList childNodes = fnode.getChildNodes();
						for (int j = 0; j < childNodes.getLength(); j++) {
							Node cnode = childNodes.item(j);
							if (cnode.getNodeName().equals("n52:movingObject")) {
								NamedNodeMap att = cnode.getAttributes();
								Node id = att.getNamedItem("gml:id");
								textValue = id.getNodeValue();
								obsResult.setTextValue(textValue);
								obsResult.setIsTextValue(true);
							}
						}
						XmlObject result = geometryObservation.getResult();
						if (result instanceof GeometryPropertyTypeImpl) {
							GeometryPropertyTypeImpl geometryPropertyType = (GeometryPropertyTypeImpl) result;
							AbstractGeometryType geometry = geometryPropertyType.getGeometry();
							String srsName = geometry.getSrsName();
							String epsg = null;
							StringTokenizer st = new StringTokenizer(srsName, ":");
							while (st.hasMoreElements())
								epsg = st.nextToken();
							int sri = Integer.parseInt(epsg);
							if (geometry instanceof PointTypeImpl) {
								PointTypeImpl point = (PointTypeImpl) geometry;
								Node node = point.getDomNode();
								PointDocument pointDocument = PointDocument.Factory.parse(node);
								PointType point2 = pointDocument.getPoint();
								XmlCursor cursor = point.newCursor();
								cursor.toFirstChild();
								CoordinatesDocument coordinatesDocument = CoordinatesDocument.Factory
										.parse(cursor.xmlText());
								CoordinatesType coords = coordinatesDocument.getCoordinates();
								StringTokenizer tok = new StringTokenizer(coords.getStringValue(), " ,;", false);
								double x = Double.parseDouble(tok.nextToken());
								double z = 0;
								double y = Double.parseDouble(tok.nextToken());
								x += 207561;
								if (tok.hasMoreTokens()) {
									z = Double.parseDouble(tok.nextToken());
								}
								z += 20;
								y += 3318814;
								Point3d center = new Point3d(x, y, z);
								obsResult.setCenter(center);
								Coordinate coordinate = new Coordinate(x, y, z);
								GeometryFactory fact = new GeometryFactory();
								Geometry g1 = fact.createPoint(coordinate);
								g1.setSRID(sri);
								obsResult.setGeometry(g1);
								String href = observation.getProcedure().getHref();
								obsResult.setProcedure(href);
								obsList.add(obsResult);
							}
						}
					}
				}
			}
			observation_url_is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ObservationResult[] ar = new ObservationResult[obsList.size()];
		return obsList.toArray(ar);
	}

}