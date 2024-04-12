package com.encore.bbabap.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CarType {
    // 참고 : https://gear-up3.com/%EC%B6%A9%EC%A0%84-%EB%B0%A9%EC%8B%9D%EA%B3%BC-%EC%B6%A9%EC%A0%84%EA%B5%AC-%EA%B7%9C%EA%B2%A9-%EC%A0%84%EA%B8%B0%EC%B0%A8-%EC%B6%A9%EC%A0%84%EA%B8%B0-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0-2-%EA%B8%89/
    A_TYPE("AC 단상 (5핀)"),
    B_TYPE(" AC 3상 (7핀)"),
    C_TYPE("DC 콤보 (CCS)"),
    D_TYPE("CHAdeMO"),
    E_TYPE("테슬라 NACS");

    CarType(String message) {

    }
}
