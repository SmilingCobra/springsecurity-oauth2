package com.oauth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oauth.utils.HttpClientUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author LiWei
 * @date 2020年5月27日
 * @package com.lw.oauth2.controller
 */
@RestController
public class TestController {
	@RequestMapping("/getCode")
	public String getCode(HttpServletRequest request,String code){
		System.out.println("传递的code是: "+code);
		
	//	curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=1JuO6V' "http://client:secret@localhost:8080/oauth/token"
		Map<String,String> params = new HashMap<String,String>();
		params.put("grant_type", "authorization_code");
		params.put("code", code);
		return HttpClientUtil.doPost("http://client:secret@localhost:8080/oauth/token", params);
	}
	
	
}
