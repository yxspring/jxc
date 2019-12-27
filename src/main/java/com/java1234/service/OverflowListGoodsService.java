package com.java1234.service;

import java.util.List;

import com.java1234.entity.OverflowListGoods;

/**
 * 报溢单商品Service接口
 * @author java1234_小锋老师
 *
 */
public interface OverflowListGoodsService {

	/**
	 * 根据报溢单id查询所有报溢单商品
	 * @param overflowListId
	 * @return
	 */
	public List<OverflowListGoods> listByOverflowListId(Integer overflowListId);


}
