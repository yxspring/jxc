package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.entity.OverflowListGoods;
import com.java1234.repository.OverflowListGoodsRepository;
import com.java1234.service.OverflowListGoodsService;

/**
 * 报溢单商品Service实现类
 * @author java1234_小锋老师
 *
 */
@Service("overflowListGoodsService")
public class OverflowListGoodsServiceImpl implements OverflowListGoodsService{

	@Resource
	private OverflowListGoodsRepository overflowListGoodsRepository;

	@Override
	public List<OverflowListGoods> listByOverflowListId(Integer overflowListId) {
		return overflowListGoodsRepository.listByOverflowListId(overflowListId);
	}

	

}
