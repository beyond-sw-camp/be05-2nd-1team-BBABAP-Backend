package com.encore.bbabap.service.favorite;

import com.encore.bbabap.api.favorite.response.FavoriteResponseDTO;
import com.encore.bbabap.domain.favorite.FavoriteEntity;
import com.encore.bbabap.repository.favorite.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    static final String baseURL = "http://infuser.odcloud.kr/oas/docs?namespace=15119741/v1"; //API의 스펙을 설명하는 문서를 위한 URL
    static final String realDataURL = "https://api.odcloud.kr/api/15119741/v1/uddi:fe904caf-636f-4a49-aa94-e9064a446b3e"; //실제 API데이터를 가져오는 URL
    static final String myServiceKey = "By8%2BzbzlZwxRaJwkLoTWe7rgJIYf3TIkEnbrCY5mNB8f3clGoYgnY8J7f5C8bDSD1p21ek7oJoGHFbWhwRMRhw%3D%3D";//API키 >> 본인 키로 변경
    //추가
    public String saveChargerInfoByName(String chargerName) {
        StringBuffer result = new StringBuffer();
        try {
            String apiUrl = realDataURL + "?serviceKey=" + myServiceKey + "&page=1&perPage=100"; // 실제 API URL과 파라미터 수정 필요
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
            // JSON 파싱 및 DB 저장
            JSONObject jsonObject = new JSONObject(result.toString());
            JSONArray dataArray = jsonObject.getJSONArray("data");

            boolean found = false;

            int count = 0;

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject dataObject = dataArray.getJSONObject(i);
                if(dataObject.getString("충전소명").equals(chargerName)){
                    FavoriteEntity favoriteEntity = new FavoriteEntity();
                    favoriteEntity.setChargerName(dataObject.getString("충전소명"));
                    favoriteEntity.setChargerAddress(dataObject.getString("주소"));
                    favoriteEntity.setChargerPower(dataObject.getString("급속충전량"));
                    favoriteEntity.setChargerType(dataObject.getString("충전기타입"));
                    favoriteRepository.save(favoriteEntity); // 데이터베이스에 저장
                    count++;
                }
            }
            System.out.println("총 검색결과 개수 = " + count);
            if (count == 0) { // 적어도 하나의 충전소명도 입력된 이름을 포함하지 않는 경우
                return "존재하지 않는 충전소입니다";
            }
            return "충전소 정보 저장 완료";
        } catch (Exception e) {
            e.printStackTrace();
            return "충전소 정보 저장 실패";
        }
    }//saveChargerInfoByName end
    //조회
    public List<FavoriteResponseDTO> findChargerInfoByName(/*나중에 여기에 사용자 아이디(이름)을 받아서 특정 회원의 즐겨찾기만 가져오도록 만들기*/) {
        List<FavoriteEntity> favoriteEntities = favoriteRepository.findAll();
        return favoriteEntities.stream()
                               .map(FavoriteResponseDTO::favoriteResponseDTO)
                               .collect(Collectors.toList());
    }//findChargerInfoByName end
    //삭제
    public String deleteChargerInfoById(Long id) {
        favoriteRepository.deleteById(id);
        return "즐겨찾기 삭제 완료";
    }//deleteChargerInfoById end

}