package com.korea.k2.product;

import java.util.List;

public interface ProductService {
	public void insert(ProductVO vo);
	public List<ProductVO> selectAll(ProductVO vo);
	public ProductVO selectOne(ProductVO vo);
	public void delete(ProductVO vo);
}
