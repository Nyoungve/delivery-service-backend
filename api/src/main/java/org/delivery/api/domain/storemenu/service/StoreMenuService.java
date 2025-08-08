package org.delivery.api.domain.storemenu.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.db.storemenu.StoreMenuRepository;
import org.delivery.db.storemenu.enums.StoreMenuStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StoreMenuService {

    private final StoreMenuRepository storeMenuRepository;

    //유효현 스토어 메뉴 가져오기
    public StoreMenuEntity getStoreMenuWithThrow(Long id){
        var entity = storeMenuRepository.findFirstByIdAndStatusOrderByIdDesc(id, StoreMenuStatus.REGISTERED);
        return entity.orElseThrow(() ->  new ApiException(ErrorCode.NULL_POINT));
    }

    //특정가게 메뉴들 가져오기
    public List<StoreMenuEntity> getStoreMenuByStoreId(Long StroeId){
        var entityList = storeMenuRepository.findAllByStoreIdAndStatusOrderBySequenceDesc(
                StroeId,
                StoreMenuStatus.REGISTERED
        );
        return entityList;
    }

    //스토어 메뉴 등록
    public StoreMenuEntity register(StoreMenuEntity storeMenuEntity){
        return Optional.ofNullable(storeMenuEntity)
                .map(it -> {
                    storeMenuEntity.setStatus(StoreMenuStatus.REGISTERED);
                    return storeMenuRepository.save(it);
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "Store Menu Entity Null"));

    }


}
