package org.delivery.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreCategory {
    //중식, 양식, 한식, 일식, 치킨, 피자, 햄버거, 커피&디저트
    CHINESE_FOOD("중식", "중식"),
    WESTERN_FOOD("양식", "양식"),
    KOREAN_FOOD("한식", "한식"),
    JAPANESE_FOOD("일식", "일식"),
    CHICKEN("치킨", "치킨"),
    PIZZA("피자,", "피자"),
    HAMBURGER("햄버거", "햄버거"),
    COFFEE_AND_DESSERT("커피&디저트", "커피&디저트")
    ;

    private String display;
    private String description;
}
