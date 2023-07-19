package com.korea.k2.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public void insert(ProductVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("PRODUCT.INSERT",vo);
	}

	@Override
	public List<ProductVO> selectAll(ProductVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("PRODUCT.SELECTALL",vo);
	}

	@Override
	public ProductVO selectOne(ProductVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("PRODUCT.SELECTONE",vo);
	}

	@Override
	public void delete(ProductVO vo) {
		// TODO Auto-generated method stub
		mybatis.delete("PRODUCT.DELETE",vo);
	}

}
