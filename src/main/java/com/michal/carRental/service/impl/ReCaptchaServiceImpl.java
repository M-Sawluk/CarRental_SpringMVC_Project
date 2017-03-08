package com.michal.carRental.service.impl;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.michal.carRental.exception.RecaptchaServiceException;
import com.michal.carRental.service.ReCaptchaService;

@Service
public class ReCaptchaServiceImpl implements ReCaptchaService {

	private RestTemplate restTemplate;

	@Autowired
	public ReCaptchaServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Value("#{reCaptcha.url}")
	private String url;

	@Value("#{reCaptcha.secret}")
	private String secret;

	@Override
	public boolean isResponseValid(String response) {

		RecaptchaResponse recaptchaResponse;

		String capcza = new StringBuilder().append(url).append("?secret=").append(secret).append("&response=")
				.append(response).toString();

		try {

			recaptchaResponse = restTemplate.getForObject(capcza, RecaptchaResponse.class);

		} catch (RestClientException e) {

			throw new RecaptchaServiceException("Recaptcha API not available due to exception", e);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		return recaptchaResponse.success;
	}

	private static class RecaptchaResponse {

		@JsonProperty("success")
		private boolean success;

		@JsonProperty("error-codes")
		private List<String> errorCodes;

		@JsonProperty("challenge_ts")
		private String challenge_ts;

		@JsonProperty("hostname")
		private String hostname;

		@Override
		public String toString() {
			return "RecaptchaResponse [success=" + success + ", errorCodes=" + errorCodes + "]";
		}

	}

}
