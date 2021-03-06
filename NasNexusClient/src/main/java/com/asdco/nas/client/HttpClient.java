package com.asdco.nas.client;

import java.io.IOException;
import java.io.Serializable;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.SerializableEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClient {
	DefaultHttpClient httpClient = new DefaultHttpClient();

	public String get(String url) {
		HttpUriRequest httpRequest = new HttpGet(url);

		HttpResponse response = execute(httpRequest);
		String line = (toString(response.getEntity()));
		return line;
	}

	public String put(String url, Serializable object) {
		HttpPut httpRequest = new HttpPut(url);
		System.out.println(toString(createEntity(object)));
		httpRequest.setEntity(createEntity(object));
		HttpResponse response = execute(httpRequest);
		System.out.println(toString(response.getEntity()));
		response.getStatusLine().toString();
		return "";
	}

	private HttpEntity createEntity(Object object) {
		try {
			if (null == object) {
				return null;
			} else if (object instanceof String) {
				return new StringEntity(object.toString());
			} else if (object instanceof Serializable) {
				return new SerializableEntity((Serializable) object, false);
			} else {
				throw new UnsupportedOperationException(
						"Could not create an entity for an object of class " + object.getClass());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private HttpResponse execute(HttpUriRequest request) {
		try {
			return httpClient.execute(request);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String toString(HttpEntity entity) {
		try {
			return EntityUtils.toString(entity);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
