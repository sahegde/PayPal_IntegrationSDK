package test.java;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import com.paypal.base.Constants;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.HttpMethod;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.sdk.info.SDKVersionImpl;
import com.paypal.base.rest.PayPalResource;


public class getStatusApi extends PayPalResource{
	
	private static final long serialVersionUID = 1L;

	public String create(APIContext apiContext) throws PayPalRESTException, MalformedURLException, UnsupportedEncodingException {
		if (apiContext == null) {
			throw new IllegalArgumentException("APIContext cannot be null");
		}
		if (apiContext.getAccessToken() == null || apiContext.getAccessToken().trim().length() <= 0) {
			throw new IllegalArgumentException("AccessToken cannot be null or empty");
		}
		if (apiContext.getHTTPHeaders() == null) {
			apiContext.setHTTPHeaders(new HashMap<String, String>());
		}
		apiContext.getHTTPHeaders().put(Constants.HTTP_CONTENT_TYPE_HEADER, Constants.HTTP_CONTENT_TYPE_JSON);
		apiContext.setSdkVersion(new SDKVersionImpl());
		String resourcePath = "v1/customer/partners/XJPHPNFGXYGG6/merchant-integrations?tracking_id=abcd124";
		String payLoad = this.toJSON();
		String statusApiResponse = configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, String.class);

		return statusApiResponse;
	}
	
	public static void main(String[] args) throws Exception{
		getStatusApi obj = new getStatusApi();
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", "live");
		String clientID = "Af1bGDNgFBtbJvzEkG25zt4SoNQQ3ustiLm84GWXxe8nq_HE_0wCQ9SH8M1ScmSBURBIzPiCjr5gu-Dq";
		String clientSecret = "EINHxUKd6GNoQl8tDd2PJrnH932nefTgm8L8QQM8SeXo2jEhsIapdt3AjlMdPz5tax9_wMjjbauvy3wY";
		String accessToken = new OAuthTokenCredential(clientID, clientSecret, map).getAccessToken();
		
		APIContext context = new APIContext(accessToken);
		context.setConfigurationMap(map);
		
		String getStatusResponse = obj.create(context);
		
		System.out.println("getStatusResponse: " + getStatusResponse);
	}
}
