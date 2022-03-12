package com.easyhao.micro.personnel.utils.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SendSms {

    private static final String RegionId = "cn-hangzhou";
    private static final String AccessKeyID = "LTAI4G3BAgjg2az6FXq5tdPX";
    private static final String AccessKeySecret = "q0M8CkqqFaJWrEHDPFgZeKZWvVxJyF";

    public static SmsBean sendSms(String PhoneNumber, String templateParam) {
        DefaultProfile profile = DefaultProfile.getProfile(RegionId, AccessKeyID, AccessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");//云服务(不能修改)
        request.setSysVersion("2017-05-25"); //版本号(不能修改)
        request.setSysAction("SendSms");// 发送方式(不能修改)
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", PhoneNumber);
        request.putQueryParameter("SignName", "微人事");
        request.putQueryParameter("TemplateCode", "SMS_200721128");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + templateParam + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            String data = response.getData();
            return new ObjectMapper().readValue(data, SmsBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
