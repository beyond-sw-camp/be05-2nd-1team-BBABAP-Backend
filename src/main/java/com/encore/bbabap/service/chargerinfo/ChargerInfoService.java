package com.encore.bbabap.service.chargerinfo;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
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
    //이 메소드는 특정 지역의 충전소 위치와 충전소명을 가져오기 위해 filter 문자열을 매개변수로 받습니다.
    //API URL을 구성하고, GET 메소드로 HTTP 요청을 보내 응답을 받습니다. 응답은 UTF-8 인코딩으로 읽습니다.
    //응답 데이터(JSON 형태)에서 data 배열을 추출합니다. 각 항목(충전소 정보)에서 주소와 충전소명을 가져옵니다.
    //만약 주소가 입력받은 filter 문자열을 포함하고 있다면, 해당 충전소의 주소와 이름을 새로운 JSON 객체에 추가합니다.
    //이렇게 필터링된 충전소 정보만을 모아 새로운 JSON 배열(newDataArray)을 생성합니다.
    //최종적으로, 필터링된 결과를 담은 새로운 JSON 객체(newJsonObject)를 문자열로 변환하여 반환합니다.
    //이 문자열은 인덴트가 4칸인 예쁜 형식(pretty print)으로 제공됩니다.
    public String getChargerAddName(String filter) {
        System.out.println("debug >>> getChargerAddName Service activate. filter : " + filter);
        StringBuffer result = new StringBuffer();
        String jsonPrintString = null;
        try {
            String apiUrl = realDataURL + "?serviceKey=" + myServiceKey + "&page=1&perPage=5000";//URL 문자열 생성
            URL url = new URL(apiUrl);//URL문자열을 URL객체로 변환
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();//http:// 프로토콜인경우 반환된 객체를 HttpURLConnection객체로 캐스팅
            urlConnection.setRequestMethod("GET");//HTTP 메소드 GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE 중 하나인 URL 요청에 대한 메소드를 설정. 기본값은 GET.
            urlConnection.connect();//실제 연결 수행.
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());//BufferedInputStream 객체 선언
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));//연결 스트림으로부터 데이터를 읽어드린다. 이 데이터는 UTF-8 인코딩으로 변환된다.
            String returnLine;
            while ((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);//데이터가 존재하지 않을 때까지 result에 계속 append 수행.
            }//while close
            bufferedReader.close();
            JSONObject jsonObject = new JSONObject(result.toString());//받아온 JSON 문자열(result.toString())을 JSONObject로 파싱
            JSONArray dataArray = jsonObject.getJSONArray("data");//파싱된 객체에서 "data"키에 해당하는 배열을 추출.
            JSONArray newDataArray = new JSONArray();
            for (int i = 0; i < dataArray.length(); i++) {//dataArray의 각 요소(충전소 정보)를 순회하면서, 주소가 사용자가 지정한 filter를 포함하는지 확인
                JSONObject dataObject = dataArray.getJSONObject(i);
                String address = dataObject.getString("주소");
                String name = dataObject.getString("충전소명");
                // 포함하는지 판단할 문자를 pathvalue로 입력받아 검사.
                if (address.contains(filter)) {//조건에 맞는 경우, 해당 충전소의 주소와 이름을 새로운 JSONObject에 담고, 이 객체를 새로운 JSON 배열(newDataArray)에 추가
                    JSONObject newDataObject = new JSONObject();
                    newDataObject.put("주소", address);
                    newDataObject.put("충전소명", name);
                    newDataArray.put(newDataObject);
                }//if end
            }//for end
            JSONObject newJsonObject = new JSONObject();
            newJsonObject.put("data", newDataArray);//모든 필터링된 충전소 정보를 담은 newDataArray를 newJsonObject에 "data" 키로 추가
            jsonPrintString = newJsonObject.toString(4);//newJsonObject.toString(4)를 호출하여, 인덴트가 4칸인 예쁜 형식의 JSON 문자열로 변환하고, 이를 반환
        } catch (Exception e) {
            e.printStackTrace();
        }//try-catch end
        return jsonPrintString;
    }//getChargerAddName end

}