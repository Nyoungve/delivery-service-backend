package org.delivery.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreStatus {
    //등록 대기, 등록완료, 해지 대기/해지 신청, 해지완료 시스템이 더 명확하긴 함.
    REGISTERED("등록"),

    UNREGISTERED("해지")
    ;

    private final String registered;

}
