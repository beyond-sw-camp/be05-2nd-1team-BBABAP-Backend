package com.encore.bbabap.service.chargerinfo;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bbabap")
public class ChargerInfoService {

    static final String baseURL = "http://infuser.odcloud.kr/oas/docs?namespace=15119741/v1" ; //API의 스펙을 설명하는 문서를 위한 URL
    static final String realDataURL = "https://api.odcloud.kr/api/15119741/v1/uddi:fe904caf-636f-4a49-aa94-e9064a446b3e"; //실제 API데이터를 가져오는 URL
    static final String myServiceKey = "By8%2BzbzlZwxRaJwkLoTWe7rgJIYf3TIkEnbrCY5mNB8f3clGoYgnY8J7f5C8bDSD1p21ek7oJoGHFbWhwRMRhw%3D%3D";//API키 >> 본인 키로 변경

    //주소만 가져오기. pathvalue를 통해 특정 지역의 충전소위치, 충전소명 가져오도록 설정.
    public String getChargerAddName(String filter) {
        System.out.println("debug >>> getChargerAddName Service activate. filter : " + filter);
        StringBuffer result = new StringBuffer();
        String jsonPrintString = null;
        try {
            String apiUrl = realDataURL + "?serviceKey=" + myServiceKey + "&page=1&perPage=5000";
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
            String returnLine;
            while ((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }
            bufferedReader.close();
            JSONObject jsonObject = new JSONObject(result.toString());
            JSONArray dataArray = jsonObject.getJSONArray("data");
            JSONArray newDataArray = new JSONArray();
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject dataObject = dataArray.getJSONObject(i);
                String address = dataObject.getString("주소");
                String name = dataObject.getString("충전소명");
                // 포함하는지 판단할 문자를 pathvalue로 입력받아 검사합니다.
                if (address.contains(filter)) {
                    JSONObject newDataObject = new JSONObject();
                    newDataObject.put("주소", address);
                    newDataObject.put("충전소명", name);
                    newDataArray.put(newDataObject);
                }
            }
            JSONObject newJsonObject = new JSONObject();
            newJsonObject.put("data", newDataArray);
            jsonPrintString = newJsonObject.toString(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPrintString;
    }


}
