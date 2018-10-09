package com.yushu.service.impl;

import com.yushu.mapper.HsCardkindMapper;
import com.yushu.model.HsCardkind;
import com.yushu.service.CardKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CardKindServiceImpl implements CardKindService {
    @Autowired
    HsCardkindMapper hsCardkindMapper;

    @Override
    public int addOne(HsCardkind card) {
        return hsCardkindMapper.insertSelective(card);
    }
}
