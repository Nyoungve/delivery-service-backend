package org.delivery.api.domain.store.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.store.StoreEntity;
import org.delivery.db.store.StoreRepository;
import org.delivery.db.store.enums.StoreCategory;
import org.delivery.db.store.enums.StoreStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Store 도메인 로직을 처리하는 서비스
 */
@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    //유효한 스토어 가져오기
    public StoreEntity getStoreWithThrow(Long id){
        var entity = storeRepository.findFirstByIdAndStatusOrderByIdDesc(id,StoreStatus.REGISTERED);
        return entity.orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT));
    }

    //스토어 등록
    public StoreEntity register(StoreEntity storeEntity){
        return Optional.ofNullable(storeEntity)
                .map(it -> {
                    storeEntity.setStatus(StoreStatus.REGISTERED);
                    storeEntity.setStar(0);
                    //TODO 등록일시 추가하기

                    return storeRepository.save(it);
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "Store Entity Null"));
    }
    //카테고리로 스토어 검색
    public List<StoreEntity> searchByCategory(StoreCategory category){
        var entityList = storeRepository.findAllByStatusAndCategoryOrderByStarDesc(
                StoreStatus.REGISTERED,
                category
        );
        return entityList;
    }


    //전체 스토어
    public List<StoreEntity> registerStore(){
        var entityList = storeRepository.findAllByStatusOrderByIdDesc(StoreStatus.REGISTERED);
        return entityList;
    }


}
